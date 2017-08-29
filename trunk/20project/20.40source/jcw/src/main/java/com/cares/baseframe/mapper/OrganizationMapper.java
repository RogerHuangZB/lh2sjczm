package com.cares.baseframe.mapper;

import java.util.List;
import java.util.Map;

import com.cares.baseframe.bean.Organization;
import com.cares.baseframe.bean.PageInfo;



public interface OrganizationMapper {
    /**
     * 删除部门
     *
     * @param id
     * @return
     */
    int deleteOrganizationById(Long id);

    /**
     * 添加部门
     *
     * @param organization
     * @return
     */
    Long insert(Organization organization);

    /**
     * 更新部门
     *
     * @param organization
     * @return
     */
    int updateOrganization(Organization organization);

    /**
     * 查询一级部门
     *
     * @return
     */
    List<Organization> findOrganizationAllByPidNull();
    /**
     * 查询所在部门
     *
     * @return
     */
    List<Organization> findOrganizationAllByAptCd(Map<String, String> paraMap);

    /**
     * 查询部门子集
     *
     * @param pid
     * @return
     */
    List<Organization> findOrganizationAllByPid(Long pid);

    /**
     * 查询部门集合
     * @paraMap 
     * @return
     */
    List<Organization> findOrganizationAll(Map<String, Object> paraMap);

    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    Organization findOrganizationById(Long id);
    
    /**
     * 根据deptId查询部门
     *
     * @param id
     * @return
     */
    Organization findOrganizationByDeptId(Long deptId);
    
    List<Organization> findOriganzationByPage(PageInfo pageInfo);
    
    int findOriganzationByPageCount(PageInfo pageInfo);
}