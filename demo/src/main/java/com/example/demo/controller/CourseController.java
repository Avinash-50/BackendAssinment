package com.example.demo.controller;

import com.example.demo.dto.StudentCourseDTO;
import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Create API
    @PostMapping("/create")
    public Course create(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    // Update API
    @PutMapping("/update/{id}")
    public Course update(@PathVariable Long id, @RequestBody Course course) {
        return courseService.updateCourse(id, course);
    }

    // Get API (role-based)
    @GetMapping("/get")
    public Object getAllCourses(@RequestParam String role) {
        List<Course> courses = courseService.getAllCourses();

        if ("student".equalsIgnoreCase(role)) {
            // Student ko limited info dena
            return courses.stream()
                    .map(c -> new StudentCourseDTO(
                            c.getCourseName(),
                            c.getNumberOfChapters(),
                            c.getType(),
                            c.getMode()
                    ))
                    .toList();
        } else if ("teacher".equalsIgnoreCase(role)) {
            // Teacher ko full details
            return courses;
        } else if ("developer".equalsIgnoreCase(role) || "contentdeveloper".equalsIgnoreCase(role)) {
            // Developer ko bhi full details (abhi same as teacher)
            return courses;
        } else {
            return "Invalid role. Please use student, teacher, or developer.";
        }
    }
}
