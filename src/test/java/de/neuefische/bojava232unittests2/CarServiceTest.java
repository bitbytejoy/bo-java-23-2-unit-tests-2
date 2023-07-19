package de.neuefische.bojava232unittests2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

class CarServiceTest {
    @Test
    public void create_whenCreateWithValidCar_thenNoError() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarService carService = new CarService(carRepository);

        carService.create(new Car("1", "VW", "Golf"));

        Mockito.verify(carRepository).save(new Car("1", "VW", "Golf"));
    }

    @Test
    public void getAll_whenGetAll_thenReturnCorrectList() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarService carService = new CarService(carRepository);

        Mockito.when(carRepository.findAll()).thenReturn(List.of(
                new Car("1", "VW", "Golf"),
                new Car("2", "BMW", "3er")
        ));

        Assertions.assertEquals(
                List.of(
                        new Car("1", "VW", "Golf"),
                        new Car("2", "BMW", "3er")
                ),
                carService.getAll()
        );

        Mockito.verify(carRepository).findAll();
    }

    @Test
    public void create_whenUpdateWithValidCar_thenNoError() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarService carService = new CarService(carRepository);

        carService.update(new Car("1", "VW", "Golf"));

        Mockito.verify(carRepository).save(new Car("1", "VW", "Golf"));
    }

    @Test
    public void create_whenDeleteWithValidCarId_thenNoError() {
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        CarService carService = new CarService(carRepository);

        carService.delete("1");

        Mockito.verify(carRepository).deleteById("1");
    }
}