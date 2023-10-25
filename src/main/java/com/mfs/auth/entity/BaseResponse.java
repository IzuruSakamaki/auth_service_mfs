package com.mfs.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse {
    int status;
    Object data;
    final long timestamp = new Date().getTime();
}
