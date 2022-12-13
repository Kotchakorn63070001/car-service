package com.example.carservice.core.event;

import lombok.Data;

@Data
public class CarCreatedEvent {
    private String carId;
    private String type;
    private String brand;
    private String model;
    private int numOfSeat;
    private int price;
    private int quantity;
}
