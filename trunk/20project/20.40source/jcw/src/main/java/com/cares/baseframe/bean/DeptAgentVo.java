package com.cares.baseframe.bean;

import java.io.Serializable;

public class DeptAgentVo implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long deptAgentId;

    private Long deptId;						

    private Long airportId;
    
    private String aptCd;
    
    private String aptCdInitial;
    
    private String airportName;

    private String carrier;

	public Long getDeptAgentId() {
		return deptAgentId;
	}

	public void setDeptAgentId(Long deptAgentId) {
		this.deptAgentId = deptAgentId;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getAirportId() {
		return airportId;
	}

	public void setAirportId(Long airportId) {
		this.airportId = airportId;
	}

	

	public String getAptCdInitial() {
		return aptCdInitial;
	}

	public void setAptCdInitial(String aptCdInitial) {
		this.aptCdInitial = aptCdInitial;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public String getAptCd() {
		return aptCd;
	}

	public void setAptCd(String aptCd) {
		this.aptCd = aptCd;
	}
    
    
}
