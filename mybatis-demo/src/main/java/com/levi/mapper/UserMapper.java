package com.levi.mapper;

import com.levi.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectUser();
    User selectUserById(int id);
}
