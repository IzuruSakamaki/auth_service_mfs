package com.mfs.auth.service.user;

import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.entity.user.UserModel;
import com.mfs.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String createUser(UserModel userModel) {
        try {
            userRepository.save(userModel);
        } catch (Exception e) {
            return ConstantConfiguration.ERROR;
        }
        return ConstantConfiguration.SUCCESS;
    }

    @Override
    public UserModel readUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserModel readUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
