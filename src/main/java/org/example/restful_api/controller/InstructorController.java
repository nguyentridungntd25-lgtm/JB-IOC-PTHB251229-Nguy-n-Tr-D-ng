package org.example.restful_api.controller;

import org.example.restful_api.dto.InstructorCreateRequest;
import org.example.restful_api.model.Instructor;
import org.example.restful_api.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        return ResponseEntity.ok(
                instructorService.findAllInstructors()
        );
    }

    @PostMapping
    public ResponseEntity<Instructor> createInstructor(
            @RequestBody InstructorCreateRequest req
    ) {

        Instructor instructor =
                instructorService.createInstructor(req);

        return ResponseEntity.status(201).body(instructor);
    }
}