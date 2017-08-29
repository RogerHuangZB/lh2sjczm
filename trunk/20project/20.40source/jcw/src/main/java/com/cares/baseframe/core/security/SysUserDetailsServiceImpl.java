package com.cares.baseframe.core.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.service.UserService;

@Service
public class SysUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBean userBean = userService.findUserByLoginName(username);
        if (userBean == null) {
            throw new UsernameNotFoundException(String.format("No user found with loginName : '%s'.", username));
        } else {
            return new SecurityUserEntity(userBean);
        }
    }

}
