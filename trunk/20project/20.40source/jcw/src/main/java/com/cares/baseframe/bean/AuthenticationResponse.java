package com.cares.baseframe.bean;

import com.cares.baseframe.bean.UserVo;

public class AuthenticationResponse {
	private String token;
	private UserVo user;
	
	public AuthenticationResponse(){}
	public AuthenticationResponse(String token,UserVo user){
		this.token=token;
		this.user=user;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public UserVo getUser() {
		return user;
	}
	public void setUser(UserVo user) {
		this.user = user;
	}
	
}
