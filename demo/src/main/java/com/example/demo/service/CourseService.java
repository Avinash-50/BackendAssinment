package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    // Constructor injection
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Create
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    // Update
    public Course updateCourse(Long id, Course course) {
        Optional<Course> existing = courseRepository.findById(id);
        if (existing.isPresent()) {
            Course c = existing.get();
            c.setCourseName(course.getCourseName());
            c.setSubject(course.getSubject());
            c.setNumberOfChapters(course.getNumberOfChapters());
            c.setType(course.getType());
            c.setMode(course.getMode());
            return courseRepository.save(c);
        }
        return null; // agar id nahi mila toh null return karega
    }

    // Get all
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
