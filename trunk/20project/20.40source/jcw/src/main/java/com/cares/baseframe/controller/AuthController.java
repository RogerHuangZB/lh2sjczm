package com.cares.baseframe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cares.baseframe.bean.AuthenticationRequest;
import com.cares.baseframe.bean.AuthenticationResponse;
import com.cares.baseframe.core.response.BaseResult;
import com.cares.baseframe.service.AuthService;


@RestController
public class AuthController {

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public BaseResult createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws AuthenticationException {
		final AuthenticationResponse response = authService.login(authenticationRequest.getUsername(),
				authenticationRequest.getPassword());
		
		// Return the token
		return BaseResult.success(response);
	}

}
