package Biluthyrning;

import java.util.ArrayList;
import java.util.List;

// Klass som representerar en medlem i systemet
public class Member {

    private String name;               // Medlemmens namn
    private String membershipLevel;    // Typ av medlemskap
    private List<String> history;      // Händelselista kopplad till medlemmen

    // Konstruktor: skapar en ny medlem med namn + medlemsnivå
    public Member(String name, String membershipLevel) {
        this.name = name;
        this.membershipLevel = membershipLevel;
        this.history = new ArrayList<>(); // Skapar tom historik
    }

    public String getName() {
        return name; // Returnerar namnet
    }

    public void setName(String name) {
        this.name = name; // Uppdaterar namnet
    }

    public String getMembershipLevel() {
        return membershipLevel; // Returnerar medlemsnivån
    }

    public void setMembershipLevel(String membershipLevel) {
        this.membershipLevel = membershipLevel; // Uppdaterar nivån
    }

    public List<String> getHistory() {
        return history; // Returnerar historiken
    }

    public void setHistory(List<String> history) {
        this.history = history; // Ersätter historiken
    }

    @Override
    public String toString() {
        // Returnerar medlemmen som text
        return name + " (" + membershipLevel + ")";
    }
}
