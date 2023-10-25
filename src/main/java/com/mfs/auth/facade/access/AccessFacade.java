package com.mfs.auth.facade.access;

import com.mfs.auth.entity.BaseResponse;
import com.mfs.auth.entity.access.AccessRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccessFacade extends UserDetailsService {
    BaseResponse createAccess(AccessRequest accessRequest);
}
