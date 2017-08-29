package com.cares.baseframe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;

@Table(name = "s_dept")
public class Dept extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5853487678861916895L;

	/**
     * 主键id
     */
    @Id
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 组织名
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 组织代码
     */
    @Column(name = "dept_code")
    private String deptCode;

    /**
     * 组织类型（0部门，1一级，2二级，3三级）
     */
    @Column(name = "dept_type")
    private String deptType;

    /**
     * 航空公司二字码，例：MU,FM
     */
    private String carrier;

    /**
     * 组织机构类型 1、机场代理人 2、航空公司 3、管理单位
     */
    @Column(name = "org_type")
    private String orgType;

    /**
     * 上级单位
     */
    @Column(name = "dept_pid")
    private Long deptPid;

    /**
     * 图标
     */
    @Column(name = "dept_icon")
    private String deptIcon;

    /**
     * 序号
     */
    @Column(name = "seq_sort")
    private Byte seqSort;

    /**
     * 所属机场
     */
    @Column(name = "apt_cd")
    private String aptCd;

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
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    /**
     * 有效性
     */
    private String validity;

    /**
     * 获取主键id
     *
     * @return dept_id - 主键id
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置主键id
     *
     * @param deptId 主键id
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取组织名
     *
     * @return dept_name - 组织名
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置组织名
     *
     * @param deptName 组织名
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * 获取组织代码
     *
     * @return dept_code - 组织代码
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * 设置组织代码
     *
     * @param deptCode 组织代码
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * 获取组织类型（0部门，1一级，2二级，3三级）
     *
     * @return dept_type - 组织类型（0部门，1一级，2二级，3三级）
     */
    public String getDeptType() {
        return deptType;
    }

    /**
     * 设置组织类型（0部门，1一级，2二级，3三级）
     *
     * @param deptType 组织类型（0部门，1一级，2二级，3三级）
     */
    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    /**
     * 获取航空公司二字码，例：MU,FM
     *
     * @return carrier - 航空公司二字码，例：MU,FM
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * 设置航空公司二字码，例：MU,FM
     *
     * @param carrier 航空公司二字码，例：MU,FM
     */
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    /**
     * 获取组织机构类型 1、机场代理人 2、航空公司 3、管理单位
     *
     * @return org_type - 组织机构类型 1、机场代理人 2、航空公司 3、管理单位
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 设置组织机构类型 1、机场代理人 2、航空公司 3、管理单位
     *
     * @param orgType 组织机构类型 1、机场代理人 2、航空公司 3、管理单位
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    /**
     * 获取上级单位
     *
     * @return dept_pid - 上级单位
     */
    public Long getDeptPid() {
        return deptPid;
    }

    /**
     * 设置上级单位
     *
     * @param deptPid 上级单位
     */
    public void setDeptPid(Long deptPid) {
        this.deptPid = deptPid;
    }

    /**
     * 获取图标
     *
     * @return dept_icon - 图标
     */
    public String getDeptIcon() {
        return deptIcon;
    }

    /**
     * 设置图标
     *
     * @param deptIcon 图标
     */
    public void setDeptIcon(String deptIcon) {
        this.deptIcon = deptIcon;
    }

    /**
     * 获取序号
     *
     * @return seq_sort - 序号
     */
    public Byte getSeqSort() {
        return seqSort;
    }

    /**
     * 设置序号
     *
     * @param seqSort 序号
     */
    public void setSeqSort(Byte seqSort) {
        this.seqSort = seqSort;
    }

    /**
     * 获取所属机场
     *
     * @return apt_cd - 所属机场
     */
    public String getAptCd() {
        return aptCd;
    }

    /**
     * 设置所属机场
     *
     * @param aptCd 所属机场
     */
    public void setAptCd(String aptCd) {
        this.aptCd = aptCd;
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
}