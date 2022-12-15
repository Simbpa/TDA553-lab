package src.carModel;

import java.util.ArrayList;

public class LoadsCar {
    /*
     * List with loaded cars
     * load method
     * unload method
     * 
     * method for checking distance to car to load
     */
    private ArrayList<Car> loadedCarsList;
    private double maxLoadDistance;
    private int maximalLoadedCars;

    public LoadsCar(int maximalLoadedCars, double maxLoadDistance) {
        this.maximalLoadedCars = maximalLoadedCars;
        this.maxLoadDistance = maxLoadDistance;
        this.loadedCarsList = new ArrayList<Car>();
    }

    public void loadCar(Position position, Car car) {
        if (loadingSpotsLeft() && carInRange(position, car)) {
            loadedCarsList.add(car);
            car.setIsLoaded(true);
        } else {
            throw new IllegalArgumentException("Car outside of range");
        }
    }

    public void unloadCar(Car car) {
            loadedCarsList.remove(car);
            car.setIsLoaded(false);
    }

    public boolean isCarInLoad(Car car) {
        return loadedCarsList.contains(car);
    }

    public boolean carInRange(Position position, Car other) {
        return maxLoadDistance > Math.sqrt(Math.pow(position.getXPosition() - other.getXPosition(), 2)
                + Math.pow(position.getYPosition() - other.getXPosition(), 2));
    }

    private boolean loadingSpotsLeft() {
        return loadedCarsList.size() < maximalLoadedCars;
    }
}
