package com.mfs.auth.entity.access;

import com.mfs.auth.entity.user.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "accessModel")
public class AccessModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
