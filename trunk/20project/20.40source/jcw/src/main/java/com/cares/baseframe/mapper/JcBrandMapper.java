package com.cares.baseframe.mapper;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.JcBrand;

import java.util.List;

/**
 * Created by Roger on 2017/8/26.
 */
public interface JcBrandMapper {

    //增
    void insert(JcBrand jcBrand);

    //删
    void deleteJcBrandById(Long brandId);

    //改
    void updateJcBrand(JcBrand jcBrand);

    //查
    JcBrand findJcBrandById(Long brandId);

    //分页
    List findJcBrandPageCondition(PageInfo pageInfo);
    int findJcBrandPageCount(PageInfo pageInfo);

    List<JcBrand> jcBrandDataAll();
}
