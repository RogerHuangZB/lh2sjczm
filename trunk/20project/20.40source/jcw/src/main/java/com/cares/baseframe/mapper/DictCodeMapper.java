package com.cares.baseframe.mapper;

import java.util.List;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.DictCode;


public interface DictCodeMapper {


    void insert(DictCode dictCode);

    DictCode findDictCodeById(Long id);

    void updateDictCode(DictCode dictCode);

    void deleteDictCodeById(Long id);

    List findDictCodePageCondition(PageInfo pageInfo);

    int findDictCodePageCount(PageInfo pageInfo);

	List<DictCode> findIpcTypeAll();
	
	
	/**
	 * 查询业务编码
	 * @param dictCode
	 * @return
	 */
	List<DictCode> findCodeValueAll(DictCode dictCode);
	/**
	 * 根据typeCode查询
	 * @param typeCode
	 * @return
	 */
	List<DictCode> findDictByTypeCode(String typeCode);

	
    
}