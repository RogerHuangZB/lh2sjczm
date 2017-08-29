package com.cares.baseframe.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cares.baseframe.Constant;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.RoleBean;
import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.bean.UserRoleBean;
import com.cares.baseframe.bean.UserVo;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.Role;
import com.cares.baseframe.service.RoleService;
import com.cares.baseframe.service.UserService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @description：用户管理
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;   
    @Autowired
    private RoleService roleService;

    /**
     * 用户管理页
     *
     * @return
     */
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public String manager() {
        return "/sysManage/user";
    }

    /**
     * 用户管理列表
     *
     * @param userVo
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    
    public PageInfo dataGrid(UserVo userVo, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = Maps.newHashMap();
        if (StringUtils.isNoneBlank(userVo.getLoginName())) {
            condition.put("loginName", userVo.getLoginName());
        }
        if (StringUtils.isNoneBlank(userVo.getName())) {
            condition.put("userName", userVo.getName());
        }
        if (userVo.getDeptId() != null) {
            condition.put("organizationId", userVo.getDeptId());
        }
        if (userVo.getCreatedateStart() != null) {
            condition.put("startTime", userVo.getCreatedateStart());
        }
        if (userVo.getCreatedateEnd() != null) {
            condition.put("endTime", userVo.getCreatedateEnd());
        }
        pageInfo.setCondition(condition);
        
        if (Constant.SUPER_ADMIN.equals(getCurrentUser().getLoginName().toUpperCase())) {//超级管理员
         	condition.put("dept_id", null);
         	condition.put("pid", null);
 		}else { 			
 			Set<UserRoleBean> userRoles = getCurrentUser().getUserRoleBeans();
			boolean flag = false; //机场管理员标志
			if (userRoles != null && userRoles.size() > 0) {
				for (UserRoleBean uRole : userRoles) {
					 RoleBean rl = uRole.getRole();
					if (Constant.UNIT_ADMIN.equals(rl.getUniqueCode().toUpperCase())) {
						flag = true;	
						condition.put("dept_id", null);
						condition.put("pid", getCurrentUser().getDeptId());
						break;
					}
				}
			}
 			if (!flag) {
 				condition.put("dept_id", getCurrentUser().getDeptId());
 				condition.put("pid", null);
			}
 		}       
        
        userService.findDataGrid(pageInfo);
        List<UserVo> userList =(List<UserVo>) pageInfo.getRows();
        
        if(!CollectionUtils.isEmpty(userList)){
            for(UserVo vo: userList){
                List<Role>  roleList= roleService.queryUserRoleByUserId(vo.getId());
                vo.setRolesList(roleList);
            }
        }
        pageInfo.setRows(userList);
        return pageInfo;
    }

    /**
     * 添加用户页
     *
     * @return
     */
    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public String addPage() {
        return "/sysManage/userAdd";
    }

    /**
     * 添加用户
     *
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    
    public BaseResult add(UserVo userVo) {
        UserBean u = userService.findUserByLoginName(userVo.getLoginName());
        if (u != null) {
            return BaseResult.fail("用户名已存在!");
        }
        try {
        	if (userVo.getPassword().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z.;%_#@]{6,20}$")) {
	            userVo.setPassword(new BCryptPasswordEncoder().encode(userVo.getPassword()));
	            userService.addUser(userVo);
	            return BaseResult.success();
        	}else{
                return BaseResult.fail("添加失败,密码应由6-20位数字、字母、符号组合");
        	}
        } catch (RuntimeException e) {
        	LOGGER.error(e.getMessage());
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 编辑用户页
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(Long id, Model model) {
        UserVo userVo = userService.findUserVoById(id);
        List<Role> rolesList = userVo.getRolesList();
        List<Long> ids = Lists.newArrayList();
        for (Role role : rolesList) {
            ids.add(role.getRoleId());
        }
        model.addAttribute("roleIds", ids);
        model.addAttribute("user", userVo);
        return "/sysManage/userEdit";
    }

    /**
     * 编辑用户
     *
     * @param userVo
     * @return
     */
    @RequestMapping("/edit")
    
    public BaseResult edit(UserVo userVo) {
        UserBean user = userService.findUserByLoginName(userVo.getLoginName());
        if (user != null && user.getUserId() != userVo.getId()) {
            return BaseResult.fail("用户名已存在!");
        }
        try {
        	
        	if(userVo.getPassword()!=null && !userVo.getPassword().trim().equals("")){
        		if(userVo.getPassword().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z.;%_#@]{6,20}$")){
        			userVo.setPassword(new BCryptPasswordEncoder().encode(userVo.getPassword()));
        		}else{
                    return BaseResult.fail( "密码格式有误");
        		}
            }
        	userService.updateUser(userVo);
        	return BaseResult.success();
        } catch (RuntimeException e) {
            LOGGER.error("修改用户失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 修改密码页
     *
     * @return
     */
    @RequestMapping(value = "/editPwdPage", method = RequestMethod.GET)
    public String editPwdPage() {
        return "/sysManage/userEditPwd";
    }

    /**
     * 修改密码
     *
     * @param request
     * @param oldPwd
     * @param pwd
     * @return
     */
    @RequestMapping("/editUserPwd")
    
    public BaseResult editUserPwd(HttpServletRequest request, String oldPwd, String pwd) {
        if (!new BCryptPasswordEncoder().matches(oldPwd, getCurrentUser().getUserPwd())) {
            return BaseResult.fail("老密码不正确!");
        }

        try {
			if (pwd.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z.;%_#@]{6,20}$")) {
				userService.updateUserPwdById(getUserId(),
						new BCryptPasswordEncoder().encode(pwd));
				return BaseResult.success();
			}else{
				LOGGER.error("修改密码失败：{}", "位数应在6--20之间");
	            return BaseResult.fail( "修改密码失败,密码应由6-20位数字、字母、符号组合");
			}
        } catch (Exception e) {
            LOGGER.error("修改密码失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    
    public BaseResult delete(Long id) {
        try {
            userService.deleteUserById(id);
            return BaseResult.success();
        } catch (RuntimeException e) {
            LOGGER.error("删除用户失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 验证用户
     *
     * @param loginName
     * @return
     */
    @RequestMapping("/isUserExist")
    public BaseResult isUserExist(String loginName) {
        UserBean u = userService.findUserByLoginName(loginName);
        if (u != null) {
            return BaseResult.fail("用户名已存在!");
        }else{
            return BaseResult.success();
        }
    }

    /**
     * 注册用户
     *
     * @param userVo
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public BaseResult register(UserVo userVo) {
        UserBean u = userService.findUserByLoginName(userVo.getLoginName());
        if (u != null) {
            return BaseResult.fail("用户名已存在!");
        }
        try {
            if (userVo.getPassword().matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z.;%_#@]{6,20}$")) {
                userVo.setPassword(new BCryptPasswordEncoder().encode(userVo.getPassword()));
                userVo.setName("customer");
                userVo.setDeptId(99L);
                userVo.setSex(0);
                userVo.setStatus(0);
                userVo.setRoleIds("1");
                userService.addUser(userVo);
                return BaseResult.success();
            }else{
                return BaseResult.fail("添加失败,密码应由6-20位数字、字母、符号组合");
            }
        } catch (RuntimeException e) {
            LOGGER.error(e.getMessage());
            return BaseResult.fail(e.getMessage());
        }
    }
}
