package com.cares.baseframe.mapper;

import java.util.List;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.DictType;



public interface DictTypeMapper {


    List findCodeDictTypePageCondition(PageInfo pageInfo);

    int findCodeDictTypePageCount(PageInfo pageInfo);

    void insert(DictType codeDictType);

    DictType findCodeDictTypeById(Long id);

    void updateCodeDictType(DictType codeDictType);

    void deleteCodeDictTypeById(Long id);

    List<DictType> findDictTypeAll();
    
}