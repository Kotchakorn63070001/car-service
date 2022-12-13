    package com.example.carservice.command.rest;

    import com.example.carservice.core.Car;
    import com.example.carservice.core.data.CarService;
    import org.axonframework.commandhandling.gateway.CommandGateway;
    import org.springframework.amqp.rabbit.core.RabbitTemplate;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping("/cars")
    public class CarPublisher {

        @Autowired
        private RabbitTemplate rabbitTemplate;
        private final CommandGateway commandGateway;
        @Autowired
        public CarPublisher(CommandGateway commandGateway) {
            this.commandGateway = commandGateway;
        }

        @Autowired
        public CarService carService;

        @GetMapping("/getAllCars")
        public ResponseEntity<?> getAllCars(){
            List<Car> cars = (List<Car>) rabbitTemplate.convertSendAndReceive("CarDirectExchange", "getAllCars", "get all");
            return ResponseEntity.ok(cars);
        }

        @PostMapping("/addCar")
        public ResponseEntity<?> addCar(@RequestBody Car car){
            boolean status = (boolean) rabbitTemplate.convertSendAndReceive("CarDirectExchange", "addCar", car);
            return ResponseEntity.ok(status);
        }

        @GetMapping("/getCarByType/{type}")
        public List<Car> getCarByType(@PathVariable("type") String type){
            List<Car> cars = (List<Car>) rabbitTemplate.convertSendAndReceive("CarDirectExchange", "getCarByType", type);
            return cars;
        }

        @GetMapping("/getCarByBrand/{brand}")
        public List<Car> getCarByBrand(@PathVariable("brand") String brand){
            List<Car> cars = (List<Car>) rabbitTemplate.convertSendAndReceive("CarDirectExchange", "getCarByBrand", brand);
            return cars;
        }


//        @DeleteMapping("/delCar")
//        public ResponseEntity<?> deleteCar(@RequestBody Car car){
//            boolean status = (boolean) rabbitTemplate.convertSendAndReceive("CarDirectExchange", "delCar", car);
//            return ResponseEntity.ok(status);
//        }
    }
