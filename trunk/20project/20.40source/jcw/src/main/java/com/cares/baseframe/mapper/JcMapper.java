package com.cares.baseframe.mapper;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.Jc;

import java.util.List;

/**
 * Created by Roger on 2017/8/26.
 */
public interface JcMapper {

    //增
    void insert(Jc jc);

    //删
    void deleteJcById(Long jcId);

    //改
    void updateJc(Jc jc);

    //查
    Jc findJcById(Long jcId);

    //分页
    List findJcPageCondition(PageInfo pageInfo);
    int findJcPageCount(PageInfo pageInfo);
}
