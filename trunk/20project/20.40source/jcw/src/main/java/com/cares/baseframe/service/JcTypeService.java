package com.cares.baseframe.service;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.Tree;
import com.cares.baseframe.model.JcType;
import com.cares.baseframe.model.JcTypeTree;

import java.util.List;

public interface JcTypeService {

    void addJcType(JcType jcType);

    void deleteJcTypeById(Long typeId);

    void updateJcType(JcType jcType);

    JcType findJcTypeById(Long typeId);

    void findDataGrid(PageInfo pageInfo);

    List<JcType> jcTypeDataAll();

    List<JcTypeTree> getJcTypeTree();
}
