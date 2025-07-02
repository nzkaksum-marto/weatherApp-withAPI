package com.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    @JsonProperty("StudentId")
    private int studentId;
    @JsonProperty("StudentName")
    private String studentName;
    @JsonProperty("Course")
    private String course;

    // Default constructor
    public Student() {}

    // Getters and setters
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
}