package com.cares.baseframe.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cares.baseframe.Config;
import com.cares.baseframe.Constant;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.mapper.ResourceMapper;
import com.cares.baseframe.mapper.RoleMapper;
import com.cares.baseframe.mapper.UserRoleMapper;
import com.cares.baseframe.model.Resource;
import com.cares.baseframe.service.ResourceService;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;


@Service
@SuppressWarnings("all")
public class ResourceServiceImpl implements ResourceService {

    private static Logger LOGGER = LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private ResourceMapper resourceMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Tree> findTree(UserBean user) {
        List<Tree> trees = Lists.newArrayList();
        // 超级管理
        if (Constant.SUPER_ADMIN.equals(user.getLoginName().toUpperCase())) {
            List<Resource> resourceFather = resourceMapper.findResourceAllByTypeAndPidNull(Config.RESOURCE_MENU);
            if (CollectionUtils.isEmpty(resourceFather)) {
                return null;
            }

            for (Resource resourceOne : resourceFather) {
                Tree treeOne = new Tree();

                treeOne.setId(resourceOne.getResId());
                treeOne.setText(resourceOne.getResName());
                treeOne.setIconCls(resourceOne.getResIcon());
                treeOne.setAttributes(resourceOne.getResUrl());
                List<Resource> resourceSon = resourceMapper.findResourceAllByTypeAndPid(Config.RESOURCE_MENU, resourceOne.getResId());

                if (resourceSon != null) {
                    List<Tree> tree = Lists.newArrayList();
                    for (Resource resourceTwo : resourceSon) {
                        Tree treeTwo = new Tree();
                        treeTwo.setId(resourceTwo.getResId());
                        treeTwo.setText(resourceTwo.getResName());
                        treeTwo.setIconCls(resourceTwo.getResIcon());
                        treeTwo.setAttributes(resourceTwo.getResUrl());
                        treeTwo.setSeq(resourceTwo.getSeqSort());
                        tree.add(treeTwo);
                    }
                    treeOne.setChildren(tree);                    
                    Collections.sort(tree,new Comparator<Tree>(){
                		@Override
                		public int compare(Tree o1, Tree o2) {                			
                			return o1.getSeq().compareTo(o2.getSeq());
                		}                    	   
                       });                    
                } else {
                    treeOne.setState("closed");
                }
                trees.add(treeOne);
            }
            return trees;
        }

        // 普通用户
        Set<Resource> resourceIdList = Sets.newHashSet();
        List<Long> roleIdList = userRoleMapper.findRoleIdListByUserId(user.getUserId());
        for (Long id : roleIdList) {
            List<Resource> resourceIdLists = roleMapper.findResourceIdListByRoleIdAndType(id);
            for (Resource resource: resourceIdLists) {
                resourceIdList.add(resource);
            }
        }
        for (Resource resource : resourceIdList) {
                if (resource != null && resource.getResPid() == null) {
                    Tree treeOne = new Tree();
                    treeOne.setId(resource.getResId());
                    treeOne.setText(resource.getResName());
                    treeOne.setIconCls(resource.getResIcon());
                    treeOne.setAttributes(resource.getResUrl());
                    treeOne.setSeq(resource.getSeqSort());
                    List<Tree> tree = Lists.newArrayList();
                    for (Resource resourceTwo : resourceIdList) {
                        if (resourceTwo.getResPid() != null && resource.getResId().longValue() == resourceTwo.getResPid().longValue()) {
                            Tree treeTwo = new Tree();
                            treeTwo.setId(resourceTwo.getResId());
                            treeTwo.setText(resourceTwo.getResName());
                            treeTwo.setIconCls(resourceTwo.getResIcon());
                            treeTwo.setAttributes(resourceTwo.getResUrl());
                            treeTwo.setSeq(resourceTwo.getSeqSort());
                            tree.add(treeTwo);
                        }
                    }        
                    
                    Collections.sort(tree,new Comparator<Tree>(){
                		@Override
                		public int compare(Tree o1, Tree o2) {                			
                			return o1.getSeq().compareTo(o2.getSeq());
                		}                    	   
                       });             
                    
                    treeOne.setChildren(tree);
                    trees.add(treeOne);
                }
        }
       Collections.sort(trees,new Comparator<Tree>(){
		@Override
		public int compare(Tree o1, Tree o2) {			
			return o1.getSeq().compareTo(o2.getSeq());
		}    	   
       });
        return trees;        
    }

