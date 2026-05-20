package org.example.restful_api.repository;

import org.example.restful_api.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository
        extends JpaRepository<Instructor, Long> {
}