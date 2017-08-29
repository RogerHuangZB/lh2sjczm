package com.cares.baseframe.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cares.baseframe.Constant;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.mapper.CarrierMapper;
import com.cares.baseframe.model.Carrier;
import com.cares.baseframe.service.CarrierService;

@Service
public class CarrierServiceImpl implements CarrierService{
	
	private final static Logger logger=LoggerFactory.getLogger(CarrierServiceImpl.class);
	@Autowired
	private CarrierMapper carrierMapper;
	@Override
	public int deleteByPrimaryKey(Long carrierId) {
		return carrierMapper.deleteByPrimaryKey(carrierId);
	}

	@Override
	public int insert(Carrier record) {
		record.setValidity(Constant.VALIDITY);
		return carrierMapper.insert(record);
	}

	@Override
	public int insertSelective(Carrier record) {
		return carrierMapper.insertSelective(record);
	}

	@Override
	public Carrier selectByPrimaryKey(Long carrierId) {
		return carrierMapper.selectByPrimaryKey(carrierId);
	}

	@Override
	public int updateByPrimaryKeySelective(Carrier record) {
		return carrierMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Carrier record) {
		return carrierMapper.updateByPrimaryKey(record);
	}

	@Override
	public void findCarrierByPage(PageInfo pageInfo) {
		pageInfo.setRows(carrierMapper.findCarrierByPage(pageInfo));
		pageInfo.setTotal(carrierMapper.findCarrierByPageCount(pageInfo));
	}

	@Override
	public List<Carrier> fingCarrierByparam(String param) {
		return carrierMapper.queryCarrierByParam(param);
	}

	@Override
	public List<Carrier> findall() {
		return carrierMapper.selectAll();
	}

}
