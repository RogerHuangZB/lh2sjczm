package com.cares.baseframe.service;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.JcType;

public interface JcTypeService {

    void addJcType(JcType jcType);

    void deleteJcTypeById(Long typeId);

    void updateJcType(JcType jcType);

    JcType findJcTypeById(Long typeId);

    void findDataGrid(PageInfo pageInfo);
}
