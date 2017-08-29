package com.cares.baseframe.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;


@Table(name = "b_jc_brand")
public class JcBrand extends BaseModel{

    private static final long serialVersionUID = 1977401798645624235L;
    /**
     * 主键
     */
    @Id
    @Column(name = "bid")
    private Long brandId;

    /**
     * 品牌名
     */
    @Column(name = "bname")
    private String brandName;

    /**
     * 品牌名缩写
     */
    @Column(name = "bshortcut")
    private String brandShortcut;

    /**
     * 品牌地址
     */
    @Column(name = "burl")
    private String brandUrl;

    /**
     * 品牌LOGO
     */
    @Column(name = "blogo")
    private String brandLogo;

    /**
     * 备注
     */
    @Column(name = "remark")

    private String remark;

    /**
     * 排序
     */
    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     * 有效性 (0:有效，1:无效)
     */
    @Column(name = "validity")
    private Byte validity;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandShortcut() {
        return brandShortcut;
    }

    public void setBrandShortcut(String brandShortcut) {
        this.brandShortcut = brandShortcut;
    }

    public String getBrandUrl() {
        return brandUrl;
    }

    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Byte getValidity() {
        return validity;
    }

    public void setValidity(Byte validity) {
        this.validity = validity;
    }
}