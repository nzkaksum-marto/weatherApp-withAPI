package com.example;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("API.json");
            if (inputStream == null) {
                throw new RuntimeException("API.json not found in resources!");
            }
            StudentList studentList = objectMapper.readValue(inputStream, StudentList.class);
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
