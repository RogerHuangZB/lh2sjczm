package com.cares.baseframe.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.model.Carrier;
import com.cares.baseframe.service.CarrierService;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;

@RestController
@RequestMapping("/carrier")
public class CarrierController extends BaseController{
	private static final Logger logger=LoggerFactory.getLogger(CarrierController.class);
	@Autowired
	private CarrierService carrierService;

    /**
     * 列表
     *
     * @param userVo
     * @param page
     * @param rows
     * @param sort
     * @param order
     * @return
     */
    @RequestMapping(value = "/dataGrid", method = RequestMethod.POST)
    public PageInfo dataGrid(Carrier carrier, Integer page, Integer rows, String sort, String order) {
        PageInfo pageInfo = new PageInfo(page, rows, sort, order);
        Map<String, Object> condition = Maps.newHashMap();
        if(StringUtils.isNoneBlank(carrier.getCarrierCode())){
        	condition.put("carrierCode",carrier.getCarrierCode() );
        }
        if(StringUtils.isNoneBlank(carrier.getCarrierChnNm())){
        	condition.put("carrierChnNm",carrier.getCarrierChnNm() );
        }
        if(StringUtils.isNoneBlank(carrier.getCarrierEngNm())){
        	condition.put("carrierEngNm",carrier.getCarrierEngNm() );
        }
        if(StringUtils.isNoneBlank(carrier.getCarrierBrfNm())){
        	condition.put("carrierBrfNm",carrier.getCarrierBrfNm() );
        }
        pageInfo.setCondition(condition);
        carrierService.findCarrierByPage(pageInfo);
        return pageInfo;
    }
    
    @RequestMapping( method = RequestMethod.GET)
    public com.github.pagehelper.PageInfo<Carrier> page(Carrier carrier, Integer page, Integer rows, String sort, String order) {
        PageHelper.startPage(page,rows);
		List<Carrier> ss = carrierService.findall();
		com.github.pagehelper.PageInfo<Carrier> pageinfo=new com.github.pagehelper.PageInfo<Carrier>(ss);
        return pageinfo;
    }

    
    /**
     * 添加
     *
     * @param codeDictType
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResult add(Carrier carrier) {
        try {
        	carrierService.insert(carrier);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("添加类型失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
    
    /**
     * 编辑页
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping(value = "/{carrierId}", method = RequestMethod.GET)
    public Carrier queryByCarrierId(@PathVariable("carrierId") Long carrierId) {
        return carrierService.selectByPrimaryKey(carrierId);
    }
    /**
     * 编辑
     *
     * @param role
     * @return
     */
    @RequestMapping("/edit")
    public BaseResult edit(Carrier carrier) {
        try {
        	carrierService.updateByPrimaryKeySelective(carrier);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("编辑类型失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public BaseResult delete(Long carrierId) {
        try {
        	carrierService.deleteByPrimaryKey(carrierId);
            return BaseResult.success();
        } catch (RuntimeException e) {
            logger.error("删除失败：{}", e);
            return BaseResult.fail(e.getMessage());
        }
    }
}
