package com.cares.baseframe.bean;

import com.cares.baseframe.core.model.BaseModel;

public class UserRoleBean extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 749778976354981756L;

	/**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;
    
    private RoleBean roleBean;
    

    public RoleBean getRole() {
		return roleBean;
	}

	public void setRole(RoleBean roleBean) {
		this.roleBean = roleBean;
	}

	/**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}