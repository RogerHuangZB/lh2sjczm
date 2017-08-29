package com.cares.baseframe.mapper;

import java.util.List;
import java.util.Map;

import com.cares.baseframe.bean.DeptAgentVo;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.DeptAgent;


public interface DeptAgentMapper {
    int deleteByPrimaryKey(Long deptAgentId);

    int insert(DeptAgent record);

    int insertSelective(DeptAgent record);

    DeptAgent selectByPrimaryKey(Long deptAgentId);

    int updateByPrimaryKeySelective(DeptAgent record);

    int updateByPrimaryKey(DeptAgent record);
    
    List<DeptAgent> findDeptAgentByPage(PageInfo pageInfo);
    
    int findDeptAgentByPageCount(PageInfo pageInfo);
    /**
     * 根据map查询  DeptAgent
     * @param paramMap
     * @return
     */
    List<DeptAgent> fingDeptAgentByParam(Map<String,Object> paramMap);
    /**
     * 根据map查询  DeptAgentVo
     * @param paramMap
     * @return
     */
    List<DeptAgentVo> fingDeptAgentVoByParam(Map<String,Object> paramMap);
    
    int deleteByDeptId(Long deptId);
}