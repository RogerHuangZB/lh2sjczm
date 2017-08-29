package com.cares.baseframe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cares.baseframe.core.model.BaseModel;


@Table(name = "s_dept_agent")
public class DeptAgent extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3950686435290608400L;

	@Id
    @Column(name = "dept_agent_id")
    private Long deptAgentId;

    /**
     * 组织架构表ID
     */
    @Column(name = "dept_id")
    private Long deptId;

    /**
     * 机场表Id
     */
    @Column(name = "airport_id")
    private Long airportId;

    /**
     * 承运人二字码，例：MU,FM,AA
     */
    private String carrier;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改人
     */
    private String modifier;

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
     * 有效性（0无效1有效）
     */
    private String validity;

    /**
     * @return dept_agent_id
     */
    public Long getDeptAgentId() {
        return deptAgentId;
    }

    /**
     * @param deptAgentId
     */
    public void setDeptAgentId(Long deptAgentId) {
        this.deptAgentId = deptAgentId;
    }

    /**
     * 获取组织架构表ID
     *
     * @return dept_id - 组织架构表ID
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置组织架构表ID
     *
     * @param deptId 组织架构表ID
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取机场表Id
     *
     * @return airport_id - 机场表Id
     */
    public Long getAirportId() {
        return airportId;
    }

    /**
     * 设置机场表Id
     *
     * @param airportId 机场表Id
     */
    public void setAirportId(Long airportId) {
        this.airportId = airportId;
    }

    /**
     * 获取承运人二字码，例：MU,FM,AA
     *
     * @return carrier - 承运人二字码，例：MU,FM,AA
     */
    public String getCarrier() {
        return carrier;
    }

    /**
     * 设置承运人二字码，例：MU,FM,AA
     *
     * @param carrier 承运人二字码，例：MU,FM,AA
     */
    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取修改人
     *
     * @return modifier - 修改人
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改人
     *
     * @param modifier 修改人
     */
    public void setModifier(String modifier) {
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
     * 获取有效性（0无效1有效）
     *
     * @return validity - 有效性（0无效1有效）
     */
    public String getValidity() {
        return validity;
    }

    /**
     * 设置有效性（0无效1有效）
     *
     * @param validity 有效性（0无效1有效）
     */
    public void setValidity(String validity) {
        this.validity = validity;
    }
}