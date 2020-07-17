package com.dnieln7.learningplay.controller;

import com.dnieln7.learningplay.controller.response.DeleteResponse;
import com.dnieln7.learningplay.data.model.FormTeacher;
import com.dnieln7.learningplay.data.repository.FormTeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FormTeacherController {

    @Autowired
    private FormTeacherRepository repository;

    @GetMapping("/forms/teacher")
    public List<FormTeacher> getForms() {
        return (List<FormTeacher>) repository.findAll();
    }

    @GetMapping("/forms/teacher/{id}")
    public FormTeacher getFormById(@PathVariable int id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping("/forms/teacher")
    public FormTeacher postForm(@RequestBody FormTeacher formTeacher) {
        return repository.save(formTeacher);
    }

    @DeleteMapping("/forms/teacher/{id}")
    public DeleteResponse deleteForm(@PathVariable int id) {
        FormTeacher formTeacher = repository.findById(id).orElse(null);

        if (formTeacher == null) {
            return new DeleteResponse(1, "Not found!");
        }

        repository.delete(formTeacher);

        return new DeleteResponse(1, "Deleted!");
    }
}
