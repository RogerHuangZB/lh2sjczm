package com.cares.baseframe.controller;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.JcType;
import com.cares.baseframe.service.JcTypeService;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description：机床类型
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/jcType")
public class JcTypeController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(JcTypeController.class);

    @Autowired
    private JcTypeService jcTypeService;


    /**
     * 添加机床类型
     *
     * @param jcType
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public BaseResult add(JcType jcType) {
        try {
            jcTypeService.addJcType(jcType);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除机床类型
     *
     * @param typeId
     * @return
     */
    @RequestMapping("/delete")

    public BaseResult delete(Long typeId) {
        try {
            jcTypeService.deleteJcTypeById(typeId);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除机床类型失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 编辑机床类型
     *
     * @param jcType
     * @return
     */
    @RequestMapping("/edit")

    public BaseResult edit(JcType jcType) {
        try {
            jcTypeService.updateJcType(jcType);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("编辑机床类型失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 查询机床类型
     * @return
     */
    @RequestMapping(value = "/findJcTypeById", method = RequestMethod.POST)

    public JcType findJcTypeById(Long typeId) {
        JcType jcType = jcTypeService.findJcTypeById(typeId);
        return jcType;
    }

    /**
     * 机床类型列表
     *
     * @param jcType
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)

    public PageInfo dataGrid(JcType jcType, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);

        Map<String, Object> condition = Maps.newHashMap();

        if (StringUtils.isNoneBlank(jcType.getTypeName())) {
            condition.put("typeName", jcType.getTypeName());
        }

        pageInfo.setCondition(condition);

        jcTypeService.findDataGrid(pageInfo);

        return pageInfo;
    }

}
