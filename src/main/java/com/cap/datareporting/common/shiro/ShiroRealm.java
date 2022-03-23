package com.cap.datareporting.common.shiro;

import com.cap.datareporting.entity.SysRolePermission;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.entity.SysUserRole;
import com.cap.datareporting.service.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: blog01
 * @description:
 * @author: MinHw or mz
 * @create: 2022-03-12 02:32
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RolePermissionService rolePermissionService;
    @Resource
    private PermissionService permissionService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象
        SysUser user = userService.findByUsername(username);
        System.err.println("----->>username=" + user.getUsername() + "---" + user.getPassword());
        if (user == null) {
            return null;
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                //realm name
                getName()
        );
        return authenticationInfo;
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser userinfo = (SysUser) principals.getPrimaryPrincipal();
        int uid = userinfo.getId();
        List<SysUserRole> list = userRoleService.findUserRoleByUid(uid);
        for (SysUserRole userrole : list) {
            int rolid = userrole.getRoleid();
            authorizationInfo.addRole(roleService.selectByPrimaryKey(rolid).getRole());
            // 使用log更好
            System.out.println("role 权 限 --> " + roleService.selectByPrimaryKey(rolid).getRole());

            List<SysRolePermission> rolePermissionList = rolePermissionService.findRolePermissionByRid(rolid);
            for (SysRolePermission p : rolePermissionList) {
                authorizationInfo.addStringPermission(permissionService.findPermissionByid(
                        p.getPermissionid()).getPermission());

                System.out.println("permission 权 限 --> " +
                        permissionService.findPermissionByid(p.getPermissionid()).getPermission());
            }
        }
        return authorizationInfo;
    }

}
