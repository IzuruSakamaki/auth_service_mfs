package com.mfs.auth.facade.user;

import com.mfs.auth.entity.BaseResponse;
import com.mfs.auth.entity.user.UserRequest;

public interface UserFacade {
    BaseResponse createUser(UserRequest userRequest);
}
