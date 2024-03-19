package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.utils.MybatisUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User findUserById(int id);
    void insertUser(User user);
    int updateUserById(User user);
    int deleteUserById(int id);

    void deleteUserByIdList(List idList);
    void updateUserByMap(Map map);
    List<User> findByCondition(User user);
}
