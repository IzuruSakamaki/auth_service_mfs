package com.mfs.auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accessModel")
public class AccessModel {
    @Id
    @GeneratedValue
    private int id;
    private String token;
    private String refresh;
    private long expiryTime;
    private String code;
}
