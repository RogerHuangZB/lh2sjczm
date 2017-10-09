package com.cares.baseframe.controller;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.JcBrand;
import com.cares.baseframe.service.JcBrandService;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @description：机床品牌
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/jcBrand")
public class JcBrandController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(JcBrandController.class);

    @Autowired
    private JcBrandService jcBrandService;


    /**
     * 添加机床品牌
     *
     * @param jcBrand
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public BaseResult add(JcBrand jcBrand) {
        try {
            jcBrandService.addJcBrand(jcBrand);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除机床品牌
     *
     * @param brandId
     * @return
     */
    @RequestMapping("/delete")

    public BaseResult delete(Long brandId) {
        try {
            jcBrandService.deleteJcBrandById(brandId);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除机床品牌失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 编辑机床品牌
     *
     * @param jcBrand
     * @return
     */
    @RequestMapping("/edit")

    public BaseResult edit(JcBrand jcBrand) {
        try {
            jcBrandService.updateJcBrand(jcBrand);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("编辑机床品牌失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 查询机床品牌
     * @return
     */
    @RequestMapping(value = "/findJcBrandById", method = RequestMethod.POST)

    public JcBrand findJcBrandById(Long brandId) {
        JcBrand jcBrand = jcBrandService.findJcBrandById(brandId);
        return jcBrand;
    }

    /**
     * 查询所有机床品牌
     * @return
     */
    @RequestMapping(value = "/dataAll", method = RequestMethod.POST)

    public List<JcBrand> jcBrandDataAll(Long brandId) {
        List<JcBrand> jcBrandList = jcBrandService.jcBrandDataAll(brandId);
        return jcBrandList;
    }

    /**
     * 机床品牌列表
     *
     * @param jcBrand
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)

    public PageInfo dataGrid(JcBrand jcBrand, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);

        Map<String, Object> condition = Maps.newHashMap();

        if (StringUtils.isNoneBlank(jcBrand.getBrandName())) {
            condition.put("brandName", jcBrand.getBrandName());
        }

        if (StringUtils.isNoneBlank(jcBrand.getBrandShortcut())) {
            condition.put("brandShortcut", jcBrand.getBrandShortcut());
        }

        if (StringUtils.isNoneBlank(jcBrand.getRemark())) {
            condition.put("remark", jcBrand.getRemark());
        }

        pageInfo.setCondition(condition);

        jcBrandService.findDataGrid(pageInfo);

        return pageInfo;
    }

}
