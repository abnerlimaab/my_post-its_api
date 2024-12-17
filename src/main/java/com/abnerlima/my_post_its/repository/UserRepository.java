package com.abnerlima.my_post_its.repository;

import com.abnerlima.my_post_its.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    public User findByEmail(String email);
}
