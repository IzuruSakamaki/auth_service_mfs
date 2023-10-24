package com.mfs.auth.configuration;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ConstantConfiguration {
    public static final String ERROR = "error";
    public static final String FAILED = "failed";
    public static final String SUCCESS = "success";

    // Validation Error Message
    public static final String EMAIL_ERROR_VALIDATION = "email_is_blank";
    public static final String USERNAME_ERROR_VALIDATION = "username_is_blank";
    public static final String PASSWORD_ERROR_VALIDATION = "password_is_blank";

    // Validator Event
    public static final String CREATE_USER_VALIDATOR = "create_user_validator";
}
