package com.cares.baseframe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cares.baseframe.model.Resource;


public interface ResourceMapper {
    /**
     * 添加资源
     *
     * @param resource
     * @return
     */
    int insert(Resource resource);

    /**
     * 修改资源
     *
     * @param resource
     * @return
     */
    int updateResource(Resource resource);

    /**
     * 查询菜单资源
     *
     * @param resourceType
     * @param pid
     * @return
     */
    List<Resource> findResourceAllByTypeAndPid(@Param("type") Integer resourceType, @Param("pid") Long pid);

    /**
     * 查询所有资源
     *
     * @return
     */
    List<Resource> findResourceAll();

    /**
     * 查询一级资源
     *
     * @param resourceMenu
     * @return
     */
    List<Resource> findResourceAllByTypeAndPidNull(Integer resourceMenu);

    /**
     * 根据id查询资源
     *
     * @param id
     * @return
     */
    Resource findResourceById(Long id);

    /**
     * 删除资源
     *
     * @param id
     * @return
     */
    int deleteResourceById(Long id);
}