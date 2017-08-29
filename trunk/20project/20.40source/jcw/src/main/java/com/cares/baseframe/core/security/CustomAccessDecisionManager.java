package com.cares.baseframe.core.security;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

@Service
public class CustomAccessDecisionManager implements AccessDecisionManager {

	
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		System.out.println(authentication.getAuthorities());
		HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
		String url;
		AntPathRequestMatcher matcher;
		//忽略登录请求拦截
		matcher=new AntPathRequestMatcher("/login");
		if(matcher.matches(request)){
			return;
		}
		//忽略注册请求拦截
		matcher=new AntPathRequestMatcher("/user/register");
		if(matcher.matches(request)){
			return;
		}
		//忽略jc请求拦截
		matcher=new AntPathRequestMatcher("/jc/*");
		if(matcher.matches(request)){
			return;
		}
		//忽略jcType请求拦截
		matcher=new AntPathRequestMatcher("/jcType/*");
		if(matcher.matches(request)){
			return;
		}
		//忽略jcBrand请求拦截
		matcher=new AntPathRequestMatcher("/jcBrand/*");
		if(matcher.matches(request)){
			return;
		}
		//url 比较
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			SimpleGrantedAuthority urlGrantedAuthority = (SimpleGrantedAuthority) ga;
			url = urlGrantedAuthority.getAuthority();
			matcher = new AntPathRequestMatcher(url);
			if (matcher.matches(request) || "ALL".equalsIgnoreCase(url)) {
				return;
			}
		}

		throw new AccessDeniedException("权限不足");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
