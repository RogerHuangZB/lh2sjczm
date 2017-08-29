package com.cares.baseframe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;

@Table(name = "s_resource")
public class Resource extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1832427192835488057L;

	/**
     * 主键
     */
    @Id
    @Column(name = "res_id")
    private Long resId;

    /**
     * 资源名
     */
    @Column(name = "res_name")
    private String resName;

    /**
     * 资源类别
     */
    @Column(name = "res_type")
    private Integer resType;

    /**
     * 资源路径
     */
    @Column(name = "res_url")
    private String resUrl;

    /**
     * 资源图片
     */
    @Column(name = "res_icon")
    private String resIcon;

    /**
     * 上级资源
     */
    @Column(name = "res_pid")
    private Integer resPid;

    /**
     * 序号
     */
    @Column(name = "seq_sort")
    private Integer seqSort;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 修改人
     */
    private Long modifier;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 有效性
     */
    private String validity;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取主键
     *
     * @return res_id - 主键
     */
    public Long getResId() {
        return resId;
    }

    /**
     * 设置主键
     *
     * @param resId 主键
     */
    public void setResId(Long resId) {
        this.resId = resId;
    }

    /**
     * 获取资源名
     *
     * @return res_name - 资源名
     */
    public String getResName() {
        return resName;
    }

    /**
     * 设置资源名
     *
     * @param resName 资源名
     */
    public void setResName(String resName) {
        this.resName = resName;
    }

    /**
     * 获取资源类别
     *
     * @return res_type - 资源类别
     */
    public Integer getResType() {
        return resType;
    }

    /**
     * 设置资源类别
     *
     * @param resType 资源类别
     */
    public void setResType(Integer resType) {
        this.resType = resType;
    }

    /**
     * 获取资源路径
     *
     * @return res_url - 资源路径
     */
    public String getResUrl() {
        return resUrl;
    }

    /**
     * 设置资源路径
     *
     * @param resUrl 资源路径
     */
    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    /**
     * 获取资源图片
     *
     * @return res_icon - 资源图片
     */
    public String getResIcon() {
        return resIcon;
    }

    /**
     * 设置资源图片
     *
     * @param resIcon 资源图片
     */
    public void setResIcon(String resIcon) {
        this.resIcon = resIcon;
    }

    /**
     * 获取上级资源
     *
     * @return res_pid - 上级资源
     */
    public Integer getResPid() {
        return resPid;
    }

    /**
     * 设置上级资源
     *
     * @param resPid 上级资源
     */
    public void setResPid(Integer resPid) {
        this.resPid = resPid;
    }

    /**
     * 获取序号
     *
     * @return seq_sort - 序号
     */
    public Integer getSeqSort() {
        return seqSort;
    }

    /**
     * 设置序号
     *
     * @param seqSort 序号
     */
    public void setSeqSort(Integer seqSort) {
        this.seqSort = seqSort;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public Long getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
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
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取有效性
     *
     * @return validity - 有效性
     */
    public String getValidity() {
        return validity;
    }

    /**
     * 设置有效性
     *
     * @param validity 有效性
     */
    public void setValidity(String validity) {
        this.validity = validity;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}