package com.feiyang.interviewdemo.mybatisDemo.mapper;

import com.feiyang.interviewdemo.mybatisDemo.model.User;

import java.util.List;

/**
 * @author jiahuiyang
 */
public interface UserMapper {

    /**
     * 新增用戶
     *
     * @param user
     * @return
     * @throws Exception
     */
    int insertUser(User user) throws Exception;

    /**
     * 修改用戶
     *
     * @param user
     * @return
     * @throws Exception
     */
    int updateUser(User user) throws Exception;

    /**
     * 刪除用戶
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteUser(Integer id) throws Exception;

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    User selectUserById(Integer id) throws Exception;

    /**
     * 查询所有的用户信息
     *
     * @return
     * @throws Exception
     */
    List<User> selectAllUser() throws Exception;
}
