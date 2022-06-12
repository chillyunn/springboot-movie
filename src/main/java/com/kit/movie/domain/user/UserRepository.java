package com.kit.movie.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByLoginID(String loginID);
    User findByName(String name);
}
