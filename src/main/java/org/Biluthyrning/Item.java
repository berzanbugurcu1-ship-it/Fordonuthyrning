package org.Biluthyrning;
// package-deklaration: talar om vilket paket klassen ligger i

public abstract class Item {
    // abstract class: kan inte skapas direkt, ska ärvas av andra klasser

    private String name;
    // instansvariabel (field): lagrar objektets namn

    private double dailyPrice;
    // instansvariabel (field): lagrar pris per dag

    public Item(String name, double dailyPrice) {
        // constructor: körs när ett objekt skapas, sätter startvärden
        this.name = name;
        // this.name: tilldelar värde till klassens field
        this.dailyPrice = dailyPrice;
        // this.dailyPrice: tilldelar värde till prisfältet
    }

    public String getName() {
        // getter-metod: returnerar name
        return name;
    }

    public double getDailyPrice() {
        // getter-metod: returnerar dailyPrice
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        // setter-metod: uppdaterar dailyPrice
        this.dailyPrice = dailyPrice;
    }
}
