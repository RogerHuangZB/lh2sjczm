package com.cares.baseframe.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.mapper.DictTypeMapper;
import com.cares.baseframe.model.DictType;
import com.cares.baseframe.service.DictTypeService;

@Service
public class DictTypeServiceImpl implements DictTypeService {

    private static Logger LOGGER = LoggerFactory.getLogger(DictTypeServiceImpl.class);
    @Autowired
    private DictTypeMapper dictTypeMapper;


    @Override
    public void findDataGrid(PageInfo pageInfo) {

        pageInfo.setRows(dictTypeMapper.findCodeDictTypePageCondition(pageInfo));
        pageInfo.setTotal(dictTypeMapper.findCodeDictTypePageCount(pageInfo));
    }


    @Override
    public void addCodeDictType(DictType codeDictType) {
        dictTypeMapper.insert(codeDictType);
        
    }


    @Override
    public DictType findCodeDictTypeById(Long id) {
        return dictTypeMapper.findCodeDictTypeById(id);
    }


    @Override
    public void updateCodeDictType(DictType codeDictType) {
        dictTypeMapper.updateCodeDictType(codeDictType);
        
    }


    @Override
    public void deleteCodeDictTypeById(Long id) {
        dictTypeMapper.deleteCodeDictTypeById(id);
        
    }


    @Override
    public List<DictType> queryType() {
       return  dictTypeMapper.findDictTypeAll();
    }




}
