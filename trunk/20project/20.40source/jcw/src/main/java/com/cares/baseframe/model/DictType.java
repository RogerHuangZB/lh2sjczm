package com.cares.baseframe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;

@Table(name = "b_dict_type")
public class DictType extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7306850345067613621L;

	/**
     * 主键
     */
    @Id
    @Column(name = "type_id")
    private Long typeId;

    /**
     * 类别代码
     */
    @Column(name = "type_code")
    private String typeCode;

    /**
     * 类别名称
     */
    @Column(name = "type_name")
    private String typeName;

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
    @Column(name = "modify_time")
    private Date modifyTime;

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
     * @return type_id - 主键
     */
    public Long getTypeId() {
        return typeId;
    }

    /**
     * 设置主键
     *
     * @param typeId 主键
     */
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    /**
     * 获取类别代码
     *
     * @return type_code - 类别代码
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 设置类别代码
     *
     * @param typeCode 类别代码
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
     * 获取类别名称
     *
     * @return type_name - 类别名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置类别名称
     *
     * @param typeName 类别名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
     * @return modify_time - 更新时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置更新时间
     *
     * @param modifyTime 更新时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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