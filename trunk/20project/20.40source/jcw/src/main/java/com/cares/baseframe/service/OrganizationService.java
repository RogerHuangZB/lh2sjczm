package com.cares.baseframe.service;

import java.util.List;
import java.util.Map;

import com.cares.baseframe.bean.Organization;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.model.Carrier;

/**
 * @description：部门管理
 * @author：
 * @date：
 */
public interface OrganizationService {
    /**
     * 查询部门资源树
     *
     * @return
     */
    List<Tree> findTree(Map<String, String> paraMap);

    /**
     * 查询部门数据表格
     *
     * @return
     */
    List<Organization> findTreeGrid(Map<String, Object> paraMap);

    /**
     * 添加部门
     *
     * @param organization
     */
    Long addOrganization(Organization organization);

    /**
     * 根据id查找部门
     *
     * @param id
     * @return
     */
    Organization findOrganizationById(Long id);

    /**
     * 更新部门
     *
     * @param organization
     */
    void updateOrganization(Organization organization);

    /**
     * 根据id删除部门
     *
     * @param id
     */
    void deleteOrganizationById(Long id);
    
    /**
     * 分页查询部门
     * @param pageInfo
     * @return
     */
    void queryOrganizationByPage(PageInfo pageInfo);
    
    List<String> queryAllCarrier();
    
    /**
     * 按条件查询承运人数
     * @param carrier
     * @return
     */
    int countCarrierByParam(Carrier carrier);
    

}
