package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    boolean deleteUser(Long id);

    /**
     * 根据用户名字查询用户信息
     * @param userName
     */
    Optional<User> findUserById(Long id);
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
