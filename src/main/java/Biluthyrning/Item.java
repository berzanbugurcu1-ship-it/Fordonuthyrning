package Biluthyrning;

public abstract class Item {

    private String name;
    private double dailyPrice;

    public Item(String name, double dailyPrice) {
        this.name = name;
        this.dailyPrice = dailyPrice;
    }

    public String getName() {
        return name;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
}