package io.github.gpego1.primegarage.domain.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Getter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String make;
    private BigDecimal price;

    private String fuel_type;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Store addToAStore(Store store) {
       return this.store = store;
    }
    public Order addToAOrder(Order order) {
        return this.order = order;
    }

    public Car() {}

    public Car(String model,
               String make,
               BigDecimal price,
               String fuel_type) {}

}
