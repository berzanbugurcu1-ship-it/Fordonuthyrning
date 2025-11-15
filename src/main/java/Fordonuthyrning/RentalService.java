package Fordonuthyrning;

import java.util.ArrayList;
import java.util.List;

// Ansvarar för uthyrningar och för att räkna ihop total inkomst
public class RentalService {

    // Lista över alla uthyrningar som har gjorts
    private List<Rental> rentals = new ArrayList<>();

    // Sammanlagd inkomst från alla uthyrningar
    private double totalIncome = 0;

    // Väljer vilken prispolicy som ska användas för en medlem
    // Student → studentpris, annars standardpris
    private PricePolicy choosePolicy(Member member) {
        if (member.getMembershipLevel().equals("Student")) {
            return new StudentPricing();
        }
        return new StandardPricing();
    }

    // Hyr ut ett fordon till en medlem under ett visst antal dagar
    public void rentVehicle(Member member, Item car, int days) {

        // Hämtar prissättningen beroende på medlemsnivån
        PricePolicy policy = choosePolicy(member);

        // Skapar själva uthyrningen med all information samlad
        Rental rental = new Rental(member, car, days, policy);

        // Sparar uthyrningen i listan
        rentals.add(rental);

        // Lägger till priset i den totala inkomsten
        totalIncome += rental.getTotalPrice();

        // Visar bekräftelse för användaren
        System.out.println("Uthyrning klar:");
        System.out.println(rental);
    }

    // Returnerar hur mycket pengar man har tjänat totalt
    public double getTotalIncome() {
        return totalIncome;
    }

    // Returnerar alla uthyrningar
    public List<Rental> getRentals() {
        return rentals;
    }
}