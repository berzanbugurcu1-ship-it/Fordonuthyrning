package Fordonuthyrning;

// En uthyrning: kopplar ihop medlem, fordon, dagar och pris
public class Rental {

    private Member member;
    private Item vehicle;
    private int days;
    private double totalPrice;

    public Rental(Member member, Item vehicle, int days, PricePolicy policy) {
        this.member = member;
        this.vehicle = vehicle;
        this.days = days;

        // Polymorfism: använder valt prissystem
        this.totalPrice = policy.calculatePrice(vehicle.getDailyPrice(), days);
    }

    public Member getMember() { return member; }
    public Item getVehicle() { return vehicle; }
    public int getDays() { return days; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return member.getName() +
                " hyr " + vehicle.getName() +
                " i " + days + " dagar, pris " + totalPrice + " kr";
    }
}