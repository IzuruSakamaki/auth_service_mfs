package com.mfs.auth.service;

import com.mfs.auth.entity.UserModel;

import java.util.List;

public interface UserService {
    String createUser(UserModel userModel);
    UserModel readUserById(int id);
    List<UserModel> readAllUser();
    String updateUser(UserModel requestUser, int id);
    String deleteUser(int id);
}
