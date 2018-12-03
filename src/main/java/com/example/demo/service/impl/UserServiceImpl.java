package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        boolean flag = false;
        try {
            userDao.save(user);
            flag = true;
        } catch (Exception e) {
            System.out.println("新增失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateUser(User user) {
        boolean flag = false;
        try {
            userDao.save(user);
            flag = true;
        } catch (Exception e) {
            System.out.println("修改失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteUser(Long id) {
        boolean flag = false;
        try {
            userDao.deleteById(id);
            flag = true;
        } catch (Exception e) {
            System.out.println("删除失败!");
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
