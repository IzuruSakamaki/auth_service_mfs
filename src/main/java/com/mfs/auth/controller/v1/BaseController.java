package com.mfs.auth.controller.v1;

import com.mfs.auth.facade.access.AccessFacade;
import com.mfs.auth.validation.UserModelValidation;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    UserModelValidation userModelValidation;
    @Autowired
    AccessFacade accessFacade;
}
