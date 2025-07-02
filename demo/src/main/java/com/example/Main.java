package com.example;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new File("demo/src/main/resources/API.json");
            StudentList studentList = objectMapper.readValue(file, StudentList.class);
            for (Student student : studentList.getStudent()) {
                System.out.print("  Student name: " + student.getStudentName());
                System.out.print("  Student ID: " + student.getStudentId());
                System.out.println("  Course: " + student.getCourse());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
