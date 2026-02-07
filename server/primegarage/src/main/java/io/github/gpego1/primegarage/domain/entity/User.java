package io.github.gpego1.primegarage.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true)
    private String username;
    private String password;

    private String name;
    private String mobileNumber;
    private LocalDateTime dateOfBirth;
    private Roles role;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {}

    public User(String username, String password, String name, Roles role, String mobileNumber, LocalDateTime dateOfBirth) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.role.name()));
    }

}
