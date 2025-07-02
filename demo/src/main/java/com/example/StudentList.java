package com.example;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentList {
    @JsonProperty("Student")
    private List<Student> Student;

    public List<Student> getStudent() { return Student; }
    public void setStudent(List<Student> student) { Student = student; }
}