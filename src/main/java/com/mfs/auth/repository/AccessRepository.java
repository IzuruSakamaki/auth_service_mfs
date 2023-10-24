package com.mfs.auth.repository;

import com.mfs.auth.entity.access.AccessModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccessRepository extends JpaRepository<AccessModel, Integer> {
}
