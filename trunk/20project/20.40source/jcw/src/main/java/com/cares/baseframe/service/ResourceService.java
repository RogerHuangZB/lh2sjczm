package com.cares.baseframe.service;

import java.util.List;

import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.model.Resource;
import com.cares.baseframe.model.User;

/**
 * @description：资源管理
 * @author：
 * @date：
 */
public interface ResourceService {

    /**
     * 根据用户查询树形菜单列表
     *
     * @param currentUser
     * @return
     */
    List<Tree> findTree(UserBean currentUser);

    /**
     * 查询所有资源
     *
     * @return
     */
    List<Resource> findResourceAll();

    /**
     * 添加资源
     *
     * @param resource
     */
    void addResource(Resource resource);

    /**
     * 查询二级数
     *
     * @return
     */
    List<Tree> findAllTree();

    /**
     * 查询三级数
     *
     * @return
     */
    List<Tree> findAllTrees();

    /**
     * 更新资源
     *
     * @param resource
     */
    void updateResource(Resource resource);

    /**
     * 根据id查询资源
     *
     * @param id
     * @return
     */
    Resource findResourceById(Long id);

    /**
     * 根据id删除资源
     *
     * @param id
     */
    void deleteResourceById(Long id);

}
