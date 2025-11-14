package Biluthyrning;

import java.util.ArrayList;
import java.util.List;

// Håller reda på alla bilar som finns att hyra
public class Inventory {

    private List<Vehicle> vehicles = new ArrayList<>();

    public Inventory() {
        initCars(); // lägger in bilar vid start
    }

    // Lägger in standardbilar i lagret
    private void initCars() {
        vehicles.add(new Vehicle("Audi A3", "Audi", "A3", 600));
        vehicles.add(new Vehicle("Audi Q3", "Audi", "Q3", 750));
        vehicles.add(new Vehicle("Audi A4", "Audi", "A4", 700));
        vehicles.add(new Vehicle("Audi Q5", "Audi", "Q5", 850));
    }

    public List<Vehicle> getVehicles() {
        return vehicles; // returnerar listan med alla bilar
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle); // lägger till en ny bil
    }

    // Metod för att visa alla bilar (den här metoden saknades!)
    public void printVehicles() {
        System.out.println("Bilar i lagret:");
        int count = 1; // startar numreringen från 1
        for (Vehicle car : vehicles) { // car istället för v
            System.out.println(count + ": " + car);
            count++; // ökar räknaren för varje bil
        }
    }
}