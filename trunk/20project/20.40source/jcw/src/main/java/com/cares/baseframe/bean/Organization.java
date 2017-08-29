package com.cares.baseframe.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cares.baseframe.model.DeptAgent;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @description：部门 s_dept
 * @author：
 * @date：
 */
public class Organization  implements Serializable {

    private static final long serialVersionUID = 1282186495210887307L;

    private Long deptId; //主键ID

    private String deptName; //组织名称   

    private String deptCode; //组织编号

    private String deptIcon; //图标

    private Long deptPid; //上级单位

    private Integer seqSort; //排序号
    
    private String aptCd;//机场编码
    
    private String deptType;// 0部门、1一级、2二级、3三级单位
    
    private String orgType;//组织机构类型1.机场代理人 2.航空公司 3.管理单位
    
    private String carrier;//航空公司二字码 例：MU,FM
    
    private List<Organization> children;
    
    private List<DeptAgent> deptAgentList;
    
    private String agentInfo;
    
    private String validity;
    
    private Long creator;
    
    private Long modifier;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptIcon() {
		return deptIcon;
	}

	public void setDeptIcon(String deptIcon) {
		this.deptIcon = deptIcon;
	}

	public Long getDeptPid() {
		return deptPid;
	}

	public void setDeptPid(Long deptPid) {
		this.deptPid = deptPid;
	}

	public Integer getSeqSort() {
		return seqSort;
	}

	public void setSeqSort(Integer seqSort) {
		this.seqSort = seqSort;
	}

	public String getAptCd() {
		return aptCd;
	}

	public void setAptCd(String aptCd) {
		this.aptCd = aptCd;
	}

	public String getDeptType() {
		return deptType;
	}

	public void setDeptType(String deptType) {
		this.deptType = deptType;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public List<Organization> getChildren() {
		return children;
	}

	public void setChildren(List<Organization> children) {
		this.children = children;
	}

	public List<DeptAgent> getDeptAgentList() {
		return deptAgentList;
	}

	public void setDeptAgentList(List<DeptAgent> deptAgentList) {
		this.deptAgentList = deptAgentList;
	}

	public String getAgentInfo() {
		return agentInfo;
	}

	public void setAgentInfo(String agentInfo) {
		this.agentInfo = agentInfo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	public Long getModifier() {
		return modifier;
	}

	public void setModifier(Long modifier) {
		this.modifier = modifier;
	}


	
}