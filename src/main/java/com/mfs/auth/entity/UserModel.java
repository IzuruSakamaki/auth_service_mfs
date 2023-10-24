package com.mfs.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userModel")
public class UserModel {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String username;
    private String password;
}
