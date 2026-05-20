package org.example.restful_api.repository;

import org.example.restful_api.model.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentEnrollmentRepository
        extends JpaRepository<StudentEnrollment, Long> {
}