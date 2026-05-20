package org.example.restful_api.controller;

import org.example.restful_api.dto.CourseCreateRequest;
import org.example.restful_api.dto.CourseUpdateRequest;
import org.example.restful_api.payload.ApiResponse;
import org.example.restful_api.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createCourse(
            @RequestBody CourseCreateRequest req
    ) {

        courseService.createCourse(req);

        return ResponseEntity.status(201)
                .body(new ApiResponse<>(
                        "Course Created Successfully",
                        true,
                        null
                ));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateCourse(
            @PathVariable Long id,
            @RequestBody CourseUpdateRequest req
    ) {

        courseService.updateCourse(id, req);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Course Updated Successfully",
                        true,
                        null
                )
        );
    }
}