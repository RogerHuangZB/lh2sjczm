package com.cares.baseframe.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cares.baseframe.model.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @description：UserVo
 * @author：
 * @date：
 */
public class UserVo implements Serializable {
    private Long id;

    private String loginName;

    private String name;

    private String password;

    private Integer sex;    

    private Integer status;

    private Long deptId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String mobile;

    private List<Role> rolesList;

    private String deptName;
    private String aptCd;

    private String roleIds;

    private Date createdateStart;
    private Date createdateEnd;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public List<Role> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Role> rolesList) {
        this.rolesList = rolesList;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Date getCreatedateStart() {
        return createdateStart;
    }

    public void setCreatedateStart(Date createdateStart) {
        this.createdateStart = createdateStart;
    }

    public Date getCreatedateEnd() {
        return createdateEnd;
    }

    public void setCreatedateEnd(Date createdateEnd) {
        this.createdateEnd = createdateEnd;
    }

	
	public String getAptCd() {
		return aptCd;
	}

	public void setAptCd(String aptCd) {
		this.aptCd = aptCd;
	}

	public static void main(String args[]) {
		Example ex = new Example();
		System.out.print(ex.str + " and ");
		System.out.print(ex.ch);
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str + " and ");
		System.out.print(ex.ch);
	}
}

class Example {
	String str = new String("good");
	char[] ch = { 'a', 'b', 'c' };

	public void change(String str, char ch[]) {
		str = "test ok";
		ch[0] = 'g';
	}
}
