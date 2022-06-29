package com.pavelrovba.elective.service;

import com.pavelrovba.elective.exceptions.UserExistException;
import com.pavelrovba.elective.model.entity.Professor;
import com.pavelrovba.elective.model.entity.enums.Role;
import com.pavelrovba.elective.payload.request.SignupRequest;
import com.pavelrovba.elective.repository.ProfessorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final ProfessorRepository professorRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(ProfessorRepository professorRepository, BCryptPasswordEncoder passwordEncoder) {
        this.professorRepository = professorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Professor createUser(SignupRequest userIn) {
        Professor user = new Professor();
        user.setEmail(userIn.getEmail());
        user.setName(userIn.getFirstname());
        user.setSurname(userIn.getLastname());
        user.setLogin(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRole().add(Role.ROLE_USER);

        try {
            LOG.info("Saving User {}", userIn.getEmail());
            return professorRepository.save(user);
        } catch (Exception e) {
            LOG.error("Error during registration. {}", e.getMessage());
            throw new UserExistException("The user " + user.getUsername() + " already exist. Please check credentials");
        }
    }


}
