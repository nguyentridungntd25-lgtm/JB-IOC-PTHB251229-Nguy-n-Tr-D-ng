package org.example.restful_api.controller;

import org.example.restful_api.dto.StudentCreateRequest;
import org.example.restful_api.payload.ApiResponse;
import org.example.restful_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createStudent(
            @RequestBody StudentCreateRequest req
    ) {

        studentService.createStudent(req);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Student Created Successfully",
                        true,
                        null
                )
        );
    }
}