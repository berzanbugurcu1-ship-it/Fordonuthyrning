package Fordonuthyrning;

import java.util.ArrayList;
import java.util.List;

// Register som håller reda på alla medlemmar i systemet
public class MemberRegistry {

    private List<Member> members = new ArrayList<>();

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

    // Skriver ut alla medlemmar i konsolen
    public void printMembers() {
        if (members.isEmpty()) {
            System.out.println("Inga medlemmar registrerade.");
            return;
        }

        System.out.println("Medlemmar:");
        for (Member member : members) {
            System.out.println("- " + member);
        }
    }
}