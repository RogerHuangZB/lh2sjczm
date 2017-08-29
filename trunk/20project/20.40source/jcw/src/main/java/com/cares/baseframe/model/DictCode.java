package com.cares.baseframe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;

@Table(name = "b_dict_code")
public class DictCode extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7331526219517663628L;

	/**
     * 主键
     */
    @Id
    @Column(name = "code_id")
    private Long codeId;

    /**
     * 码类别
     */
    @Column(name = "code_type")
    private String codeType;

    /**
     * 码名称
     */
    @Column(name = "code_name")
    private String codeName;

    /**
     * 码值
     */
    @Column(name = "code_value")
    private String codeValue;

    /**
     * 序号
     */
    @Column(name = "seq_sort")
    private Long seqSort;

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
     * @return code_id - 主键
     */
    public Long getCodeId() {
        return codeId;
    }

    /**
     * 设置主键
     *
     * @param codeId 主键
     */
    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    /**
     * 获取码类别
     *
     * @return code_type - 码类别
     */
    public String getCodeType() {
        return codeType;
    }

    /**
     * 设置码类别
     *
     * @param codeType 码类别
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取码名称
     *
     * @return code_name - 码名称
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * 设置码名称
     *
     * @param codeName 码名称
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * 获取码值
     *
     * @return code_value - 码值
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * 设置码值
     *
     * @param codeValue 码值
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    /**
     * 获取序号
     *
     * @return seq_sort - 序号
     */
    public Long getSeqSort() {
        return seqSort;
    }

    /**
     * 设置序号
     *
     * @param seqSort 序号
     */
    public void setSeqSort(Long seqSort) {
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