package com.mfs.auth.entity.access;

import com.mfs.auth.entity.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessResponse {
    private String token;
    private String refresh;
    private long expiryTime;
    private RoleEnum role;
}
