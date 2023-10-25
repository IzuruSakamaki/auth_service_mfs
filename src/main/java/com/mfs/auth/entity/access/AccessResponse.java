package com.mfs.auth.entity.access;

import com.mfs.auth.entity.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccessResponse {
    private String token;
    private long expired;
    private RoleEnum role;
}
