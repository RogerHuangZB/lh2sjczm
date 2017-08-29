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
import com.cares.baseframe.model.DictCode;
import com.cares.baseframe.service.DictCodeService;
import com.google.common.collect.Maps;

/**
 * @description：数据字典类型
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/dictCode")
public class DictCodeController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(DictCodeController.class);

    @Autowired
    private DictCodeService dictCodeService;    

   
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
    public PageInfo dataGrid(DictCode dictCode, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = Maps.newHashMap();
        if (StringUtils.isNoneBlank(dictCode.getCodeName())) {
            condition.put("code_name", dictCode.getCodeName());
        }
        if (dictCode.getCodeId() !=null) {
            condition.put("code_id", dictCode.getCodeId());
        }
        pageInfo.setCondition(condition);
        dictCodeService.findDataGrid(pageInfo);
        return pageInfo;
    }

    /**
     * 添加类型
     *
     * @param codeDictType
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(DictCode dictCode) {
        try {
            dictCodeService.addDictCode(dictCode);
            
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
    
    public BaseResult edit(DictCode dictCode) {
        try {
            dictCodeService.updateDictCode(dictCode);
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
    public DictCode editPage( Long id) {
        return dictCodeService.findDictCodeById(id);
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
            dictCodeService.deleteDictCodeById(id);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    /**
     * 查询工控机类型
     * @return
     */
    @RequestMapping(value = "/queryIpcType", method = RequestMethod.POST)
    
    public List<DictCode> queryIpcType() {
        List<DictCode> ipcTypes = dictCodeService.queryIpcType();
        return ipcTypes;
        
        
    }
    

}
