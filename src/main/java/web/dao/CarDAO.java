package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private static int CARS_COUNT;
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car(++CARS_COUNT, "BMW", 2008));
        cars.add(new Car(++CARS_COUNT, "Porsche", 2007));
        cars.add(new Car(++CARS_COUNT, "Maserati", 2014));
        cars.add(new Car(++CARS_COUNT, "Mercedes", 2015));
        cars.add(new Car(++CARS_COUNT, "Lada", 1997));
    }

    public List<Car> index() {
        return cars;
    }

    public List<Car> show(Integer count) {
        if (count == null) {
            return cars;
        }
        if (count >= 0 && count < 5) {
            return cars.stream().limit(count).toList();
        }
        else {
            return cars.stream().toList();
        }
    }

}
