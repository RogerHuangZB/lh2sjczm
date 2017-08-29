package com.cares.baseframe.service;

import java.util.List;
import java.util.Map;

import com.cares.baseframe.bean.DeptAgentVo;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.DeptAgent;

public interface DeptAgentService {
	/**
	 * 根据主键删除
	 * @param deptAgentId
	 * @return
	 */
	int deleteByPrimaryKey(Long deptAgentId);
	/**
	 * 插入所有
	 * @param record
	 * @return
	 */
    int insert(DeptAgent record);
    /**
     * 插入所选
     * @param record
     * @return
     */
    int insertSelective(DeptAgent record);
    /**
     * 根据主键查询
     * @param deptAgentId
     * @return
     */
    DeptAgent selectByPrimaryKey(Long deptAgentId);
    /**
     * 根据主键更新选定项
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(DeptAgent record);
    /**
     * 根据主键更新所有
     * @param record
     * @return
     */
    int updateByPrimaryKey(DeptAgent record);
    /**
     * 分页查询
     * @param pageInfo
     * @return
     */
    void findDeptAgentByPage(PageInfo pageInfo);
    /**
     * 根据map条件查询DeptAgent
     * @param paramMap
     * @return
     */
    List<DeptAgent> findDeptAgentByParam(Map<String,Object> paramMap);
    
    List<DeptAgentVo> findDeptAgentVoByParam(Map<String,Object> paramMap);
    /**
     * 根据部门Id删除
     * @param deptAgentId
     * @return
     */
    int deleteByDeptId(Long deptId);
}
