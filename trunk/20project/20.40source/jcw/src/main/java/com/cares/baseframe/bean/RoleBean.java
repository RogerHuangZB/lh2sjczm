package com.cares.baseframe.bean;

import java.util.Date;
import java.util.List;

import com.cares.baseframe.core.model.BaseModel;
import com.cares.baseframe.model.Resource;



public class RoleBean extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3620451861028383414L;

	/**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色编码
     */
    private String uniqueCode;

    /**
     * 序号
     */
    private Integer seqSort;

    /**
     * 关联部门ID
     */
    private Long deptId;

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
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 有效性状态
     */
    private String validity;

    /**
     * 备注
     */
    private String remark;
    
    private List<Resource> resources; 
    

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
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

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色编码
     *
     * @return unique_code - 角色编码
     */
    public String getUniqueCode() {
        return uniqueCode;
    }

    /**
     * 设置角色编码
     *
     * @param uniqueCode 角色编码
     */
    public void setUniqueCode(String uniqueCode) {
        this.uniqueCode = uniqueCode;
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
     * 获取关联部门ID
     *
     * @return dept_id - 关联部门ID
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置关联部门ID
     *
     * @param deptId 关联部门ID
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }


    /**
     * 获取有效性状态
     *
     * @return validity - 有效性状态
     */
    public String getValidity() {
        return validity;
    }

    /**
     * 设置有效性状态
     *
     * @param validity 有效性状态
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
    
}