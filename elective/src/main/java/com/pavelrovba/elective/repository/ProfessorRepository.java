package com.pavelrovba.elective.repository;

import com.pavelrovba.elective.model.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {

    Optional<Professor> findProfessorByLogin(String login);

    Optional<Professor> findProfessorById(Integer id);

    Optional<Professor> findProfessorByCourseName(String courseName);


}
