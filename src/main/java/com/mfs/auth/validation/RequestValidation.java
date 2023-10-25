package com.mfs.auth.validation;

import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.entity.access.AccessRequest;
import com.mfs.auth.entity.user.UserRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class RequestValidation extends BaseValidation {
    public void validate(Object request, Errors errors) {
        if (request instanceof UserRequest payload) {
            validateEmail(payload.getEmail(), errors, ConstantConfiguration.EMAIL_ERROR_VALIDATION);
            validateNotBlank(payload.getUsername(), errors, ConstantConfiguration.USERNAME_ERROR_VALIDATION);
            validateNotBlank(payload.getPassword(), errors, ConstantConfiguration.PASSWORD_ERROR_VALIDATION);
        } else if (request instanceof AccessRequest payload) {
            validateNotBlank(payload.getCode(), errors, ConstantConfiguration.EMAIL_OR_USERNAME_ERROR_VALIDATION);
            validateNotBlank(payload.getPassword(), errors, ConstantConfiguration.PASSWORD_ERROR_VALIDATION);
        }
    }
}
