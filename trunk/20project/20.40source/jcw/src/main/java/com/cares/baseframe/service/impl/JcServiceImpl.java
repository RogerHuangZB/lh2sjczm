package com.cares.baseframe.service.impl;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.mapper.JcMapper;
import com.cares.baseframe.model.Jc;
import com.cares.baseframe.service.JcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JcServiceImpl implements JcService {

    private static Logger LOGGER = LoggerFactory.getLogger(JcServiceImpl.class);

    @Autowired
    private JcMapper jcMapper;

    @Override
    public void addJc(Jc jc) {
        jcMapper.insert(jc);
    }

    @Override
    public void deleteJcById(Long id) {
        jcMapper.deleteJcById(id);
    }

    @Override
    public void updateJc(Jc jc) {
        jcMapper.updateJc(jc);
    }

    @Override
    public Jc findJcById(Long id) {
        return jcMapper.findJcById(id);
    }

    @Override
    public void findDataGrid(PageInfo pageInfo) {
        pageInfo.setRows(jcMapper.findJcPageCondition(pageInfo));
        pageInfo.setTotal(jcMapper.findJcPageCount(pageInfo));
    }
}
