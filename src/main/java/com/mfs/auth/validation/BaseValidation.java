package com.mfs.auth.validation;

import com.mfs.auth.configuration.ConstantConfiguration;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;

import java.util.Objects;

public abstract class BaseValidation {
    protected void validateNotBlank(String value, Errors errors, String defaultMessage) {
        if (StringUtils.isBlank(value)) {
            errors.reject(ConstantConfiguration.ERROR, defaultMessage);
        }
    }
    protected void validateNotNull(Object value, Errors errors, String defaultMessage) {
        if (Objects.isNull(value)) {
            errors.reject(ConstantConfiguration.ERROR, defaultMessage);
        }
    }

    protected void validateEmail(String value, Errors errors, String defaultMessage) {
        if (StringUtils.isBlank(value) || !value.contains("@")) {
            errors.reject(ConstantConfiguration.ERROR, defaultMessage);
        }
    }
}
