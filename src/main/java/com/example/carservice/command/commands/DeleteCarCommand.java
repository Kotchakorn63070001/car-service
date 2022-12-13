package com.example.carservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class DeleteCarCommand {
    @TargetAggregateIdentifier
    private final String carId;
    private final String type;
    private final String brand;
    private final String model;
    private final int numOfSeat;
    private final int price;
    private final int quantity;
}
