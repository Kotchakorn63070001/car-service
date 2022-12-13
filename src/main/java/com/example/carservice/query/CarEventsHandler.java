package com.example.carservice.query;

import com.example.carservice.core.Car;
import com.example.carservice.core.data.CarRepository;
import com.example.carservice.core.event.CarCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

// wait when new car create
@Component
public class CarEventsHandler {
    private final CarRepository carRepository;

    public CarEventsHandler(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventHandler
    public void on(CarCreatedEvent event){
        Car car = new Car();
        BeanUtils.copyProperties(event, car); //copy from event to paste in CarEntity
        carRepository.save(car);
    }
}
