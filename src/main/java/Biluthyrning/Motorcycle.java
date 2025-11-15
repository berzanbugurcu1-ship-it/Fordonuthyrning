package Biluthyrning;

// En motorcykel som kan hyras, ärver egenskaper från Item
public class Motorcycle extends Item {

    private String brand;   // motorcykelmärke (t.ex. Yamaha)
    private String model;   // modell (t.ex. MT-07)

    // Konstruktor: tar emot namn, märke, modell och pris per dag
    public Motorcycle(String name, String brand, String model, double dailyPrice) {
        super(name, dailyPrice);   // anropar Item-konstruktorn
        this.brand = brand;        // sätter motorcykelmärket
        this.model = model;        // sätter modellen
    }

    public String getBrand() {
        return brand;   // returnerar motorcykelmärket
    }

    public String getModel() {
        return model;   // returnerar modellen
    }

    // Returnerar en textrepresentation av motorcykeln
    public String toString() {
        return getName() + ", " + getDailyPrice() + ", " + getBrand() + ", " + getModel();
        // format: namn, pris, märke, modell
    }