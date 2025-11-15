package Biluthyrning;

public class StandardPricing implements PricePolicy {

    @Override
    public double calculatePrice(double dailyPrice, int days) {
        return dailyPrice * days;
    }
}
