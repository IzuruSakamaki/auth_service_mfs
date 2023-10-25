package com.mfs.auth.facade.access;

import com.mfs.auth.configuration.AccessConfiguration;
import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.configuration.TokenConfiguration;
import com.mfs.auth.entity.BaseResponse;
import com.mfs.auth.configuration.EnvironmentConfiguration;
import com.mfs.auth.entity.access.AccessResponse;
import com.mfs.auth.entity.user.UserModel;
import com.mfs.auth.entity.access.AccessRequest;
import com.mfs.auth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class AccessFacadeImpl implements AccessFacade {
    @Autowired
    UserService userService;
    @Autowired
    EnvironmentConfiguration environmentConfiguration;
    @Autowired
    TokenConfiguration tokenConfiguration;

    @Override
    public BaseResponse createAccess(AccessRequest accessRequest) {
        UserModel userModel = getCandidate(accessRequest.getCode());
        if (Objects.nonNull(userModel)) {
            return BaseResponse.builder().status(201).data(AccessResponse.builder()
                .token(tokenConfiguration.encryptToken(accessRequest))
                .expired(System.currentTimeMillis() + environmentConfiguration.getJwt_lifetime())
                .role(userModel.getRole()).build()).build();
        } else {
            return BaseResponse.builder().status(404).data(ConstantConfiguration.FAILED).build();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
        UserModel userModel = getCandidate(code);
        if (Objects.nonNull(userModel)) {
            return new AccessConfiguration(userModel);
        } else {
            throw new UsernameNotFoundException("User not found: " + code);
        }
    }

    private UserModel getCandidate(String code) {
        return code.contains("@") ? userService.readUserByEmail(code) : userService.readUserByUsername(code);
    }
}
