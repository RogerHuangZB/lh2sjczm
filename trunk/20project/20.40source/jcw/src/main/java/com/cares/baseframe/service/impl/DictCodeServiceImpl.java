package com.cares.baseframe.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.mapper.DictCodeMapper;
import com.cares.baseframe.model.DictCode;
import com.cares.baseframe.service.DictCodeService;


@Service
public class DictCodeServiceImpl implements DictCodeService {

	private static Logger LOGGER = LoggerFactory.getLogger(DictCodeServiceImpl.class);
	@Autowired
	private DictCodeMapper dictCodeMapper;

	@Override
	public void findDataGrid(PageInfo pageInfo) {

		pageInfo.setRows(dictCodeMapper.findDictCodePageCondition(pageInfo));
		pageInfo.setTotal(dictCodeMapper.findDictCodePageCount(pageInfo));
	}

	@Override
	public void addDictCode(DictCode dictCode) {
		dictCodeMapper.insert(dictCode);

	}

	@Override
	public DictCode findDictCodeById(Long id) {
		return dictCodeMapper.findDictCodeById(id);
	}

	@Override
	public void updateDictCode(DictCode dictCode) {
		dictCodeMapper.updateDictCode(dictCode);
	}

	@Override
	public void deleteDictCodeById(Long id) {
		dictCodeMapper.deleteDictCodeById(id);

	}

	@Override
	public List<DictCode> queryIpcType() {
		return dictCodeMapper.findIpcTypeAll();
	}

	

}
