package com.mfs.auth.entity;

import jakarta.persistence.*;
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
    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private String refresh;
    @Column(nullable = false)
    private long expiryTime;
    @OneToOne
    @JoinColumn(name = "email", nullable = false)
    private UserModel code;
}
