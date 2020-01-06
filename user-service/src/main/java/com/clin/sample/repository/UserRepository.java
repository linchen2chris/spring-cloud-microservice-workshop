package com.clin.sample.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.clin.sample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
