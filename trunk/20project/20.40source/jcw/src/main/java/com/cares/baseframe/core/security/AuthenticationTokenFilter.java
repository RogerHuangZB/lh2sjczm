package com.cares.baseframe.core.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cares.baseframe.SysContants;
import com.cares.baseframe.service.RedisCacheUtilService;

@Component
public class AuthenticationTokenFilter extends OncePerRequestFilter {

	@Autowired
	private RedisCacheUtilService redisService;
	@Value("${jwt.header}")
	private String tokenHeader;

	@Value("${jwt.tokenHead}")
	private String tokenHead;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
	
		String authHeader = request.getHeader(this.tokenHeader);//"token7ff980c8d4bc4cc798a2537b173745c5";//
		if (authHeader != null && authHeader.startsWith(tokenHead)) {
			final String authToken = authHeader.substring(tokenHead.length()); // The
																				// part
																				// after
																				// "Bearer
																				// "
			SecurityUserEntity userDetails = (SecurityUserEntity) redisService.get(SysContants.USER_TOKEN_NAMESPACE,
					authToken);
			if(userDetails==null) throw new AccessDeniedException("无效的token");
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
					null, userDetails.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			logger.info("authenticated user " + userDetails.getUsername() + ", setting security context");
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		chain.doFilter(request, response);
	}
	
}
