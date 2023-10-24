package com.mfs.auth.facade.access;

import com.mfs.auth.configuration.AccessConfiguration;
import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.configuration.TokenConfiguration;
import com.mfs.auth.entity.BaseResponse;
import com.mfs.auth.entity.user.UserModel;
import com.mfs.auth.entity.access.AccessModel;
import com.mfs.auth.entity.access.AccessRequest;
import com.mfs.auth.service.access.AccessService;
import com.mfs.auth.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

@Component
public class AccessFacadeImpl implements AccessFacade {
    @Autowired
    UserService userService;
    @Autowired
    AccessService accessService;
    @Autowired
    TokenConfiguration tokenConfiguration;

    @Override
    public BaseResponse createAccess(AccessRequest accessRequest) {
        UserModel userModel = accessRequest.getCode().contains("@") ?
            userService.readUserByEmail(accessRequest.getCode()) :
            userService.readUserByUsername(accessRequest.getCode());
        BaseResponse baseResponse = BaseResponse.builder().timestamp(new Date().getTime()).build();
        AccessModel accessModel = AccessModel.builder()
            .code(Objects.nonNull(userModel) ? userModel : null)
            .token(tokenConfiguration.encryptToken(accessRequest, 1800000))
            .refresh(tokenConfiguration.encryptToken(accessRequest, 3600000))
            .expiryTime(System.currentTimeMillis() + 1800000)
            .build();
        if (Objects.nonNull(userModel) &&
                Objects.equals(accessService.createAccess(accessModel), ConstantConfiguration.SUCCESS)) {
            baseResponse.setData(accessModel);
        } else {
            baseResponse.setData(ConstantConfiguration.FAILED);
        }
        return baseResponse;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserModel userModel = userService.readUserByEmail(email);
        if (Objects.nonNull(userModel)) {
            return new AccessConfiguration(userModel);
        } else {
            throw new UsernameNotFoundException("User not found: " + email);
        }
    }
}
