package io.github.gpego1.primegarage.domain.service;
import io.github.gpego1.primegarage.domain.dto.CarDTO;
import io.github.gpego1.primegarage.domain.entity.Car;
import io.github.gpego1.primegarage.domain.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car createCar(CarDTO dto) {
        Car createdCar = new Car(dto.model(), dto.make(), dto.price(), dto.fuel_type());
        return carRepository.save(createdCar);
    }
}
