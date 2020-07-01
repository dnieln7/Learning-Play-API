package com.dnieln7.learningplay.data.repository;

import com.dnieln7.learningplay.data.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByEmail(String email);
}
