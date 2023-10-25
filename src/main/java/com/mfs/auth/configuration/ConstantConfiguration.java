package com.mfs.auth.configuration;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class ConstantConfiguration {
    public static final String ERROR = "error";
    public static final String FAILED = "failed";
    public static final String SUCCESS = "success";

    // Validation Error Message
    public static final String ID_ERROR_VALIDATION = "id_is_not_blank";
    public static final String EMAIL_ERROR_VALIDATION = "email_is_blank";
    public static final String USERNAME_ERROR_VALIDATION = "username_is_blank";
    public static final String PASSWORD_ERROR_VALIDATION = "password_is_blank";
    public static final String EMAIL_OR_USERNAME_ERROR_VALIDATION = "email_or_username_is_blank";


    public static final String AUTH_SECRET_KEY = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

}
