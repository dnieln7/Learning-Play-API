package com.dnieln7.learningplay.controller;

import com.dnieln7.learningplay.data.model.Post;
import com.dnieln7.learningplay.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository repository;

    @GetMapping("/posts")
    public List<Post> getPost() {
        return (List<Post>) repository.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/posts")
    public Post postPost(@RequestBody Post post) {
        return repository.save(post);
    }
}
