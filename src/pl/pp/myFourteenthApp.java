interface FuelType { String getFuelType(); }

class Diesel implements FuelType { @Override public String getFuelType() { return "Diesel"; } }

class Gasoline implements FuelType { @Override public String getFuelType() { return "Gasoline"; } }

class Electric implements FuelType { @Override public String getFuelType() { return "Electric"; } }

abstract class Vehicle {
    protected String registrationNumber;
    protected String vinNumber;
    protected String color;
    protected double price;
    protected double fuelConsumption;
    protected double fuelLevel;
    protected double mileage;
    protected FuelType engine;

    public Vehicle(String registrationNumber, String vinNumber, String color, double price,
                   double fuelConsumption, double fuelLevel, double mileage, FuelType engine) {
        this.registrationNumber = registrationNumber;
        this.vinNumber = vinNumber;
        this.color = color;
        this.price = price;
        this.fuelConsumption = fuelConsumption;
        this.fuelLevel = fuelLevel;
        this.mileage = mileage;
        this.engine = engine;
    }

    public void drive(double distanceKm) {
        double fuelNeeded = (distanceKm / 100.0) * fuelConsumption;
        if (fuelNeeded > fuelLevel) {
            System.out.printf("%s – not enough %s to drive %.1f km (need %.1f, have %.1f).%n",
                    getClass().getSimpleName(), engine.getFuelType(), distanceKm, fuelNeeded, fuelLevel);
            return;
        }
        fuelLevel -= fuelNeeded;
        mileage += distanceKm;
        System.out.printf("%s drove %.1f km. Remaining %s: %.1f. New mileage: %.1f km.%n",
                getClass().getSimpleName(), distanceKm, engine.getFuelType(), fuelLevel, mileage);
    }

    public void refuel(double amount) {
        fuelLevel += amount;
        System.out.printf("%s refueled %.1f units of %s. Current level: %.1f.%n",
                getClass().getSimpleName(), amount, engine.getFuelType(), fuelLevel);
    }

    @Override
    public String toString() {
        return String.format("%s [%s] – %s, %.1f km mileage, %.1f units of %s left",
                getClass().getSimpleName(), registrationNumber, color, mileage, fuelLevel, engine.getFuelType());
    }
}

class PassengerCar extends Vehicle {
    private int numberOfDoors;

    public PassengerCar(String registrationNumber, String vinNumber, String color, double price,
                        double fuelConsumption, double fuelLevel, double mileage, FuelType engine,
                        int numberOfDoors) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage, engine);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", doors: %d", numberOfDoors);
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String registrationNumber, String vinNumber, String color, double price,
                 double fuelConsumption, double fuelLevel, double mileage, FuelType engine,
                 double loadCapacity) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage, engine);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", load capacity: %.0f kg", loadCapacity);
    }
}

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String registrationNumber, String vinNumber, String color, double price,
                      double fuelConsumption, double fuelLevel, double mileage, FuelType engine,
                      boolean hasSidecar) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage, engine);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", sidecar: %s", hasSidecar ? "yes" : "no");
    }
}

class ConstructionEquipment extends Vehicle {
    private double hoursWorked;

    public ConstructionEquipment(String registrationNumber, String vinNumber, String color, double price,
                                 double fuelConsumption, double fuelLevel, double mileage, FuelType engine,
                                 double hoursWorked) {
        super(registrationNumber, vinNumber, color, price, fuelConsumption, fuelLevel, mileage, engine);
        this.hoursWorked = hoursWorked;
    }

    public void work(double hours) {
        hoursWorked += hours;
        double fuelNeeded = hours * (fuelConsumption / 10);
        if (fuelNeeded > fuelLevel) {
            System.out.printf("%s – not enough %s to work %.1f h.%n",
                    getClass().getSimpleName(), engine.getFuelType(), hours);
            return;
        }
        fuelLevel -= fuelNeeded;
        System.out.printf("%s worked %.1f h. Total hours: %.1f. Fuel left: %.1f.%n",
                getClass().getSimpleName(), hours, hoursWorked, fuelLevel);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", hours worked: %.1f", hoursWorked);
    }
}

public class myFourteenthApp {
    public static void main(String[] args) {
        FuelType diesel = new Diesel();
        FuelType gasoline = new Gasoline();
        FuelType electric = new Electric();

        PassengerCar car = new PassengerCar(
                "WA 12345", "VINCAR123456", "Blue", 35000,
                7.0, 50.0, 5000, gasoline, 5);

        Truck truck = new Truck(
                "WB 54321", "VINTRK654321", "White", 80000,
                25.0, 200.0, 20000, diesel, 12000);

        Motorcycle bike = new Motorcycle(
                "WM 11111", "VINMOTO11111", "Black", 15000,
                4.0, 15.0, 3000, gasoline, false);

        ConstructionEquipment excavator = new ConstructionEquipment(
                "WC 99999", "VINCONS99999", "Yellow", 120000,
                15.0, 300.0, 1000, diesel, 0);

        System.out.println("--- Fleet overview ---");
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bike);
        System.out.println(excavator);

        System.out.println("\n--- Simulating operations ---");
        car.drive(100);
        car.refuel(20);

        truck.drive(50);

        bike.drive(200);
        bike.refuel(5);

        excavator.work(8);
        excavator.drive(10);

        System.out.println("\n--- Final state ---");
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bike);
        System.out.println(excavator);
    }
}
