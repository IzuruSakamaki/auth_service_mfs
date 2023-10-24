package com.mfs.auth.repository;

import com.mfs.auth.entity.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