    @Override
    public List<Resource> findResourceAll() {
        return resourceMapper.findResourceAll();
    }

    @Override
    public void addResource(Resource resource) {
        resourceMapper.insert(resource);
    }

    @Override
    public List<Tree> findAllTree() {
        List<Tree> trees = Lists.newArrayList();
        // 查询所有的一级树
        List<Resource> resources = resourceMapper.findResourceAllByTypeAndPidNull(Config.RESOURCE_MENU);
        if (resources == null) {
            return null;
        }
        for (Resource resourceOne : resources) {
            Tree treeOne = new Tree();

            treeOne.setId(resourceOne.getResId());
            treeOne.setText(resourceOne.getResName());
            treeOne.setIconCls(resourceOne.getResIcon());
            treeOne.setAttributes(resourceOne.getResUrl());
            // 查询所有一级树下的菜单
            List<Resource> resourceSon = resourceMapper.findResourceAllByTypeAndPid(Config.RESOURCE_MENU, resourceOne.getResId());

            if (resourceSon != null) {
                List<Tree> tree = Lists.newArrayList();
                for (Resource resourceTwo : resourceSon) {
                    Tree treeTwo = new Tree();
                    treeTwo.setId(resourceTwo.getResId());
                    treeTwo.setText(resourceTwo.getResName());
                    treeTwo.setIconCls(resourceTwo.getResIcon());
                    treeTwo.setAttributes(resourceTwo.getResUrl());
                    tree.add(treeTwo);
                }
                treeOne.setChildren(tree);
            } else {
                treeOne.setState("closed");
            }
            trees.add(treeOne);
        }
        return trees;
    }

    @Override
    public List<Tree> findAllTrees() {
        List<Tree> treeOneList = Lists.newArrayList();

        // 查询所有的一级树
        List<Resource> resources = resourceMapper.findResourceAllByTypeAndPidNull(Config.RESOURCE_MENU);
        if (resources == null) {
            return null;
        }

        for (Resource resourceOne : resources) {
            Tree treeOne = new Tree();

            treeOne.setId(resourceOne.getResId());
            treeOne.setText(resourceOne.getResName());
            treeOne.setIconCls(resourceOne.getResIcon());
            treeOne.setAttributes(resourceOne.getResUrl());

            List<Resource> resourceSon = resourceMapper.findResourceAllByTypeAndPid(Config.RESOURCE_MENU, resourceOne.getResId());

            if (resourceSon == null) {
                treeOne.setState("closed");
            } else {
                List<Tree> treeTwoList = Lists.newArrayList();

                for (Resource resourceTwo : resourceSon) {
                    Tree treeTwo = new Tree();

                    treeTwo.setId(resourceTwo.getResId());
                    treeTwo.setText(resourceTwo.getResName());
                    treeTwo.setIconCls(resourceTwo.getResIcon());
                    treeTwo.setAttributes(resourceTwo.getResUrl());

                    
                    List<Resource> resourceSons = resourceMapper.findResourceAllByTypeAndPid(Config.RESOURCE_BUTTON, resourceTwo.getResId());

                    if (resourceSons == null) {
                        treeTwo.setState("closed");
                    } else {
                        List<Tree> treeThreeList = Lists.newArrayList();

                        for (Resource resourceThree : resourceSons) {
                            Tree treeThree = new Tree();

                            treeThree.setId(resourceThree.getResId());
                            treeThree.setText(resourceThree.getResName());
                            treeThree.setIconCls(resourceThree.getResIcon());
                            treeThree.setAttributes(resourceThree.getResUrl());

                            treeThreeList.add(treeThree);
                        }
                        treeTwo.setChildren(treeThreeList);
                    }

                    treeTwoList.add(treeTwo);
                }
                treeOne.setChildren(treeTwoList);
            }

            treeOneList.add(treeOne);
        }
        return treeOneList;
    }

    @Override
    public void updateResource(Resource resource) {
        int update = resourceMapper.updateResource(resource);
        if (update != 1) {
            throw new RuntimeException("更新失败");
        }
    }

    @Override
    public Resource findResourceById(Long id) {
        return resourceMapper.findResourceById(id);
    }

    @Override
    public void deleteResourceById(Long id) {
        int delete = resourceMapper.deleteResourceById(id);
        if (delete == 0) {
            throw new RuntimeException("删除失败");
        }
    }



}
