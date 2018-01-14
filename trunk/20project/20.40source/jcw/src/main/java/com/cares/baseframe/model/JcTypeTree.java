package com.cares.baseframe.model;

import com.cares.baseframe.core.model.BaseModel;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = "b_jc_type")
public class JcTypeTree extends BaseModel {

    /**
     * 主键
     */
    @Id
    @Column(name = "tid")
    private Long typeId;

    /**
     * 类型名
     */
    @Column(name = "tname")
    private String typeName;

    /**
     * 父Id
     */
    @Column(name = "tpid")
    private Long typePid;

    /**
     * 父类型名
     */
    private String pTypeName;

    /**
     * 子类型list
     */
    private List<JcTypeTree> children;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 排序
     */
    @Column(name = "sort_no")
    private Integer sortNo;

    /**
     * 有效性 (0:有效，1:无效)
     */
    @Column(name = "validity")
    private Byte validity;


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getTypePid() {
        return typePid;
    }

    public void setTypePid(Long typePid) {
        this.typePid = typePid;
    }

    public String getpTypeName() {
        return pTypeName;
    }

    public void setpTypeName(String pTypeName) {
        this.pTypeName = pTypeName;
    }

    public List<JcTypeTree> getChildren() {
        return children;
    }

    public void setChildren(List<JcTypeTree> children) {
        this.children = children;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Byte getValidity() {
        return validity;
    }

    public void setValidity(Byte validity) {
        this.validity = validity;
    }
}