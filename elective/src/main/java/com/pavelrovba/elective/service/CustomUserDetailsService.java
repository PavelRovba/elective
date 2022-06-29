package com.pavelrovba.elective.service;

import com.pavelrovba.elective.model.entity.Professor;
import com.pavelrovba.elective.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ProfessorRepository professorRepository;

    @Autowired
    public CustomUserDetailsService( ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;

    }


       public UserDetails loadUserById(int id) throws UsernameNotFoundException {

        return professorRepository.findProfessorById(id).orElse(null);
    }

    public static Professor build(Professor professor){
        List<GrantedAuthority> authorities = professor.getRole().stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
        return new Professor(
                professor.getId(),
                professor.getLogin(),
                professor.getEmail(),
                professor.getPassword(),
                authorities);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Professor professor = professorRepository.findProfessorByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found with username: " + login));
        return build(professor);
    }
}
