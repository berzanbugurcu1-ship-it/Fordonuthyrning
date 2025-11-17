package Fordonuthyrning;

// Klass som representerar en medlem i systemet
public class Member {

    private String name;
    private String membershipLevel;

    // Konstruktor: skapar en ny medlem med namn + medlemsnivå
    public Member(String name, String membershipLevel) {
        this.name = name;   // parametern också heter name, nnars vet Java inte vilken menar
        this.membershipLevel = membershipLevel;
    }

    public String getName() {
        return name;
    }

    public String getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    @Override
    public String toString() {
        return name + " (" + membershipLevel + ")";
    }
}