package com.cares.baseframe.mapper;

import com.cares.baseframe.model.JcPic;

import java.util.List;

/**
 * Created by Roger on 2017/10/18.
 */
public interface JcPicMapper {

    void insert(JcPic jcPic);

    void deleteJcPicById(Long id);

    void updateJcPic(JcPic jcPic);

    List<JcPic> queryJcPics(Long jcId);

    void deleteJcPic(JcPic jcPic);
}
