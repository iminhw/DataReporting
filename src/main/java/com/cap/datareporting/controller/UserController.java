package com.cap.datareporting.controller;

import com.cap.datareporting.common.utils.PageBeen;
import com.cap.datareporting.entity.SysUser;
import com.cap.datareporting.service.SysRoleService;
import com.cap.datareporting.service.SysUserService;
import com.cap.datareporting.common.utils.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author minhw
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;
    /**
     * 列表页面
     */
    @RequestMapping("")
    @RequiresPermissions("admin/user/index")
    public String index(Model model) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "admin/user/index";
    }

    @PostMapping("/index")
    @RequiresPermissions("admin/user/index")
    @ResponseBody
    public PageBeen index(Model model, PageBeen pageBeen) {
        SysUser user = (SysUser) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return pageBeen;
    }

    /**
     * 跳转到添加页面
     */
    @GetMapping("/add")
    @RequiresPermissions("admin/user/add")
    public String toAdd() {
        return "/admin/user/add";
    }

    /**
     * 跳转到编辑页面
     */
    @GetMapping("/edit/{id}")
    @RequiresPermissions("admin/user/edit")
    public String toEdit(@PathVariable("id") SysUser user, Model model) {
        model.addAttribute("user", user);
        return "/admin/user/add";
    }

    /**
     * 保存添加/修改的数据
     *
     * @param valid 验证对象
     * @param user  实体对象
     */
