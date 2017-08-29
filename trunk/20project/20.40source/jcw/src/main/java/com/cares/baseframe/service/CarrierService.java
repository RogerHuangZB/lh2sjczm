package com.cares.baseframe.service;

import java.util.List;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.Carrier;


public interface CarrierService {
	/**
	 * 根据主键删除
	 * @param carrierId
	 * @return
	 */
	int deleteByPrimaryKey(Long carrierId);
	/**
	 * 插入所有
	 * @param record
	 * @return
	 */
    int insert(Carrier record);
    /**
     * 插入所选
     * @param record
     * @return
     */
    int insertSelective(Carrier record);
    /**
     * 根据主键查询
     * @param carrierId
     * @return
     */
    Carrier selectByPrimaryKey(Long carrierId);
    /**
     * 根据主键更新选定项
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Carrier record);
    /**
     * 根据主键更新所有
     * @param record
     * @return
     */
    int updateByPrimaryKey(Carrier record);
    /**
     * 分页查询
     * @param pageInfo
     * @return
     */
    void findCarrierByPage(PageInfo pageInfo);
    
    List<Carrier> fingCarrierByparam(String param);
    
    List<Carrier> findall();
}
