package com.cares.baseframe.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.alibaba.fastjson.JSON;
import com.cares.baseframe.SysContants;
import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.bean.UserRoleBean;
import com.cares.baseframe.model.Resource;

public class SecurityUserEntity extends UserBean implements UserDetails {

	private static final long serialVersionUID = -6302172319883011107L;
	
	private static final Logger log=LoggerFactory.getLogger(SecurityUserEntity.class);

	public SecurityUserEntity(UserBean userBean) {
		if (userBean != null) {
			this.setUserId(userBean.getUserId());
			this.setLoginName(userBean.getLoginName());
			this.setUserPwd(userBean.getUserPwd());
			this.setUserName(userBean.getUserName());
			this.setRoles(userBean.getUserRoleBeans());
		}

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<UserRoleBean> userRoleBeans = this.getUserRoleBeans();

		if (userRoleBeans != null) {
			log.debug("--userRoleBeans:--"+JSON.toJSONString(userRoleBeans));
			for (UserRoleBean userRoleBean : userRoleBeans) {
				if("admin".equals(userRoleBean.getRole().getUniqueCode())){
					SimpleGrantedAuthority authority = new SimpleGrantedAuthority("all");
					authorities.add(authority);
					return authorities;
				}
				for (Resource resource : userRoleBean.getRole().getResources()) {
					// 根据url判断
					if(SysContants.RESOURCE_TYPE_API == resource.getResType()){
						SimpleGrantedAuthority authority = new SimpleGrantedAuthority(resource.getResUrl());
						authorities.add(authority);
					}
				}
			}
		}
		log.debug("--authorities:--"+JSON.toJSONString(authorities));
		return authorities;
	}

	@Override
	public String getPassword() {
		return super.getUserPwd();
	}

	@Override
	public String getUsername() {
		return super.getLoginName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
