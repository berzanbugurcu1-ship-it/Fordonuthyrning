package org.Biluthyrning;

public interface PricePolicy {
    double calculatePrice(double dailyPrice, int days);
}
