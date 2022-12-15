package src.carModel;

import java.awt.Color;

public class CarTransporter extends Truck {
    private DiscretePlatform platform;
    private LoadsCar carLoader;
    private final int maximalLoadedCars = 10;
    private final double maxLoadDistance = 50;

    public CarTransporter(int positionX, int positionY) {
        super(2, 100, Color.gray, "Car Transporter", positionX, positionY);
        this.platform = new DiscretePlatform();
        this.carLoader = new LoadsCar(maximalLoadedCars, maxLoadDistance);

    }

    public void raisePlatform() {
        platform.raisePlatform(getCurrentSpeed());
    }

    public void lowerPlatform() {
        platform.lowerPlatform(getCurrentSpeed());
    }

    @Override
    public boolean canGas() {
        return platform.canGas();
    }

    public boolean isPlatformUp() {
        return platform.isPlatformUp();
    }

    public void loadCar(Car car) {
        if (canLoadCar()){
            carLoader.loadCar(this.getPosition(), car);
        }
    }

    public void unloadCar(Car car) {
        if (canLoadCar()){
            carLoader.unloadCar(car);
        }
    }

    public boolean isCarInLoad(Car car) {
        return carLoader.isCarInLoad(car);
    }

    public boolean carInRange(Car other) {
        return carLoader.carInRange(this.getPosition(), other);
    }

    public boolean canLoadCar(){
        return !isPlatformUp();
    }
}
