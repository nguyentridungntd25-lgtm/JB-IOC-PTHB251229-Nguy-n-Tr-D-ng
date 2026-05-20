package org.example.restful_api.service;

import org.example.restful_api.dto.CourseCreateRequest;
import org.example.restful_api.dto.CourseUpdateRequest;
import org.example.restful_api.model.Course;
import org.example.restful_api.model.Instructor;
import org.example.restful_api.repository.CourseRepository;
import org.example.restful_api.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository,
                         InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    public void createCourse(CourseCreateRequest req) {

        Instructor instructor =
                instructorRepository.findById(req.getInstructorId())
                        .orElseThrow(() ->
                                new RuntimeException("Instructor not found"));

        Course course = new Course();

        course.setTitle(req.getTitle());
        course.setInstructor(instructor);

        courseRepository.save(course);
    }

    public void updateCourse(Long id,
                             CourseUpdateRequest req) {

        Course course = courseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Course not found"));

        Instructor instructor =
                instructorRepository.findById(req.getInstructorId())
                        .orElseThrow(() ->
                                new RuntimeException("Instructor not found"));

        course.setTitle(req.getTitle());
        course.setInstructor(instructor);

        courseRepository.save(course);
    }
}
