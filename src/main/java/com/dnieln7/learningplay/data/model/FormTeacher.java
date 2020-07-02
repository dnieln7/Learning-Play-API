package com.dnieln7.learningplay.data.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "forms_teacher")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class FormTeacher implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    private String title;
    private String lesson;
    @OneToOne
    private User teacher;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String questions;

    public FormTeacher() {
    }

    public FormTeacher(int id, String title, String lesson, User teacher, String questions) {
        this.id = id;
        this.title = title;
        this.lesson = lesson;
        this.teacher = teacher;
        this.questions = questions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }
}
