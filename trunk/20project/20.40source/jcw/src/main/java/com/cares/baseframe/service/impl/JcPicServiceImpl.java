package com.cares.baseframe.service.impl;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.mapper.JcPicMapper;
import com.cares.baseframe.model.JcPic;
import com.cares.baseframe.service.JcPicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JcPicServiceImpl implements JcPicService {

    private static Logger LOGGER = LoggerFactory.getLogger(JcPicServiceImpl.class);

    @Autowired
    private JcPicMapper jcPicMapper;

    @Override
    public void addJcPic(JcPic jcPic) {
        jcPicMapper.insert(jcPic);
    }

    @Override
    public void deleteJcPicById(Long id) {
        jcPicMapper.deleteJcPicById(id);
    }

    @Override
    public void updateJcPic(JcPic jcPic) {
        jcPicMapper.updateJcPic(jcPic);
    }

    @Override
    public List<JcPic> findJcPicsByJcId(Long jcId) {
        return jcPicMapper.queryJcPics(jcId);
    }
}
