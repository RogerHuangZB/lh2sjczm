package com.cares.baseframe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.Resource;
import com.cares.baseframe.service.ResourceService;



/**
 * @description：资源管理
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/resource")
public class ResourceController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private ResourceService resourceService;

    /**
     * 菜单树
     *
     * @return
     */
    @RequestMapping(value = "/tree", method = RequestMethod.POST)
    
    public List<Tree> tree() {
        UserBean currentUser = getCurrentUser();
        List<Tree> tree = resourceService.findTree(currentUser);
        return tree;
    }


    /**
     * 资源管理列表
     *
     * @return
     */
    @RequestMapping(value = "/treeGrid", method = RequestMethod.POST)
    public List<Resource> treeGrid() {
        List<Resource> treeGrid = resourceService.findResourceAll();
        return treeGrid;
    }


    /**
     * 添加资源
     *
     * @param resource
     * @return
     */
    @RequestMapping("/add")
    
    public BaseResult add(Resource resource) {
        try {
            resourceService.addResource(resource);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("添加资源失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 二级资源树
     *
     * @return
     */
    @RequestMapping("/allTree")
    
    public List<Tree> allTree() {
        return resourceService.findAllTree();
    }

    /**
     * 三级资源树
     *
     * @return
     */
    @RequestMapping(value = "/allTrees", method = RequestMethod.POST)
    
    public List<Tree> allTrees() {
        return resourceService.findAllTrees();
    }

    /**
     * 编辑资源页
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/editPage")
    public Resource editPage( Long id) {
        return resourceService.findResourceById(id);
    }

    /**
     * 编辑资源
     *
     * @param resource
     * @return
     */
    @RequestMapping("/edit")
    
    public BaseResult edit(Resource resource) {
        try {
            resourceService.updateResource(resource);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("编辑资源失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除资源
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    
    public BaseResult delete(Long id) {
        try {
            resourceService.deleteResourceById(id);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除资源失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

}
