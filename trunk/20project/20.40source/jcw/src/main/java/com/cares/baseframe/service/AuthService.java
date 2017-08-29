package com.cares.baseframe.service;

import com.cares.baseframe.bean.AuthenticationResponse;
import com.cares.baseframe.model.User;

public interface AuthService {
    User register(User userToAdd);
    AuthenticationResponse login(String username, String password);
    
}
