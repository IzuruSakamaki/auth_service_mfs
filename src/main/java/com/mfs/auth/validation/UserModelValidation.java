package com.mfs.auth.validation;

import com.mfs.auth.configuration.ConstantConfiguration;
import com.mfs.auth.entity.UserModel;
import org.springframework.validation.Errors;

public class UserModelValidation extends BaseValidation {
    public void validate(String name, UserModel userModel, Errors errors) {
        if (name.equals(ConstantConfiguration.CREATE_USER_VALIDATOR)) {
             validateNotBlank(userModel.getEmail(), errors, ConstantConfiguration.EMAIL_ERROR_VALIDATION);
             validateNotBlank(userModel.getUsername(), errors, ConstantConfiguration.USERNAME_ERROR_VALIDATION);
             validateNotBlank(userModel.getPassword(), errors, ConstantConfiguration.PASSWORD_ERROR_VALIDATION);
        }
        if (name.equals(ConstantConfiguration.CREATE_USER_VALIDATOR)) {
            validateNotBlank(userModel.getEmail(), errors, ConstantConfiguration.EMAIL_ERROR_VALIDATION);
            validateNotBlank(userModel.getUsername(), errors, ConstantConfiguration.USERNAME_ERROR_VALIDATION);
            validateNotBlank(userModel.getPassword(), errors, ConstantConfiguration.PASSWORD_ERROR_VALIDATION);
        }
    }
}
