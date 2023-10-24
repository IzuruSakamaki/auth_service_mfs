package com.mfs.auth.service.user;

import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.entity.user.UserModel;
import com.mfs.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
    public UserModel readUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserModel readUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserModel readUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public List<UserModel> readAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String updateUser(UserModel requestUser, int id) {
        UserModel userModel = userRepository.findById(id).orElse(null);
        if (!ObjectUtils.isEmpty(userModel)) {
            userModel.setUsername(requestUser.getUsername());
            userModel.setPassword(requestUser.getPassword());
            return this.createUser(userModel);
        }
        return ConstantConfiguration.FAILED;
    }

    @Override
    public String deleteUser(int id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            return ConstantConfiguration.ERROR;
        }
        return ConstantConfiguration.SUCCESS;
    }
}
