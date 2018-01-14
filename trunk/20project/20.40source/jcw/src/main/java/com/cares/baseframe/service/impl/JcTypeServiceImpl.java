package com.cares.baseframe.service.impl;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.mapper.JcTypeMapper;
import com.cares.baseframe.model.JcType;
import com.cares.baseframe.model.JcTypeTree;
import com.cares.baseframe.service.JcTypeService;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JcTypeServiceImpl implements JcTypeService {

    private static Logger LOGGER = LoggerFactory.getLogger(JcTypeServiceImpl.class);

    @Autowired
    private JcTypeMapper jcTypeMapper;

    @Override
    public void addJcType(JcType jcType) {
        jcTypeMapper.insert(jcType);
    }

    @Override
    public void deleteJcTypeById(Long id) {
        jcTypeMapper.deleteJcTypeById(id);
    }

    @Override
    public void updateJcType(JcType jcType) {
        jcTypeMapper.updateJcType(jcType);
    }

    @Override
    public JcType findJcTypeById(Long typeId) {
        return jcTypeMapper.findJcTypeById(typeId);
    }

    @Override
    public void findDataGrid(PageInfo pageInfo) {
        pageInfo.setRows(jcTypeMapper.findJcTypePageCondition(pageInfo));
        pageInfo.setTotal(jcTypeMapper.findJcTypePageCount(pageInfo));
    }

    @Override
    public List<JcType> jcTypeDataAll() {
        return jcTypeMapper.jcTypeDataAll();
    }

    @Override
    public List<JcTypeTree> getJcTypeTree() {
        List<JcTypeTree> rootTypes = jcTypeMapper.findRootJcTypes();
        if (rootTypes == null) {
            return null;
        }
        rcChildJcTypes(rootTypes);

        return rootTypes;
    }

    /**
     * 递归树查询
     * @param parentTypeList
     * return
    */
    private void rcChildJcTypes(List<JcTypeTree> parentTypeList) {
        if (parentTypeList == null) {
            return;
        }
        for (JcTypeTree parentType : parentTypeList) {
            List<JcTypeTree> childTypes = jcTypeMapper.findChildJcTypes(parentType.getTypeId());
            rcChildJcTypes(childTypes);
            parentType.setChildren(childTypes);
        }
    }
}
