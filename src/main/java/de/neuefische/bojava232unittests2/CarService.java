package de.neuefische.bojava232unittests2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public void create(Car car) {
        carRepository.save(car);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public void update(Car car) {
        carRepository.save(car);
    }

    public void delete(String id) {
        carRepository.deleteById(id);
    }
}
