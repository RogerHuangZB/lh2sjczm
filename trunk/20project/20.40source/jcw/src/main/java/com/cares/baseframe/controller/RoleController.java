package com.cares.baseframe.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cares.baseframe.Constant;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.RoleBean;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.bean.UserRoleBean;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.Role;
import com.cares.baseframe.service.RoleService;
import com.google.common.collect.Maps;

/**
 * @description：权限管理
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 权限列表
     *
     * @param role
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    
    public PageInfo dataGrid(Role role, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = Maps.newHashMap();
        if (Constant.SUPER_ADMIN.equals(getCurrentUser().getLoginName().toUpperCase())) {//超级管理员
        	condition.put("deptId", null);
        	condition.put("pid", null);
		}else {
			Set<UserRoleBean> userRoles = getCurrentUser().getUserRoleBeans();
			boolean flag = false; //机场管理员标志
			if (userRoles != null && userRoles.size() > 0) {
				for (UserRoleBean uRole : userRoles) {
					RoleBean rl = uRole.getRole();
					if (Constant.UNIT_ADMIN.equals(rl.getUniqueCode().toUpperCase())) {
						flag = true;
						condition.put("deptId", null);
						condition.put("pid", getCurrentUser().getDeptId());
						break;
					}
				}
			}
			if (!flag) {
				condition.put("deptId", getCurrentUser().getDeptId());
				condition.put("pid", null);  
			}			      	
		}        
        pageInfo.setCondition(condition);
        roleService.findDataGrid(pageInfo);
        return pageInfo;
    }

    /**
     * 权限树
     *
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    
    public List<Tree> tree(HttpServletRequest request) {
    	Map<String, String> paraMap = null;
    	String deptId = request.getParameter("deptId"); //获取页面传值的单位ID
    	if (Constant.SUPER_ADMIN.equals(getCurrentUser().getLoginName().toUpperCase())) {//超级管理员
    		if (StringUtils.isBlank(deptId)) {
    			return roleService.findTree(paraMap);
			}else {
				paraMap = Maps.newHashMap();
				paraMap.put("deptId", deptId);
				return roleService.findTree(paraMap);
			}
    		
		}else { //非超级管理员
			paraMap = Maps.newHashMap();
			Set<UserRoleBean> userRoles = getCurrentUser().getUserRoleBeans();
			boolean flag = false; //机场管理员标志
			if (userRoles != null && userRoles.size() > 0) {
				for (UserRoleBean uRole : userRoles) {
					RoleBean rl = uRole.getRole();
					if (Constant.UNIT_ADMIN.equals(rl.getUniqueCode().toUpperCase())) {
						flag = true;	
						if (StringUtils.isBlank(deptId)) {
							paraMap.put("pid", getCurrentUser().getDeptId().toString());
						}else {
							paraMap.put("deptId", deptId);
						}
						
						break;
					}
				}
			}
			if (!flag) {
				if (StringUtils.isBlank(deptId)) {
					paraMap.put("deptId", getCurrentUser().getDeptId().toString());
				}else {
					paraMap.put("deptId", deptId);
				}
				
			}			
			return roleService.findTree(paraMap);
		}
       
    }

    /**
     * 添加权限页
     *
     * @return
     */
    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public String addPage() {
        return "/sysManage/roleAdd";
    }

    /**
     * 添加权限
     *
     * @param role
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    
    public BaseResult add(Role role) {
        try {       
        	role.setValidity("1");
        	role.setCreator(getUserId());
            roleService.addRole(role);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("添加角色失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除权限
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    
    public BaseResult delete(Long id) {
        try {
            roleService.deleteRoleById(id);
            /*Role role=new Role();
            role.setRoleId(id);
            role.setValidity("0");
            roleService.updateRole(role);*/
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除角色失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 编辑权限页
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/editPage")
    public String editPage(HttpServletRequest request, Long id) {
        Role role = roleService.findRoleById(id);
        request.setAttribute("role", role);
        return "/sysManage/roleEdit";
    }

    /**
     * 编辑权限
     *
     * @param role
     * @return
     */
    @RequestMapping("/edit")
    
    public BaseResult edit(Role role) {
        try {        	
        	role.setModifier(getUserId());
            roleService.updateRole(role);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("编辑角色失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 授权页面
     *
     * @param request
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/grantPage")
    public String grantPage(HttpServletRequest request, Long id, Model model) {
        model.addAttribute("id", id);
        return "/sysManage/roleGrant";
    }

    /**
     * 授权页面页面根据角色查询资源
     *
     * @param request
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/findResourceIdListByRoleId")
    
    public BaseResult findResourceByRoleId(HttpServletRequest request, Long id, Model model) {
        try {
            List<Long> resources = roleService.findResourceIdListByRoleId(id);
            return BaseResult.success(resources);
        } catch (RuntimeException e) {
            logger.error("角色查询资源失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 授权
     *
     * @param id
     * @param resourceIds
     * @return
     */
    @RequestMapping("/grant")
    
    public BaseResult grant(Long id, String resourceIds) {
        try {
            roleService.updateRoleResource(id, resourceIds);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("授权成功失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

}
