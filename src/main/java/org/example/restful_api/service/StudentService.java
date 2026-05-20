package org.example.restful_api.service;

import org.example.restful_api.dto.StudentCreateRequest;
import org.example.restful_api.model.Student;
import org.example.restful_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void createStudent(StudentCreateRequest req) {

        Student student = new Student();

        student.setName(req.getName());
        student.setEmail(req.getEmail());

        studentRepository.save(student);
    }
}