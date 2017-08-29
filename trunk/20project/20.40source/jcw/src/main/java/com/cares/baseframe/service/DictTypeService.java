package com.cares.baseframe.service;

import java.util.List;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.DictType;

/**
 * @description：指令时间设置
 * @author：
 * @date：
 */
public interface DictTypeService {
    void findDataGrid(PageInfo pageInfo);

    void addCodeDictType(DictType codeDictType);

    DictType findCodeDictTypeById(Long id);

    void updateCodeDictType(DictType codeDictType);

    void deleteCodeDictTypeById(Long id);

    List<DictType> queryType();


}
