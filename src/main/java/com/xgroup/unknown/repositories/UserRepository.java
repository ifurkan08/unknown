package com.xgroup.unknown.repositories;

import com.xgroup.unknown.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}
