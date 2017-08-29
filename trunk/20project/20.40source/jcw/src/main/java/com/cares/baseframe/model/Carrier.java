package com.cares.baseframe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;


@Table(name = "b_carrier")
public class Carrier extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -4362633206357734950L;

	@Id
    @Column(name = "carrier_id")
    private Long carrierId;

    /**
     * 承运人二字码
     */
    @Column(name = "carrier_code")
    private String carrierCode;

    /**
     * 承运人中文名
     */
    @Column(name = "carrier_chn_nm")
    private String carrierChnNm;

    /**
     * 承运人英文名
     */
    @Column(name = "carrier_eng_nm")
    private String carrierEngNm;

    /**
     * 承运人简称
     */
    @Column(name = "carrier_brf_nm")
    private String carrierBrfNm;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改人
     */
    private String modifier;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 有效性（0无效1有效）
     */
    private String validity;

    /**
     * @return carrier_id
     */
    public Long getCarrierId() {
        return carrierId;
    }

    /**
     * @param carrierId
     */
    public void setCarrierId(Long carrierId) {
        this.carrierId = carrierId;
    }

    /**
     * 获取承运人二字码
     *
     * @return carrier_code - 承运人二字码
     */
    public String getCarrierCode() {
        return carrierCode;
    }

    /**
     * 设置承运人二字码
     *
     * @param carrierCode 承运人二字码
     */
    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    /**
     * 获取承运人中文名
     *
     * @return carrier_chn_nm - 承运人中文名
     */
    public String getCarrierChnNm() {
        return carrierChnNm;
    }

    /**
     * 设置承运人中文名
     *
     * @param carrierChnNm 承运人中文名
     */
    public void setCarrierChnNm(String carrierChnNm) {
        this.carrierChnNm = carrierChnNm;
    }

    /**
     * 获取承运人英文名
     *
     * @return carrier_eng_nm - 承运人英文名
     */
    public String getCarrierEngNm() {
        return carrierEngNm;
    }

    /**
     * 设置承运人英文名
     *
     * @param carrierEngNm 承运人英文名
     */
    public void setCarrierEngNm(String carrierEngNm) {
        this.carrierEngNm = carrierEngNm;
    }

    /**
     * 获取承运人简称
     *
     * @return carrier_brf_nm - 承运人简称
     */
    public String getCarrierBrfNm() {
        return carrierBrfNm;
    }

    /**
     * 设置承运人简称
     *
     * @param carrierBrfNm 承运人简称
     */
    public void setCarrierBrfNm(String carrierBrfNm) {
        this.carrierBrfNm = carrierBrfNm;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 获取有效性（0无效1有效）
     *
     * @return validity - 有效性（0无效1有效）
     */
    public String getValidity() {
        return validity;
    }

    /**
     * 设置有效性（0无效1有效）
     *
     * @param validity 有效性（0无效1有效）
     */
    public void setValidity(String validity) {
        this.validity = validity;
    }
}