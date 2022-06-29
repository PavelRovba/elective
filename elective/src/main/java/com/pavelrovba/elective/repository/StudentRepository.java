package com.pavelrovba.elective.repository;

import com.pavelrovba.elective.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    Optional<Student> findStudentByLogin(String login);

    Optional<Student> findStudentById(Integer integer);

    Optional<Student> findStudentByEmail(Integer integer);
}
