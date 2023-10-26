package com.mfs.auth.entity.role;

public enum RoleEnum {
    SUPER_ADMIN(11),
    ADMIN(12),
    GENERAL(77);

    final int authorizationRole;

    RoleEnum (int authorizationRole) {
        this.authorizationRole = authorizationRole;
    }
}
