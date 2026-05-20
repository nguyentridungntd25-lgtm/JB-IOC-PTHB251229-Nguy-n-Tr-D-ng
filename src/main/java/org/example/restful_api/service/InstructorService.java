package org.example.restful_api.service;

import org.example.restful_api.dto.InstructorCreateRequest;
import org.example.restful_api.model.Instructor;
import org.example.restful_api.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    public Instructor createInstructor(InstructorCreateRequest req) {

        Instructor instructor = new Instructor();

        instructor.setName(req.getName());
        instructor.setEmail(req.getEmail());

        return instructorRepository.save(instructor);
    }
}