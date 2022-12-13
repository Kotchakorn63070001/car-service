package com.example.carservice.core;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Data
@Document("Car")
public class Car implements Serializable {
    @Serial
    private static final long serialVersionUID = 7786507768766487624L;
    @Id
    @Column(unique = true)
    private String carId;
    private String type;
    private String brand;
    private String model;
    private int numOfSeat;
    private int price;
    private int quantity;
}
