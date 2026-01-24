package io.github.gpego1.primegarage.domain.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    private String name;
    private String mobileNumber;
    private LocalDateTime dateOfBirth;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    public User() {}

    public User(String username, String password, String name, String mobileNumber, LocalDateTime dateOfBirth) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }
//    private List<?> roles;
}
