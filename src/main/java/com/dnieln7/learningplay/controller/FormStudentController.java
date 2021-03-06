package com.dnieln7.learningplay.controller;

import com.dnieln7.learningplay.data.model.FormStudent;
import com.dnieln7.learningplay.data.repository.FormStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormStudentController {

    @Autowired
    private FormStudentRepository repository;

    @GetMapping("/forms/student")
    public List<FormStudent> getForms() {
        return (List<FormStudent>) repository.findAll();
    }

    @GetMapping("/forms/student/{id}")
    public FormStudent getFormById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/forms/student")
    public FormStudent postForm(@RequestBody FormStudent formStudent) {
        return repository.save(formStudent);
    }

    @PutMapping("/forms/student/{id}")
    public FormStudent putForm(@PathVariable int id, @RequestBody FormStudent formStudent) {
        formStudent.setId(id);

        return repository.save(formStudent);
    }
}
