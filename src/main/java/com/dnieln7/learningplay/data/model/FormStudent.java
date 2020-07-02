package com.dnieln7.learningplay.data.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "forms_student")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class FormStudent {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;
    private String title;
    private String lesson;
    @OneToOne
    private User student;
    private double grade;
    private Date date;
    private String comments;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String content;

    public FormStudent() {
    }

    public FormStudent(int id, String title, String lesson, User student, double grade, Date date, String comments, String content) {
        this.id = id;
        this.title = title;
        this.lesson = lesson;
        this.student = student;
        this.grade = grade;
        this.date = date;
        this.comments = comments;
        this.content = content;
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

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
