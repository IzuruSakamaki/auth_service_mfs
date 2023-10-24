package com.mfs.auth.facade.user;

import com.mfs.auth.entity.BaseResponse;
import com.mfs.auth.entity.RoleEnum;
import com.mfs.auth.entity.user.UserModel;
import com.mfs.auth.entity.user.UserRequest;
import com.mfs.auth.service.user.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserFacadeImpl implements UserFacade {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserService userService;
    @Override
    public BaseResponse createUser(UserRequest userRequest) {
        if (ObjectUtils.isEmpty(userRequest.getRole())) userRequest.setRole(RoleEnum.GENERAL);
        return BaseResponse.builder()
            .data(userService.createUser(UserModel.builder()
                .email(userRequest.getEmail())
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(userRequest.getRole()).build()))
            .timestamp(new Date().getTime()).build();
    }
}
