package com.cares.baseframe.service;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.Jc;

public interface JcService {

    void addJc(Jc jc);

    void deleteJcById(Long jcId);

    void updateJc(Jc jc);

    Jc findJcById(Long jcId);

    void findDataGrid(PageInfo pageInfo);
}
