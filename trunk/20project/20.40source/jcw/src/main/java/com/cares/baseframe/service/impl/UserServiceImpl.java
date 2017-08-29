package com.cares.baseframe.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.bean.UserRoleBean;
import com.cares.baseframe.bean.UserVo;
import com.cares.baseframe.mapper.UserMapper;
import com.cares.baseframe.mapper.UserRoleMapper;
import com.cares.baseframe.model.User;
import com.cares.baseframe.model.UserRole;
import com.cares.baseframe.service.UserService;



@Service
public class UserServiceImpl implements UserService {

    private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public UserBean findUserByLoginName(String username) {
        return userMapper.findUserByLoginName(username);
    }

    @Override
    public User findUserById(Long id) {
        return userMapper.findUserById(id);
    }
    @Override
    public void findDataGrid(PageInfo pageInfo) {
        pageInfo.setRows(userMapper.findUserPageCondition(pageInfo));
        pageInfo.setTotal(userMapper.findUserPageCount(pageInfo));
    }

    @Override
    public void addUser(UserVo userVo) {
        User user = new User();
    	user.setLoginName(userVo.getLoginName());
    	user.setUserName(userVo.getName());
    	user.setUserPwd(userVo.getPassword());
    	user.setUserSex(userVo.getSex().byteValue());
    	user.setValidity(userVo.getStatus().byteValue());
    	user.setDeptId(userVo.getDeptId());
    	user.setUserMobile(userVo.getMobile());
        userMapper.insert(user);

        Long id = user.getUserId();
        String[] roles = userVo.getRoleIds().split(",");
        UserRole userRole = new UserRole();

        for (String string : roles) {
            userRole.setUserId(id);
            userRole.setRoleId(Long.valueOf(string));
            userRoleMapper.insert(userRole);
        }
    }

    @Override
    public void updateUserPwdById(Long userId, String pwd) {
        userMapper.updateUserPwdById(userId, pwd);
    }

    @Override
    public UserVo findUserVoById(Long id) {
        return userMapper.findUserVoById(id);
    }

    @Override
    public void updateUser(UserVo userVo) {
        User user = new User();
    	user.setUserId(userVo.getId());
    	user.setLoginName(userVo.getLoginName());
    	user.setUserName(userVo.getName());
    	user.setUserPwd(userVo.getPassword());
    	user.setUserSex(userVo.getSex().byteValue());
    	user.setValidity(userVo.getStatus().byteValue());
    	user.setDeptId(userVo.getDeptId());
    	user.setUserMobile(userVo.getMobile());
        userMapper.updateUser(user);
        Long id = userVo.getId();
        List<UserRoleBean> userRoles = userRoleMapper.findUserRoleByUserId(id);
        if (userRoles != null && (!userRoles.isEmpty())) {
            for (UserRoleBean userRole : userRoles) {
                userRoleMapper.deleteById(userRole.getId());
            }
        }

        String[] roles = userVo.getRoleIds().split(",");
        UserRole userRole = new UserRole();
        for (String string : roles) {
            userRole.setUserId(id);
            userRole.setRoleId(Long.valueOf(string));
            userRoleMapper.insert(userRole);
        }

    }

    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteById(id);
        List<UserRoleBean> userRoles = userRoleMapper.findUserRoleByUserId(id);
        if(!CollectionUtils.isEmpty(userRoles))  {
            for (UserRoleBean userRole : userRoles) {
                userRoleMapper.deleteById(userRole.getId());
            }
        }
    }

}
