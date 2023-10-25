package com.mfs.auth.entity.access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessRequest {
    private String code;
    private String password;
}
