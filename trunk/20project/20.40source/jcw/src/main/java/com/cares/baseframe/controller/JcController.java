package com.cares.baseframe.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.Jc;
import com.cares.baseframe.model.JcPic;
import com.cares.baseframe.service.JcPicService;
import com.cares.baseframe.service.JcService;
import com.cares.baseframe.util.UpLoadFileUtils;
import com.google.common.collect.Maps;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description：机床
 * @author：
 * @date：
 */
@RestController
@RequestMapping("/jc")
public class JcController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(JcController.class);

    @Autowired
    private JcService jcService;

    @Autowired
    private JcPicService jcPicService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }


    /**
     * 添加机床
     *
     * @param jc
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)

    public BaseResult add(Jc jc) {
        try {
            jc.setCreator(1L);//TODO:...
            String productTimeStr = jc.getProductTimeStr();
            Date productTime = new Date(productTimeStr);
            jc.setProductTime(productTime);
            jcService.addJc(jc);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error(e.getMessage());
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除机床
     *
     * @param jcId
     * @return
     */
    @RequestMapping("/delete")

    public BaseResult delete(Long jcId) {
        try {
            jcService.deleteJcById(jcId);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除机床失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 编辑机床
     *
     * @param jc
     * @return
     */
    @RequestMapping("/edit")

    public BaseResult edit(Jc jc) {
        try {
            jc.setModifier(1L);//TODO:...
            String productTimeStr = jc.getProductTimeStr();
            Date productTime = new Date(productTimeStr);
            jc.setProductTime(productTime);
            jcService.updateJc(jc);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("编辑机床失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 查询机床
     * @return
     */
    @RequestMapping(value = "/findJcById", method = RequestMethod.POST)

    public Jc findJcById(Long jcId) {
        Jc jc = jcService.findJcById(jcId);
        return jc;
    }

    /**
     * 机床列表
     *
     * @param jc
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)

    public PageInfo dataGrid(Jc jc, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);

        Map<String, Object> condition = Maps.newHashMap();

        if (StringUtils.isNoneBlank(jc.getJcName())) {
            condition.put("jcName", jc.getJcName());
        }
        if (jc.getJcTypeId() != null) {
            condition.put("jcTypeId", jc.getJcTypeId());
        }
        if (jc.getJcBrandId() != null) {
            condition.put("jcBrandId", jc.getJcBrandId());
        }
        if (StringUtils.isNoneBlank(jc.getOrigin())) {
            condition.put("origin", jc.getOrigin());
        }
        if (jc.getProductTime() != null) {
            condition.put("productTime", jc.getProductTime());
        }
        if (jc.getIsSale() != null) {
            condition.put("isSale", jc.getIsSale());
        }
        if (jc.getUsedMonthFrom() != null) {
            condition.put("usedMonthFrom", jc.getUsedMonthFrom());
        }
        if (jc.getUsedMonthTo() != null) {
            condition.put("usedMonthTo", jc.getUsedMonthTo());
        }
        if (jc.getPriceFrom() != null) {
            condition.put("priceFrom", jc.getPriceFrom());
        }
        if (jc.getPriceTo() != null) {
            condition.put("priceTo", jc.getPriceTo());
        }

        pageInfo.setCondition(condition);

        jcService.findDataGrid(pageInfo);

        return pageInfo;
    }

    // 上传图片
    @RequestMapping(value = "/uploadJcPic", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult addJcPics(HttpServletRequest request) {
        /*String rPath = "/jcw/jcpics/";*/
        String rPath = "E:\\jcpics\\";
        Map<String, Object> map = UpLoadFileUtils.uploadFile(request, rPath);

        List<String> pathList=new ArrayList<String>();

        pathList = (List<String>) map.get("pathList");

        Map<String,String[]> parameterMap = request.getParameterMap();
        Long jcId = Long.valueOf(parameterMap.get("jcId")[0]);

        JcPic pic = new JcPic();

        pic.setJcId(jcId);
        pic.setDirectory("jcpics");
        pic.setPicName(pathList.get(0).replace("/",""));
        pic.setPathUrl(rPath + "");
        pic.setValidity((byte) 0);
        pic.setRemark("");
        /*pic.setSortNo(0);*/

        jcPicService.addJcPic(pic);


        return BaseResult.success();
    }

}
