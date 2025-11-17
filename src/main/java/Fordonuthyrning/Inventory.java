package Fordonuthyrning;

import java.util.ArrayList;

// Håller reda på alla bilar som finns att hyra
public class Inventory {

    private ArrayList<Item> vehicles = new ArrayList<>();

    public Inventory() {
        visaFordon(); // lägger in bilar vid start
    }

    // Lägger in standardbilar i lagret
    private void visaFordon() {
        vehicles.add(new Vehicle("Audi A3", "Audi", "A3", 600));
        vehicles.add(new Vehicle("Audi Q3", "Audi", "Q3", 750));
        vehicles.add(new Vehicle("Audi A4", "Audi", "A4", 700));
        vehicles.add(new Vehicle("Audi Q5", "Audi", "Q5", 850));
        vehicles.add(new Motorcycle("Yamaha MT-07", "Yamaha", "MT-07", 400));
        vehicles.add(new Motorcycle("Honda CBR", "Honda", "CBR600RR", 450));
    }

    public ArrayList<Item> getVehicles() {
        return vehicles; // returnerar listan med alla bilar
    }
}