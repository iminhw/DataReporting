package com.cap.datareporting.component.shiro;

import com.cap.datareporting.entity.SysRolePermission;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.SysUserRole;
import com.cap.datareporting.common.enums.StatusEnum;
import com.cap.datareporting.service.*;
import com.cap.datareporting.common.utils.ShiroUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.CodecSupport;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 02:32
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private SysUserService userService;
    @Resource
    private SysRoleService roleService;
    @Resource
    private SysUserRoleService userRoleService;
    @Resource
    private SysRolePermissionService rolePermissionService;
    @Resource
    private SysPermissionService permissionService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象
        SysUser user = userService.findByUsername(username);
//        System.err.println("----->>username=" + user.getUsername() + "---" + user.getPassword()+"---"+user.getSalt());
        if (user == null) {
            throw new UnknownAccountException();
        } else if (user.getStatus().equals(StatusEnum.FREEZED.getCode())) {
            // 冻结
            throw new LockedAccountException();
        } else if (user.getStatus().equals(StatusEnum.DELETE.getCode())) {
//            DELETE
            throw new UnknownAccountException();
        }
        // 对盐进行加密处理
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());

        /* 传入密码自动判断是否正确
         * 参数1：传入对象给Principal
         * 参数2：正确的用户密码
         * 参数3：加盐处理
         * 参数4：固定写法
         */
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                salt,
                //realm name
                getName()
        );
        return authenticationInfo;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        Long uid = sysUser.getId();
        List<SysUserRole> list = userRoleService.findUserRoleByUid(uid);
        for (SysUserRole userrole : list) {
            Long rolid = userrole.getRoleId();
            authorizationInfo.addRole(roleService.selectByPrimaryKey(rolid).getName());
            // 使用log更好
//            System.out.println("role 权 限 --> " + roleService.selectByPrimaryKey(rolid).getName());

            List<SysRolePermission> rolePermissionList = rolePermissionService.findRolePermissionByRid(rolid);
            for (SysRolePermission p : rolePermissionList) {
                authorizationInfo.addStringPermission(permissionService.findPermissionByid(
                        p.getPermissionId()).getPermission());

//                System.out.println("permission 权 限 --> " +
//                        permissionService.findPermissionByid(p.getPermissionId()).getPermission());
            }
        }
        return authorizationInfo;
    }

    /**
     * 自定义密码验证匹配器
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        setCredentialsMatcher(new SimpleCredentialsMatcher() {
            @Override
            public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
                UserPassOpenIdToken token = (UserPassOpenIdToken) authenticationToken;
                SimpleAuthenticationInfo info = (SimpleAuthenticationInfo) authenticationInfo;
                // 获取明文密码及密码盐
                String password = String.valueOf(token.getPassword());
                String salt = CodecSupport.toString(info.getCredentialsSalt().getBytes());
                // 第三放登陆
                if ("1".equals(token.getLoginType())) {
                    return true;
                }
                return equals(ShiroUtil.encrypt(password, salt), info.getCredentials());
            }
        });
    }

}
