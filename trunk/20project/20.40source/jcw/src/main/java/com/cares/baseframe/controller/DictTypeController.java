package com.cares.baseframe.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.DictType;
import com.cares.baseframe.service.DictTypeService;
import com.google.common.collect.Maps;

/**
 * @description：数据字典类型
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/dictType")
public class DictTypeController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(DictTypeController.class);

    @Autowired
    private DictTypeService dictTypeService;    


    /**
     * 用户管理列表
     *
     * @param userVo
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    
    public PageInfo dataGrid(DictType dictType, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = Maps.newHashMap();
        if (StringUtils.isNoneBlank(dictType.getTypeCode())) {
            condition.put("type_code", dictType.getTypeCode());
        }
        if (dictType.getTypeId() !=null) {
            condition.put("type_id", dictType.getTypeId());
        }
        pageInfo.setCondition(condition);
        dictTypeService.findDataGrid(pageInfo);
        return pageInfo;
    }


    
    /**
     * 添加类型
     *
     * @param codeDictType
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    
    public BaseResult add(DictType dictType) {
        try {
            dictTypeService.addCodeDictType(dictType);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("添加类型失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    /**
     * 编辑
     *
     * @param role
     * @return
     */
    @RequestMapping("/edit")
    
    public BaseResult edit(DictType dictType) {
        try {
            dictTypeService.updateCodeDictType(dictType);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("编辑类型失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    
    /**
     * 编辑权限页
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("/editPage")
    public DictType editPage(Long id) {
        return dictTypeService.findCodeDictTypeById(id);
    }
    
    /**
     * 树
     *
     * @return
     */
    @RequestMapping(value = "/queryType", method = RequestMethod.POST)
    
    public List<DictType> queryType() {
        List<DictType> types = dictTypeService.queryType();
        return types;
        
        
    }
    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    
    public BaseResult delete(Long id) {
        try {
            dictTypeService.deleteCodeDictTypeById(id);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

}
