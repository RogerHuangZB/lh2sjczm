package com.cares.baseframe.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cares.baseframe.core.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserBean extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1924635710674035570L;

	/**
     * 主键
     */
    private Long userId;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    @JsonIgnore
    private  String userPwd;

    /**
     * 单位
     */
    private Long deptId;

    /**
     * 用户性别
     */
    private Byte userSex;

    /**
     * 年龄
     */
    private Byte userAge;

    /**
     * 用户类型
     */
    private Byte userType;

    /**
     * 手机号码
     */
    private String userMobile;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    /**
     * 有效性
     */
    private Byte validity;
    
    private Set<UserRoleBean> userRoleBeans = new HashSet<UserRoleBean>(0);// 所对应的角色集合  
    
    private Organization org; //部门
    
    public UserBean(){
    }
 
	
	public Set<UserRoleBean> getUserRoleBeans() {
		return userRoleBeans;
	}

	public void setRoles(Set<UserRoleBean> userRoleBeans) {
		this.userRoleBeans = userRoleBeans;
	}


	/**
     * 获取主键
     *
     * @return user_id - 主键
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置主键
     *
     * @param userId 主键
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取登录名
     *
     * @return login_name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户密码
     *
     * @return user_pwd - 用户密码
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置用户密码
     *
     * @param userPwd 用户密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * 获取单位
     *
     * @return dept_id - 单位
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置单位
     *
     * @param deptId 单位
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取用户性别
     *
     * @return user_sex - 用户性别
     */
    public Byte getUserSex() {
        return userSex;
    }

    /**
     * 设置用户性别
     *
     * @param userSex 用户性别
     */
    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取年龄
     *
     * @return user_age - 年龄
     */
    public Byte getUserAge() {
        return userAge;
    }

    /**
     * 设置年龄
     *
     * @param userAge 年龄
     */
    public void setUserAge(Byte userAge) {
        this.userAge = userAge;
    }

    /**
     * 获取用户类型
     *
     * @return user_type - 用户类型
     */
    public Byte getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(Byte userType) {
        this.userType = userType;
    }

    /**
     * 获取手机号码
     *
     * @return user_mobile - 手机号码
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 设置手机号码
     *
     * @param userMobile 手机号码
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取有效性
     *
     * @return validity - 有效性
     */
    public Byte getValidity() {
        return validity;
    }

    /**
     * 设置有效性
     *
     * @param validity 有效性
     */
    public void setValidity(Byte validity) {
        this.validity = validity;
    }


	public Organization getOrg() {
		return org;
	}


	public void setOrg(Organization org) {
		this.org = org;
	}
    
}