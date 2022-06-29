package com.pavelrovba.elective.model.entity;

import com.pavelrovba.elective.model.entity.enums.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class Professor implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(unique = true)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course courseName;
    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "professor_role", joinColumns = @JoinColumn(name = "professor_id"))
    private Set<Role> role= new HashSet<>();
    @Transient
    private Collection<? extends GrantedAuthority> authorities;


    public Professor(int id, String login, String email, String password,Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public Professor() {

    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
