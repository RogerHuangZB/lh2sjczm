package com.cares.baseframe.mapper;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.JcType;
import com.cares.baseframe.model.JcTypeTree;

import java.util.List;

/**
 * Created by Roger on 2017/8/26.
 */
public interface JcTypeMapper {

    //增
    void insert(JcType jcType);

    //删
    void deleteJcTypeById(Long typeId);

    //改
    void updateJcType(JcType jcType);

    //查
    JcType findJcTypeById(Long typeId);

    //分页
    List findJcTypePageCondition(PageInfo pageInfo);
    int findJcTypePageCount(PageInfo pageInfo);

    List<JcType> jcTypeDataAll();

    List<JcTypeTree> findRootJcTypes();

    List<JcTypeTree> findChildJcTypes(Long typePid);
}
