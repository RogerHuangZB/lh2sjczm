package com.cares.baseframe.service.impl;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.mapper.JcBrandMapper;
import com.cares.baseframe.model.JcBrand;
import com.cares.baseframe.service.JcBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JcBrandServiceImpl implements JcBrandService {

    private static Logger LOGGER = LoggerFactory.getLogger(JcBrandServiceImpl.class);

    @Autowired
    private JcBrandMapper jcBrandMapper;

    @Override
    public void addJcBrand(JcBrand jcBrand) {
        jcBrandMapper.insert(jcBrand);
    }

    @Override
    public void deleteJcBrandById(Long brandId) {
        jcBrandMapper.deleteJcBrandById(brandId);
    }

    @Override
    public void updateJcBrand(JcBrand jcBrand) {
        jcBrandMapper.updateJcBrand(jcBrand);
    }

    @Override
    public JcBrand findJcBrandById(Long brandId) {
        return jcBrandMapper.findJcBrandById(brandId);
    }

    @Override
    public void findDataGrid(PageInfo pageInfo) {
        pageInfo.setRows(jcBrandMapper.findJcBrandPageCondition(pageInfo));
        pageInfo.setTotal(jcBrandMapper.findJcBrandPageCount(pageInfo));
    }
}
