package com.cares.baseframe.controller;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.JcPic;
import com.cares.baseframe.model.JcType;
import com.cares.baseframe.service.JcPicService;
import com.cares.baseframe.service.JcTypeService;
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
 * Created by Roger on 2017/10/18.
 * @description：机床图片
 *
 */
@RestController
@RequestMapping("/jcPic")
public class JcPicController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(JcPicController.class);

    @Autowired
    private JcPicService jcPicService;


    /**
     * 添加机床图片
     *
     * @param jcPic
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public BaseResult add(JcPic jcPic) {
        try {
            jcPicService.addJcPic(jcPic);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除机床图片
     *
     * @param picId
     * @return
     */
    @RequestMapping("/deleteById")

    public BaseResult deleteById(Long picId) {
        try {
            jcPicService.deleteJcPicById(picId);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除机床图片失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除机床图片
     *
     * @param jcPic
     * @return
     */
    @RequestMapping("/delete")

    public BaseResult delete(JcPic jcPic) {
        try {
            jcPicService.deleteJcPic(jcPic);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除机床图片失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 编辑机床图片
     *
     * @param jcPic
     * @return
     */
    @RequestMapping("/edit")

    public BaseResult edit(JcPic jcPic) {
        try {
            jcPicService.updateJcPic(jcPic);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("编辑机床图片失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 查询机床图片
     * @return
     */
    @RequestMapping(value = "/findJcPicsByJcId", method = RequestMethod.POST)

    public List<JcPic> findJcPicsByJcId(Long jcId) {
        List<JcPic> jcPicList = jcPicService.findJcPicsByJcId(jcId);
        return jcPicList;
    }

}
