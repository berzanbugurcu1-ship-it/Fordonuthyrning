package Biluthyrning;

import java.util.ArrayList;
import java.util.List;

// Register som håller reda på alla medlemmar i systemet
public class MemberRegistry {

    private List<Member> members = new ArrayList<>();
    // Lista som lagrar alla medlem-objekt

    // Lägger till en medlem i registret
    public void addMember(Member member) {
        if (member != null) {
            members.add(member);
        }
    }

    // Returnerar hela medlemslistan
    public List<Member> getAllMembers() {
        return members;
    }

    // Söker efter en medlem baserat på exakt namn
    public Member findByName(String name) {
        if (name == null) return null;

        String trimmed = name.trim(); // Tar bort onödiga mellanslag

        for (Member m : members) {
            // Jämför exakt namn med equals
            if (m.getName().equals(trimmed)) {
                return m; // Hittad
            }
        }
        return null; // Ingen medlem matchade
    }

    // Skriver ut alla medlemmar i konsolen
    public void printMembers() {
        if (members.isEmpty()) {
            System.out.println("Inga medlemmar registrerade.");
            return;
        }

        System.out.println("Medlemmar:");
        for (Member m : members) {
            System.out.println("- " + m);
        }
    }
}
