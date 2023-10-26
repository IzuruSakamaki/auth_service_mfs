package com.mfs.auth.entity.role;

import com.mfs.auth.entity.role.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    private String code;
    private RoleEnum role;
}