//    @PostMapping("/save")
//    @RequiresPermissions({"admin/user/add", "admin/user/edit"})
//    @ResponseBody
//    public ResultEntity save(SysUser user) {
//
//        // 验证数据是否合格
//        if (user.getId() == null) {
//
//            // 判断密码是否为空
////            if (user.getPassword().isEmpty() || "".equals(user.getPassword().trim())) {
////                throw new ResultException(ResultEnum.USER_PWD_NULL);
////            }
////
////            // 判断两次密码是否一致
////            if (!user.getPassword().equals(valid.getConfirm())) {
////                throw new ResultException(ResultEnum.USER_INEQUALITY);
////            }
//
//            // 对密码进行加密
//            String salt = ShiroUtil.getRandomSalt();
//            String encrypt = ShiroUtil.encrypt(user.getPassword(), salt);
//            user.setPassword(encrypt);
////            user.setSalt(salt);
//        }
//
//        // 判断用户名是否重复
//        if (userService.repeatByUsername(user)) {
//            throw new ResultException(ResultEnum.USER_EXIST);
//        }
//
//        // 复制保留无需修改的数据
//        if (user.getId() != null) {
//            // 不允许操作超级管理员数据
//            if (user.getId().equals(AdminConst.ADMIN_ID) &&
//                    !ShiroUtil.getSubject().getId().equals(AdminConst.ADMIN_ID)) {
//                throw new ResultException(ResultEnum.NO_ADMIN_AUTH);
//            }
//
//            User beUser = userService.getById(user.getId());
//            String[] fields = {"password", "salt", "picture", "roles"};
//            EntityBeanUtil.copyProperties(beUser, user, fields);
//        }
//
//        // 保存数据
//        userService.save(user);
//        return ResultVoUtil.SAVE_SUCCESS;
//    }

    /**
     * 跳转到详细页面
     */
    @GetMapping("/detail/{id}")
    @RequiresPermissions("admin/user/detail")
    public String toDetail(@PathVariable("id") SysUser user, Model model) {
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    /**
     * 跳转到修改密码页面
     */
    @GetMapping("/pwd")
    @RequiresPermissions("admin/user/pwd")
    public String toEditPassword(Model model, @RequestParam(value = "ids", required = false) List<Long> ids) {
        model.addAttribute("idList", ids);
        return "admin/user/pwd";
    }

    /**
     * 修改密码
     */
//    @PostMapping("/pwd")
//    @RequiresPermissions("admin/user/pwd")
//    @ResponseBody
//    public ResultVo editPassword(String password, String confirm,
//                                 @RequestParam(value = "ids", required = false) List<Long> ids,
//                                 @RequestParam(value = "ids", required = false) List<User> users) {
//
//        // 判断密码是否为空
//        if (password.isEmpty() || "".equals(password.trim())) {
//            throw new ResultException(ResultEnum.USER_PWD_NULL);
//        }
//
//        // 判断两次密码是否一致
//        if (!password.equals(confirm)) {
//            throw new ResultException(ResultEnum.USER_INEQUALITY);
//        }
//
//        // 不允许操作超级管理员数据
//        if (ids.contains(AdminConst.ADMIN_ID) &&
//                !ShiroUtil.getSubject().getId().equals(AdminConst.ADMIN_ID)) {
//            throw new ResultException(ResultEnum.NO_ADMIN_AUTH);
//        }
//
//        // 修改密码，对密码进行加密
//        users.forEach(user -> {
//            String salt = ShiroUtil.getRandomSalt();
//            String encrypt = ShiroUtil.encrypt(password, salt);
//            user.setPassword(encrypt);
//            user.setSalt(salt);
//        });
//
//        // 保存数据
//        userService.save(users);
//        return ResultVoUtil.success("修改成功");
//    }


    /**
     * 跳转到角色分配页面
     */
//    @GetMapping("/role")
//    @RequiresPermissions("admin/user/role")
//    public String toRole(@RequestParam(value = "ids") User user, Model model) {
//        // 获取指定用户角色列表
//        Set<Role> authRoles = user.getRoles();
//        // 获取全部角色列表
//        Sort sort = new Sort(Sort.Direction.ASC, "createDate");
//        List<Role> list = roleService.getListBySortOk(sort);
//
//        model.addAttribute("id", user.getId());
//        model.addAttribute("list", list);
//        model.addAttribute("authRoles", authRoles);
//        return "/admin/user/role";
//    }

    /**
     * 保存角色分配信息
     */
//    @PostMapping("/role")
//    @RequiresPermissions("admin/user/role")
//    @ResponseBody
//    public ResultVo auth(
//            @RequestParam(value = "id", required = true) SysUser user,
//            @RequestParam(value = "roleId", required = false) HashSet<Role> roles) {
//
//        // 不允许操作超级管理员数据
//        if (user.getId().equals(AdminConst.ADMIN_ID) &&
//                !ShiroUtil.getSubject().getId().equals(AdminConst.ADMIN_ID)) {
//            throw new ResultException(ResultEnum.NO_ADMIN_AUTH);
//        }
//
//        // 更新用户角色
//        user.setRoles(roles);
//
//        // 保存数据
//        userService.save(user);
//        return ResultVoUtil.SAVE_SUCCESS;
//    }

    /**
     * 获取用户头像
     */
//    @GetMapping("/picture")
//    public void picture(String p, HttpServletResponse response) throws IOException {
//        String defaultPath = "/images/user-picture.jpg";
//        if (!(StringUtils.isEmpty(p) || p.equals(defaultPath))) {
//            UploadProjectProperties properties = SpringContextUtil.getBean(UploadProjectProperties.class);
//            String fuPath = properties.getFilePath();
//            String spPath = properties.getStaticPath().replace("*", "");
//            File file = new File(fuPath + p.replace(spPath, ""));
//            if (file.exists()) {
//                FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
//                return;
//            }
//        }
//        Resource resource = new ClassPathResource("static" + defaultPath);
//        FileCopyUtils.copy(resource.getInputStream(), response.getOutputStream());
//    }

    /**
     * 导出用户数据
     */
//    @GetMapping("/export")
//    @ResponseBody
//    public void exportExcel() {
//        UserRepository userRepository = SpringContextUtil.getBean(UserRepository.class);
//        ExcelUtil.exportExcel(SysUser.class, userRepository.findAll());
//    }

    /**
     * 设置一条或者多条数据的状态
     */
//    @RequestMapping("/status/{param}")
//    @RequiresPermissions("admin:user:status")
//    @ResponseBody
//    public ResultVo updateStatus(
//            @PathVariable("param") String param,
//            @RequestParam(value = "ids", required = false) List<Long> ids) {
//
//        // 不能修改超级管理员状态
//        if (ids.contains(AdminConst.ADMIN_ID)) {
//            throw new ResultException(ResultEnum.NO_ADMIN_STATUS);
//        }
//
//        // 更新状态
//        StatusEnum statusEnum = StatusUtil.getStatusEnum(param);
//        if (userService.updateStatus(statusEnum, ids)) {
//            return ResultVoUtil.success(statusEnum.getMessage() + "成功");
//        } else {
//            return ResultVoUtil.error(statusEnum.getMessage() + "失败，请重新操作");
//        }
//    }

    public static void main(String[] args) {
        String salt = ShiroUtil.getRandomSalt();
        String encrypt = ShiroUtil.encrypt("123456", salt);
        System.out.println("salt = " + salt);
        System.out.println("pwd = " + encrypt);
    }

}
