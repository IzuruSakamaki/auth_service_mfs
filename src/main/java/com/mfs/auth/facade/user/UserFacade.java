package com.mfs.auth.facade.user;

import com.mfs.auth.entity.BaseResponse;
import com.mfs.auth.entity.role.RoleRequest;
import com.mfs.auth.entity.user.UserRequest;

public interface UserFacade {
    BaseResponse createUser(UserRequest userRequest);
    BaseResponse updateRole(RoleRequest roleRequest);
    BaseResponse deleteUser(String code);
}
