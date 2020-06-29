package com.dnieln7.javaspringapi.data.repository;

import com.dnieln7.javaspringapi.data.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByEmail(String email);
}
