package com.xgroup.unknown.repositories;

import com.xgroup.unknown.model.entities.Auth.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity,Long> {
}
