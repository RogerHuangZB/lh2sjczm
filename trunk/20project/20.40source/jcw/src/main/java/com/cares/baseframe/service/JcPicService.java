package com.cares.baseframe.service;

import com.cares.baseframe.model.JcPic;

import java.util.List;

/**
 * Created by Roger on 2017/10/18.
 */
public interface JcPicService {

    void addJcPic(JcPic jcPic);

    void deleteJcPicById(Long picId);

    void updateJcPic(JcPic jcPic);

    List<JcPic> findJcPicsByJcId(Long jcId);
}
