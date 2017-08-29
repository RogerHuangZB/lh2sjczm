package com.cares.baseframe.mapper;

import java.util.List;

import com.cares.baseframe.bean.UserRoleBean;
import com.cares.baseframe.model.UserRole;



public interface UserRoleMapper {

    int insert(UserRole userRole);

    int updateByPrimaryKeySelective(UserRole userRole);

    List<UserRoleBean> findUserRoleByUserId(Long id);

    int deleteById(Long id);

    List<Long> findRoleIdListByUserId(Long userId);
}