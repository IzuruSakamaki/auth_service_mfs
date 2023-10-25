package com.mfs.auth.facade.user;

import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.entity.BaseResponse;
import com.mfs.auth.entity.RoleEnum;
import com.mfs.auth.entity.user.UserModel;
import com.mfs.auth.entity.user.UserRequest;
import com.mfs.auth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserFacadeImpl implements UserFacade {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;
    @Override
    public BaseResponse createUser(UserRequest userRequest) {
        String response = userService.createUser(UserModel.builder()
                .email(userRequest.getEmail())
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(RoleEnum.GENERAL).build());
        return BaseResponse.builder()
                .status(!Objects.equals(response, ConstantConfiguration.SUCCESS) ? 400 : 200)
                .data(response).build();
    }
}
