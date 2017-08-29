package com.cares.baseframe.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.core.dao.mapper.BaseMapper;
import com.cares.baseframe.model.Carrier;



public interface CarrierMapper extends BaseMapper<Carrier>{
    
    List<Carrier> findCarrierByPage(PageInfo pageInfo);
    
    int findCarrierByPageCount(PageInfo pageInfo);
    
    List<String> findAllCarrier();
    
    int countCarrierByParam(Carrier carrier);
    
    List<Carrier> queryCarrierByParam(@Param(value="param")String param);
    
}