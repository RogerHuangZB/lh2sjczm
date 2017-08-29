package com.cares.baseframe.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cares.baseframe.bean.DeptAgentVo;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.mapper.DeptAgentMapper;
import com.cares.baseframe.model.DeptAgent;
import com.cares.baseframe.service.DeptAgentService;

@Service
public class DeptAgentServiceImpl implements DeptAgentService{
	
	private final static Logger logger=LoggerFactory.getLogger(DeptAgentServiceImpl.class);
	@Autowired 
	private DeptAgentMapper deptAgentMapper;
	
	@Override
	public int deleteByPrimaryKey(Long deptAgentId) {
		return deptAgentMapper.deleteByPrimaryKey(deptAgentId);
	}

	@Override
	public int insert(DeptAgent record) {
		return deptAgentMapper.insert(record);
	}

	@Override
	public int insertSelective(DeptAgent record) {
		return deptAgentMapper.insertSelective(record);
	}

	@Override
	public DeptAgent selectByPrimaryKey(Long deptAgentId) {
		return deptAgentMapper.selectByPrimaryKey(deptAgentId);
	}

	@Override
	public int updateByPrimaryKeySelective(DeptAgent record) {
		return deptAgentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DeptAgent record) {
		
		return deptAgentMapper.updateByPrimaryKey(record);
	}

	@Override
	public void findDeptAgentByPage(PageInfo pageInfo) {
		pageInfo.setRows(deptAgentMapper.findDeptAgentByPage(pageInfo));
		pageInfo.setTotal(deptAgentMapper.findDeptAgentByPageCount(pageInfo));
	}

	@Override
	public List<DeptAgentVo> findDeptAgentVoByParam(Map<String, Object> paramMap) {
		return deptAgentMapper.fingDeptAgentVoByParam(paramMap);
	}

	@Override
	public List<DeptAgent> findDeptAgentByParam(Map<String, Object> paramMap) {
		return deptAgentMapper.fingDeptAgentByParam(paramMap);
	}

	@Override
	public int deleteByDeptId(Long deptId) {
		return deptAgentMapper.deleteByDeptId(deptId);
	}

}
