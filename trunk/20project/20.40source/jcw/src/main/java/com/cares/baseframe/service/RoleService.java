package com.cares.baseframe.service;

import java.util.List;
import java.util.Map;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.model.Role;

/**
 * @description：权限管理
 * @author：
 * @date：
 */
public interface RoleService {
    /**
     * 查询权限列表
     *
     * @param pageInfo
     */
    void findDataGrid(PageInfo pageInfo);

    /**
     * 查询权限树
     *
     * @return
     */
    List<Tree> findTree(Map<String, String> paraMap);

    /**
     * 添加权限
     *
     * @param role
     */
    void addRole(Role role);

    /**
     * 根据id删除权限
     *
     * @param id
     */
    void deleteRoleById(Long id);

    /**
     * 根据id查询权限
     *
     * @param id
     * @return
     */
    Role findRoleById(Long id);

    /**
     * 更新权限
     *
     * @param role
     */
    void updateRole(Role role);

    /**
     * 根据权限id查询资源集合
     *
     * @param id
     * @return
     */
    List<Long> findResourceIdListByRoleId(Long id);

    /**
     * 更新权限和资源的关联关系
     *
     * @param id
     * @param resourceIds
     */
    void updateRoleResource(Long id, String resourceIds);

    /**
     * 根据用户查询id查询权限集合
     *
     * @param userId
     * @return
     */
    List<Long> findRoleIdListByUserId(Long userId);


    /**
     * 根据权限查询id查询资源路径集合
     *
     * @param roleId
     * @return
     */
   List<Map<Long, String>> findRoleResourceListByRoleId(Long roleId);

    List<Role> queryUserRoleByUserId(Long id);

}
