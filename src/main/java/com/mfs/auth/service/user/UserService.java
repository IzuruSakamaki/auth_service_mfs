package com.mfs.auth.service.user;

import com.mfs.auth.entity.user.UserModel;

import java.util.List;

public interface UserService {
    String createUser(UserModel userModel);
    UserModel readUserByUsername(String username);
    UserModel readUserByEmail(String email);
    String deleteUser(int id);
}
