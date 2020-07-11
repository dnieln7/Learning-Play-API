package com.dnieln7.learningplay.data.repository;

import com.dnieln7.learningplay.data.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
