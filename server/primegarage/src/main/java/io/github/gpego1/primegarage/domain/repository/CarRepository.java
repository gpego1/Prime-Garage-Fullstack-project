package io.github.gpego1.primegarage.domain.repository;
import io.github.gpego1.primegarage.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
