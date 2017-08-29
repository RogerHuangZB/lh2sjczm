package com.cares.baseframe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;


@Table(name = "s_user")
public class User extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1924635710674035570L;

	/**
     * 主键
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户密码
     */
    @Column(name = "user_pwd")
    private String userPwd;

    /**
     * 单位
     */
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 用户性别
     */
    @Column(name = "user_sex")
    private Byte userSex;

    /**
     * 年龄
     */
    @Column(name = "user_age")
    private Byte userAge;

    /**
     * 用户类型
     */
    @Column(name = "user_type")
    private Byte userType;

    /**
     * 手机号码
     */
    @Column(name = "user_mobile")
    private String userMobile;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 更新人
     */
    private Long modifier;

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
    private Byte validity;

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
     * 获取更新人
     *
     * @return modifier - 更新人
     */
    public Long getModifier() {
        return modifier;
    }

    /**
     * 设置更新人
     *
     * @param modifier 更新人
     */
    public void setModifier(Long modifier) {
        this.modifier = modifier;
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
}