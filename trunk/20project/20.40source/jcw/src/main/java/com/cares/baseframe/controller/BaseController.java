package com.cares.baseframe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.ObjectError;

import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.core.security.SecurityUserEntity;
import com.cares.baseframe.service.UserService;


public class BaseController {

    @Autowired
    private UserService userService;

    /**
     * 获取当前登录用户对象
     * @return
     */
    public UserBean getCurrentUser() {
    	SecurityUserEntity userDetails = (SecurityUserEntity) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
    	UserBean user = userService.findUserByLoginName(userDetails.getUsername());
        return user;
    }

    /**
     * 获取当前登录用户id
     * @return
     */
    public Long getUserId() {
        return this.getCurrentUser().getUserId();
    }

    /**
     * 获取当前登录用户名
     * @return
     */
    public String getStaffName() {
        return this.getCurrentUser().getLoginName();
    }
    
    protected String getErrorMessages(List<ObjectError> errors){
    	StringBuffer buffer=new StringBuffer();
    	for (ObjectError objectError : errors) {
			if(buffer.length()>0){buffer.append(",");}
			buffer.append(objectError.getDefaultMessage());
		}
    	return buffer.toString();
    }

}
