package com.cares.baseframe.mapper;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.JcType;

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
}
