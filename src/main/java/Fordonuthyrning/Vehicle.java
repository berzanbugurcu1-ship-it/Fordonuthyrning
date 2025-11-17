package Fordonuthyrning;

// En fordonstyp som kan hyras, ärver egenskaper från Item
public class Vehicle extends Item {

    private String brand;   // bilmärke (t.ex. Volvo)
    private String model;   // modell (t.ex. V90)

    // Konstruktor: tar emot namn, märke, modell och pris per dag
    public Vehicle(String name, String brand, String model, double dailyPrice) {
        super(name, dailyPrice);   // anropar Item-konstruktorn
        this.brand = brand;        // sätter bilmärket
        this.model = model;        // sätter modellen
    }

    // Returnerar en textrepresentation av fordonet
    public String toString() {
        return getName() + ", " + getDailyPrice() + ", " + brand + ", " + model;
        // format: namn, pris, märke, modell
    }
}
