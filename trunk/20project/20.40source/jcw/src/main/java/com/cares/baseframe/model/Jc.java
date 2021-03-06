package com.cares.baseframe.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;

import java.util.Date;
import java.util.List;

@Table(name = "b_jc")
public class Jc extends BaseModel{

    private static final long serialVersionUID = 5031134192645714513L;

    /**
     * 主键
     */
    @Id
    @Column(name = "jid")
    private Long jcId;

    /**
     * 机床名
     */
    @Column(name = "jc_name")
    private String jcName;

    /**
     * 类型id
     */
    @Column(name = "jc_type_id")
    private Long jcTypeId;

    private String jcTypeName;

    /**
     * 品牌id
     */
    @Column(name = "jc_brand_id")
    private Long jcBrandId;

    private String jcBrandName;

    /**
     * 原产地
     */
    @Column(name = "origin")
    private String origin;

    /**
     * 生产日期
     */
    @Column(name = "product_time")
    private Date productTime;

    private String productTimeStr;

    /**
     * 使用月数
     */
    @Column(name = "used_month")
    private Integer usedMonth;

    private Integer usedMonthFrom;
    private Integer usedMonthTo;

    /**
     * 出售状态
     */
    @Column(name = "is_sale")
    private Byte isSale;

    /**
     * 价格
     */
    @Column(name = "price")
    private Long price;

    private Long priceFrom;
    private Long priceTo;

    /**
     * 机床型号编码
     */
    @Column(name = "jc_model_no")
    private String jcModelNo;

    /**
     * 特征参数1
     */
    @Column(name = "feature01")
    private String feature01;

    /**
     * 特征参数2
     */
    @Column(name = "feature02")
    private String feature02;

    /**
     * 特征参数3
     */
    @Column(name = "feature03")
    private String feature03;

    /**
     * 特征参数4
     */
    @Column(name = "feature04")
    private String feature04;

    /**
     * 特征参数5
     */
    @Column(name = "feature05")
    private String feature05;

    private List<JcPic> jcPics;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 有效性 (0:有效，1:无效)
     */
    @Column(name = "validity")
    private Byte validity;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建人id
     */
    private Long creator;

    private String creatorName;

    /**
     * 更新时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 更新人id
     */
    private Long modifier;

    private String modifierName;

    public Long getJcId() {
        return jcId;
    }

    public void setJcId(Long jcId) {
        this.jcId = jcId;
    }

    public String getJcName() {
        return jcName;
    }

    public void setJcName(String jcName) {
        this.jcName = jcName;
    }

    public Long getJcTypeId() {
        return jcTypeId;
    }

    public void setJcTypeId(Long jcTypeId) {
        this.jcTypeId = jcTypeId;
    }

    public Long getJcBrandId() {
        return jcBrandId;
    }

    public void setJcBrandId(Long jcBrandId) {
        this.jcBrandId = jcBrandId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

    public String getProductTimeStr() {
        return productTimeStr;
    }

    public void setProductTimeStr(String productTimeStr) {
        this.productTimeStr = productTimeStr;
    }

    public Integer getUsedMonth() {
        return usedMonth;
    }

    public void setUsedMonth(Integer usedMonth) {
        this.usedMonth = usedMonth;
    }

    public Byte getIsSale() {
        return isSale;
    }

    public void setIsSale(Byte isSale) {
        this.isSale = isSale;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getValidity() {
        return validity;
    }

    public void setValidity(Byte validity) {
        this.validity = validity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Long getModifier() {
        return modifier;
    }

    public void setModifier(Long modifier) {
        this.modifier = modifier;
    }

    public Integer getUsedMonthFrom() {
        return usedMonthFrom;
    }

    public void setUsedMonthFrom(Integer usedMonthFrom) {
        this.usedMonthFrom = usedMonthFrom;
    }

    public Integer getUsedMonthTo() {
        return usedMonthTo;
    }

    public void setUsedMonthTo(Integer usedMonthTo) {
        this.usedMonthTo = usedMonthTo;
    }

    public Long getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Long priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Long getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Long priceTo) {
        this.priceTo = priceTo;
    }

    public String getJcModelNo() {
        return jcModelNo;
    }

    public void setJcModelNo(String jcModelNo) {
        this.jcModelNo = jcModelNo;
    }

    public String getFeature01() {
        return feature01;
    }

    public void setFeature01(String feature01) {
        this.feature01 = feature01;
    }

    public String getFeature02() {
        return feature02;
    }

    public void setFeature02(String feature02) {
        this.feature02 = feature02;
    }

    public String getFeature03() {
        return feature03;
    }

    public void setFeature03(String feature03) {
        this.feature03 = feature03;
    }

    public String getFeature04() {
        return feature04;
    }

    public void setFeature04(String feature04) {
        this.feature04 = feature04;
    }

    public String getFeature05() {
        return feature05;
    }

    public void setFeature05(String feature05) {
        this.feature05 = feature05;
    }

    public String getJcTypeName() {
        return jcTypeName;
    }

    public void setJcTypeName(String jcTypeName) {
        this.jcTypeName = jcTypeName;
    }

    public String getJcBrandName() {
        return jcBrandName;
    }

    public void setJcBrandName(String jcBrandName) {
        this.jcBrandName = jcBrandName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getModifierName() {
        return modifierName;
    }

    public void setModifierName(String modifierName) {
        this.modifierName = modifierName;
    }

    public List<JcPic> getJcPics() {
        return jcPics;
    }

    public void setJcPics(List<JcPic> jcPics) {
        this.jcPics = jcPics;
    }
}