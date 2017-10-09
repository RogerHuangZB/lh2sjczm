package com.cares.baseframe.service;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.JcBrand;

import java.util.List;

public interface JcBrandService {

    void addJcBrand(JcBrand jcBrand);

    void deleteJcBrandById(Long brandId);

    void updateJcBrand(JcBrand jcBrand);

    JcBrand findJcBrandById(Long brandId);

    void findDataGrid(PageInfo pageInfo);

    List<JcBrand> jcBrandDataAll(Long brandId);
}
