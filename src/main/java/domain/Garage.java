package domain;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private List<Car> cars = new ArrayList<>();
    private int tryTimes;


    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryTimes() {
        return tryTimes;
    }

    public void setTryTimes(int tryTimes) {
        this.tryTimes = tryTimes;
    }
}
