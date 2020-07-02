package com.dnieln7.learningplay.controller;

import com.dnieln7.learningplay.data.model.FormStudent;
import com.dnieln7.learningplay.data.repository.FormStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormStudentController {

    @Autowired
    private FormStudentRepository formStudentRepository;

    @GetMapping("/forms/student")
    public List<FormStudent> getForms() {
        return (List<FormStudent>) formStudentRepository.findAll();
    }

    @GetMapping("/forms/student/{id}")
    public FormStudent getFormById(@PathVariable int id) {
        return formStudentRepository.findById(id).orElse(null);
    }

    @PostMapping("/forms/student")
    public FormStudent postForm(@RequestBody FormStudent formStudent) {
        return formStudentRepository.save(formStudent);
    }
}
