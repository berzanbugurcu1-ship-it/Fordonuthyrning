package Fordonuthyrning;

// Studentpris: 20% rabatt
public class StudentPricing implements PricePolicy {

    @Override
    public double calculatePrice(double dailyPrice, int days) {
        return dailyPrice * days * 0.8; // 20% rabatt direkt
    }
}
