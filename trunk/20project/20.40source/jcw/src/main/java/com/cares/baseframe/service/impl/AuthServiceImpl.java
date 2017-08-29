package com.cares.baseframe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cares.baseframe.SysContants;
import com.cares.baseframe.bean.AuthenticationResponse;
import com.cares.baseframe.bean.UserVo;
import com.cares.baseframe.core.security.SecurityUserEntity;
import com.cares.baseframe.model.User;
import com.cares.baseframe.service.AuthService;
import com.cares.baseframe.service.RedisCacheUtilService;
import com.cares.baseframe.service.UserService;
import com.cares.baseframe.util.TokenUtil;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private UserService userService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private RedisCacheUtilService redisService;
    @Autowired
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @Override
    public User register(User userToAdd) {
        final String loginName = userToAdd.getLoginName();
        if(userService.findUserByLoginName(loginName)!=null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getUserPwd();
        userToAdd.setUserPwd(encoder.encode(rawPassword));
        //userToAdd.setRoles(asSet("ROLE_USER"));
        return null;//userService.insert(userToAdd);
    }

    @Override
    public AuthenticationResponse login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Reload password post-security so we can generate token,token中不存储用户信息
        //final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = TokenUtil.generateTokenCode();
        SecurityUserEntity user = (SecurityUserEntity) authentication.getPrincipal();
        
        UserVo vo = new UserVo();
        vo.setId(user.getUserId());
        vo.setLoginName(user.getLoginName());
        vo.setName(user.getUsername());
        vo.setMobile(user.getUserMobile());
        vo.setSex(user.getUserSex()	!=	null ? user.getUserSex().intValue() : null);
        if(user.getOrg()!=null){
        	vo.setDeptName(user.getOrg().getDeptName());
        	vo.setDeptId(user.getOrg().getDeptId());
        	vo.setAptCd(user.getOrg().getAptCd());
        }
        redisService.set(SysContants.USER_TOKEN_NAMESPACE, token,user , SysContants.USER_TOKEN_EXPIRE);
        return new AuthenticationResponse(token,vo);
    }


    /*@Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())){
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }*/
}
