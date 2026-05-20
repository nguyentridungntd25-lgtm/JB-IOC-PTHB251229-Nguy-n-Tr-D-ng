package org.example.restful_api.controller;

import org.example.restful_api.dto.StudentEnrollmentRequest;
import org.example.restful_api.payload.ApiResponse;
import org.example.restful_api.service.StudentEnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students-enrollments")
public class StudentEnrollmentController {

    private final StudentEnrollmentService enrollmentService;

    @Autowired
    public StudentEnrollmentController(
            StudentEnrollmentService enrollmentService
    ) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> enrollStudent(
            @RequestBody StudentEnrollmentRequest req
    ) {

        enrollmentService.enrollStudent(
                req.getStudentId(),
                req.getCourseId()
        );

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Student Enrolled Successfully",
                        true,
                        null
                )
        );
    }
}