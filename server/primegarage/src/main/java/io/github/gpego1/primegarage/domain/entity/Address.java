package io.github.gpego1.primegarage.domain.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
