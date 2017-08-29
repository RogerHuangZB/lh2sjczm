package com.cares.baseframe.service;

import java.util.List;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.model.DictCode;

/**
 * @description：指令时间设置
 * @author：
 * @date：
 */
public interface DictCodeService {
    void findDataGrid(PageInfo pageInfo);

    void addDictCode(DictCode dictCode);

    DictCode findDictCodeById(Long id);

    void updateDictCode(DictCode dictCode);

    void deleteDictCodeById(Long id);

	List<DictCode> queryIpcType();
	
	

}
