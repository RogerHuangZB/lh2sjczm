package com.cares.baseframe.core.dao.mapper;

import java.io.Serializable;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public abstract interface BaseMapper<T extends Serializable> extends Mapper<T>,MySqlMapper<T>,ConditionMapper<T>{

}
