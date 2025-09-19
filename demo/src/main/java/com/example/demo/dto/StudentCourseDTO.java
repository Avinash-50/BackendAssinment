package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentCourseDTO {
    private String courseName;
    private int numberOfChapters;
    private String type;
    private String mode;
}

