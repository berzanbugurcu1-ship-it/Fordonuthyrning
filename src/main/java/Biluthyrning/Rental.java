package Biluthyrning;

// En uthyrning: kopplar ihop medlem, fordon, dagar och pris
public class Rental {

    private Member member;     // Vem hyr
    private Vehicle vehicle;   // Vad som hyrs
    private int days;          // Hur många dagar
    private double totalPrice; // Slutpris

    public Rental(Member member, Vehicle vehicle, int days, PricePolicy policy) {
        this.member = member;
        this.vehicle = vehicle;
        this.days = days;

        // Polymorfism: använder valt prissystem
        this.totalPrice = policy.calculatePrice(vehicle.getDailyPrice(), days);
    }

    public Member getMember() { return member; }
    public Vehicle getVehicle() { return vehicle; }
    public int getDays() { return days; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return member.getName() +
                " hyr " + vehicle.getName() +
                " (" + vehicle.getBrand() + " " + vehicle.getModel() + ")" +
                " i " + days + " dagar, pris " + totalPrice + " kr";
    }
}
