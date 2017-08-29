package com.cares.baseframe.bean;


import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

public class  AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;
    @NotBlank(message="用户名不能为空")
    private String username;
    @NotBlank(message="密码不能为空")
    private String password;

    public AuthenticationRequest() {
        super();
    }

    public AuthenticationRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
