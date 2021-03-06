package com.cares.baseframe.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cares.baseframe.ServiceException;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.RoleBean;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.mapper.RoleMapper;
import com.cares.baseframe.mapper.RoleResourceMapper;
import com.cares.baseframe.mapper.UserRoleMapper;
import com.cares.baseframe.model.Role;
import com.cares.baseframe.model.RoleResource;
import com.cares.baseframe.service.RoleService;
import com.google.common.collect.Lists;

@Service
public class RoleServiceImpl implements RoleService {

    private static Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleResourceMapper roleResourceMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public void findDataGrid(PageInfo pageInfo) {
        pageInfo.setRows(roleMapper.findRolePageCondition(pageInfo));
        pageInfo.setTotal(roleMapper.findRolePageCount(pageInfo));
    }

    @Override
    public List<Tree> findTree(Map<String, String> paraMap) {
        List<Tree> trees = Lists.newArrayList();
        List<RoleBean> roles = roleMapper.findRoleAllByDeptId(paraMap);
        
        for (RoleBean role : roles) {
            Tree tree = new Tree();
            tree.setId(role.getRoleId());
            tree.setText(role.getRoleName());

            trees.add(tree);
        }
        return trees;
    }

    @Override
    public void addRole(Role role) {
        int insert = roleMapper.insert(role);
        if (insert != 1) {
            LOGGER.warn("插入失败，参数：{}", role.toString());
            throw new ServiceException("插入失败");
        }
    }

    @Override
    public void deleteRoleById(Long id) {
        int delete = roleMapper.deleteRoleById(id);
        if (delete != 1) {
            LOGGER.warn("删除失败，id：{}", id);
            throw new ServiceException("删除失败");
        }
    }

    @Override
    public Role findRoleById(Long id) {
        return roleMapper.findRoleById(id);
    }

    @Override
    public void updateRole(Role role) {
        int update = roleMapper.updateRole(role);
        if (update != 1) {
            LOGGER.warn("更新失败，参数：{}", role.toString());
            throw new ServiceException("更新失败");
        }
    }

    @Override
    public List<Long> findResourceIdListByRoleId(Long id) {
        return roleMapper.findResourceIdListByRoleId(id);
    }

    @Override
    public void updateRoleResource(Long id, String resourceIds) {
        // 先删除后添加,有点暴力
        List<Long> roleResourceIdList = roleMapper.findRoleResourceIdListByRoleId(id);
        if (roleResourceIdList != null && (!roleResourceIdList.isEmpty())) {
            for (Long roleResourceId : roleResourceIdList) {
                roleResourceMapper.deleteById(roleResourceId);
            }
        }
        String[] resources = resourceIds.split(",");
        RoleResource roleResource = new RoleResource();
        for (String resourceId : resources) {
            roleResource.setRoleId(id);
            roleResource.setResourceId(Long.parseLong(resourceId));
            roleResourceMapper.insert(roleResource);
        }
    }

    @Override
    public List<Long> findRoleIdListByUserId(Long userId) {
        return userRoleMapper.findRoleIdListByUserId(userId);
    }


    @Override
    public List<Map<Long, String>> findRoleResourceListByRoleId(Long roleId) {
        return roleMapper.findRoleResourceListByRoleId(roleId);
    }

    @Override
    public List<Role> queryUserRoleByUserId(Long id) {
        return roleMapper.queryUserRoleByUserId(id); 
    }

}
