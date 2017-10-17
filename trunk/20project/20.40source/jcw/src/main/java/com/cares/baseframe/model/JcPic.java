package com.cares.baseframe.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;


@Table(name = "b_jc_pic")
public class JcPic extends BaseModel{

    /**
     * 主键
     */
    @Id
    @Column(name = "pid")
    private Long picId;

    /**
     * 图片名
     */
    @Column(name = "pname")
    private String picName;

    /**
     * 图片所在目录
     */
    @Column(name = "directory")
    private String directory;

    /**
     * 图片访问路径
     */
    @Column(name = "pathurl")
    private String pathUrl;

    /**
     * 图片所属机床
     */
    @Column(name = "jid")
    private Long jcId;

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

    public Long getPicId() {
        return picId;
    }

    public void setPicId(Long picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        this.pathUrl = pathUrl;
    }

    public Long getJcId() {
        return jcId;
    }

    public void setJcId(Long jcId) {
        this.jcId = jcId;
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