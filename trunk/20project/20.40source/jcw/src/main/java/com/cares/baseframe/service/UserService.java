package com.cares.baseframe.service;

import com.cares.baseframe.bean.PageInfo;
import com.cares.baseframe.bean.UserBean;
import com.cares.baseframe.bean.UserVo;
import com.cares.baseframe.model.User;

/**
 * @description：用户管理
 * @author：
 * @date：
 */
public interface UserService {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    UserBean findUserByLoginName(String username);

    /**
     * 根据用户id查询用户
     *
     * @param id
     * @return
     */
    User findUserById(Long id);

    /**
     * 用户列表
     *
     * @param pageInfo
     */
    void findDataGrid(PageInfo pageInfo);

    /**
     * 添加用户
     *
     * @param userVo
     */
    void addUser(UserVo userVo);

    /**
     * 修改密码
     *
     * @param userId
     * @param pwd
     */
    void updateUserPwdById(Long userId, String pwd);

    /**
     * 根据用户id查询用户带部门
     *
     * @param id
     * @return
     */
    UserVo findUserVoById(Long id);

    /**
     * 修改用户
     *
     * @param userVo
     */
    void updateUser(UserVo userVo);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteUserById(Long id);
}
