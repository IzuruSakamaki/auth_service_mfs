package com.mfs.auth.service.user;

import com.mfs.auth.entity.user.UserModel;

import java.util.List;

public interface UserService {
    String createUser(UserModel userModel);
    UserModel readUserById(int id);
    UserModel readUserByUsername(String username);
    UserModel readUserByEmail(String email);
    List<UserModel> readAllUser();
    String updateUser(UserModel requestUser, int id);
    String deleteUser(int id);
}
