package com.cares.baseframe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cares.baseframe.Constant;
import com.cares.baseframe.bean.DeptAgentVo;
import com.cares.baseframe.bean.Organization;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.RoleBean;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.bean.UserRoleBean;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.Carrier;
import com.cares.baseframe.model.DeptAgent;
import com.cares.baseframe.service.CarrierService;
import com.cares.baseframe.service.DeptAgentService;
import com.cares.baseframe.service.OrganizationService;
import com.google.common.collect.Maps;

/**
 * @description：部门管理
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/organization")
public class OrganizationController extends BaseController {

    private static Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationService organizationService;
    
    @Autowired
    private DeptAgentService deptAgentService;
    
    @Autowired
    private CarrierService carrierService;


    /**
     * 部门资源树
     *
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    
    public List<Tree> tree() {
        List<Tree> trees = null;
        Map<String, String> paraMap = null;
        if (Constant.SUPER_ADMIN.equals(getCurrentUser().getLoginName().toUpperCase())) {
        	trees = organizationService.findTree(paraMap);
		}else {
			paraMap = new HashMap<String, String>();
			Set<UserRoleBean> userRoles = getCurrentUser().getUserRoleBeans();
			boolean flag = false; //机场管理员标志
			if (userRoles != null && userRoles.size() > 0) {
				for (UserRoleBean uRole : userRoles) {
					RoleBean rl = uRole.getRole();
					if (Constant.UNIT_ADMIN.equals(rl.getUniqueCode().toUpperCase())) {
						flag = true;	
						if (Constant.FIRST_LEVEL_CONTANT.equals(getCurrentUser().getOrg().getDeptType())) { //一级节点
							paraMap.put("deptId", getCurrentUser().getDeptId().toString());
						}else {
							//TODO:
							paraMap.put("deptId", getCurrentUser().getOrg().getDeptPid().toString());
						}						
						paraMap.put("validity", Constant.VALIDITY_CONTANT);
						break;
					}
				}
			}
			if (!flag) {
				paraMap.put("aptCd", getCurrentUser().getOrg().getAptCd());			
				paraMap.put("validity", Constant.VALIDITY_CONTANT);
				paraMap.put("deptId", getCurrentUser().getDeptId().toString());
			}			
			trees = organizationService.findTree(paraMap);
		}
        return trees;
    }

    /**
     * 部门列表
     *
     * @return
     */
    @RequestMapping("/treeGrid")
    
    public List<Organization> treeGrid() {
    	List<Organization> treeGrid = null;
    	Map<String, Object> paraMap = null;
    	if (Constant.SUPER_ADMIN.equals(getCurrentUser().getLoginName().toUpperCase())) {//超级管理员
         	treeGrid = organizationService.findTreeGrid(paraMap);
 		}else {
 			paraMap = Maps.newHashMap();
 			Set<UserRoleBean> userRoles = getCurrentUser().getUserRoleBeans();
			boolean flag = false; //机场管理员标志
			if (userRoles != null && userRoles.size() > 0) {
				for (UserRoleBean uRole : userRoles) {
					RoleBean rl = uRole.getRole();
					if (Constant.UNIT_ADMIN.equals(rl.getUniqueCode().toUpperCase())) {
						flag = true;
			 			paraMap.put("aptCd", getCurrentUser().getOrg().getAptCd().toUpperCase());
						break;
					}
				}
			}
 			if (!flag) {
 				paraMap.put("deptId", getCurrentUser().getDeptId());
			}
 			
 			treeGrid = organizationService.findTreeGrid(paraMap);
 		}       
         
        return treeGrid;
    }

    /**
     * 部门查询列表
     * @param Organization
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    
    public PageInfo dataGrid(Organization organization, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = Maps.newHashMap();
        if (StringUtils.isNoneBlank(organization.getAptCd())) {
            condition.put("aptCd", organization.getAptCd() );
        }
        if (StringUtils.isNoneBlank(organization.getDeptType())) {
            condition.put("deptType", organization.getDeptType());
        }
        if (StringUtils.isNoneBlank(organization.getCarrier())) {
            condition.put("carrier", organization.getCarrier());
        }        
        if (StringUtils.isNoneBlank(organization.getDeptName())) {
            condition.put("deptName", organization.getDeptName());
        }
        if (StringUtils.isNoneBlank(organization.getOrgType())) {
            condition.put("orgType", organization.getOrgType());
        }
        pageInfo.setCondition(condition);
        organizationService.queryOrganizationByPage(pageInfo);
        return pageInfo;
    }
    
   
    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    
    public BaseResult delete(Long id) {
        try {
            organizationService.deleteOrganizationById(id);
            deptAgentService.deleteByDeptId(id);
            return BaseResult.success();
        } catch (RuntimeException e) {
            LOGGER.info("删除部门失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    
    
    @RequestMapping("/queryAllCarrierCode")
    
    public List<String> queryAllCarrierCode() {
        try {
        	List<String>  list = organizationService.queryAllCarrier();
            return list;
        } catch (RuntimeException e) {
            LOGGER.error("查询全部承运人信息失败：{}", e);
            return null;
        }
    } 
    
    /**
     * 添加机场代理人
     *
     * @param organization
     * @return
     */
    @RequestMapping("/addAirportAgent")
    
    public BaseResult addAirportAgent(Organization organization,Long airportId,String agentCarrier) {
        try {
        	organization.setValidity(Constant.VALIDITY_CONTANT);
        	organization.setCreator(getUserId());
        	organization.setDeptCode("");
        	organizationService.addOrganization(organization);
        	System.out.println(organization.getDeptId());
        	DeptAgent deptAgent=new DeptAgent();
        	deptAgent.setDeptId(organization.getDeptId());
        	deptAgent.setAirportId(airportId);
        	deptAgent.setCarrier(agentCarrier);
        	deptAgentService.insert(deptAgent);
            return BaseResult.success();
        } catch (RuntimeException e) {
            LOGGER.info("添加机场代理人失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    /**
     * 编辑机场代理人页
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/editAirportAgentPage")
    public Organization editAirportAgentPage (Model model, Long id) {
        Organization organization = organizationService.findOrganizationById(id);
        Map<String,Object> paramMap=new HashMap<String,Object>();
        paramMap.put("deptId", id);
        List<DeptAgent> deptAgentList=deptAgentService.findDeptAgentByParam(paramMap);
        organization.setDeptAgentList(deptAgentList);
        return organization;
    }
    
    /**
     * 编辑机场代理人
     *
     * @param organization
     * @return
     */
    @RequestMapping("/editAirportAgent")
    
    public BaseResult editAirportAgent(Organization organization,Long airportId,String agentCarrier,Long deptAgentId) {
        try {
        	organization.setValidity(Constant.VALIDITY_CONTANT);
        	organization.setModifier(getUserId());
        	organization.setDeptCode("");
            organizationService.updateOrganization(organization);
            DeptAgent deptAgent=new DeptAgent();
        	deptAgent.setDeptId(organization.getDeptId());
        	deptAgent.setAirportId(airportId);
        	deptAgent.setCarrier(agentCarrier);
        	deptAgent.setDeptAgentId(deptAgentId);
        	deptAgentService.updateByPrimaryKey(deptAgent);
            return BaseResult.success();
        } catch (RuntimeException e) {
            LOGGER.info("编辑部门失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    /**
     * 条件查询承运人个数
     * @param carrier
     * @return
     */
    @RequestMapping("/countCarrier")
    
    public Integer countCarrierCode(Carrier carrier) {
        return organizationService.countCarrierByParam(carrier);
    }

    
    /**
     * 添加管理单位
     *
     * @param organization
     * @return
     */
    @RequestMapping("/addManager")
    
    public BaseResult addManager(Organization organization) {
        try {
        	organization.setValidity(Constant.VALIDITY_CONTANT);
        	organization.setCreator(getUserId());
        	organization.setAptCd("");
        	organization.setDeptCode("");
        	organization.setOrgType("3");
        	organizationService.addOrganization(organization);
            return BaseResult.success();
        } catch (RuntimeException e) {
            LOGGER.info("添加机场代理人失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    /**
     * 编辑管理单位页
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/editManagerPage")
    public Organization editManagerPage (Model model, Long id) {
        Organization organization = organizationService.findOrganizationById(id);
        return organization;
    }
    
    /**
     * 编辑管理单位
     *
     * @param organization
     * @return
     */
    @RequestMapping("/editManager")
    public BaseResult editManager(Organization organization) {
        try {
        	organization.setValidity(Constant.VALIDITY_CONTANT);
        	organization.setModifier(getUserId());
        	organization.setAptCd("");
        	organization.setDeptCode("");
            organizationService.updateOrganization(organization);
            return BaseResult.success();
        } catch (RuntimeException e) {
            LOGGER.info("编辑部门失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    /**
     * 添加航空公司
     *
     * @param organization
     * @return
     */
    @RequestMapping("/addAirline")
    
    public BaseResult addAirline(Organization organization) {
        try {
        	organization.setValidity(Constant.VALIDITY_CONTANT);
        	organization.setCreator(getUserId());
        	organization.setAptCd("");
        	organization.setDeptCode("");
        	organizationService.addOrganization(organization);
            return BaseResult.success(organization.getDeptId());
        } catch (RuntimeException e) {
            LOGGER.info("添加机场代理人失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    /**
     * 编辑航空公司页
     *
     * @param organization
     * @return
     */
    @RequestMapping("/editAirlinePage")
    public Organization editAirlinePage( Long id) {
        return organizationService.findOrganizationById(id);
    }
    
    /**
     * 编辑航空公司
     *
     * @param organization
     * @return
     */
    @RequestMapping("/editAirline")
    
    public BaseResult editAirline(Organization organization) {
        try {
        	organization.setValidity(Constant.VALIDITY_CONTANT);
        	organization.setCreator(getUserId());
        	organization.setDeptCode("");
        	organization.setAptCd("");
        	organizationService.updateOrganization(organization);
            return BaseResult.success();
        } catch (RuntimeException e) {
            LOGGER.info("编辑航空公司失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    /**
     * 根据部门id获取 机场+carrier
     *
     * @param organization
     * @return
     */
    @RequestMapping("/getAirportCarrier")
    
    public List<DeptAgentVo> getAirportCarrier(Long deptId) {
    	Map<String,Object> paramMap=new HashMap<String, Object>();
    	paramMap.put("deptId", deptId);
    	return deptAgentService.findDeptAgentVoByParam(paramMap);
       
    }
    
    /**
     * 航空公司—>编辑 页
     *
     * @param organization
     * @return
     */
    @RequestMapping("/airlineAgentPage")
    public String airlineAgentPage(Model model,Long deptId) {
    	Organization organization = organizationService.findOrganizationById(deptId);
    	if(organization!=null){
    		model.addAttribute("organization", organization);
    	}
    	Map<String,Object> paramMap=new HashMap<String, Object>();
    	paramMap.put("deptId", deptId);
    	List<DeptAgentVo> deptAgentList =deptAgentService.findDeptAgentVoByParam(paramMap);
    	if(deptAgentList.size()>0){
    		model.addAttribute("deptAgentList", deptAgentList);
    	}
    	
        return "/sysManage/airline_agent";
    }
    
    /**
     * 航空公司--机场代理 编辑
     *
     * @param organization map <>
     * @return
     */
    @RequestMapping("/airlineAgent")
    
    public BaseResult airlineAgent(@RequestBody DeptAgent[] deptAgentList) {
		try {
			if (deptAgentList.length > 0) {
				Long deptId = deptAgentList[0].getDeptId();
				deptAgentService.deleteByDeptId(deptId);
				for (int i = 0; i < deptAgentList.length; i++) {
					DeptAgent deptAgent = new DeptAgent();
					deptAgent.setDeptId(deptId);
					deptAgent.setAirportId(deptAgentList[i].getAirportId());
					deptAgent.setCarrier(deptAgentList[i].getCarrier());
					deptAgentService.insert(deptAgent);
				}
			}
			return BaseResult.success();
		} catch (RuntimeException e) {
			LOGGER.info("添加机场代理人失败：{}", e);
			return BaseResult.fail(e.getMessage());
		}
	}
   
    /**
     * 查询承运人
     *
     * @param id
     * @return
     */
    @RequestMapping("/queryAll")
    
    public List<Carrier> queryAll(String param) {
        	List<Carrier>  list = carrierService.fingCarrierByparam(param);
            return list;
    } 
   
}
