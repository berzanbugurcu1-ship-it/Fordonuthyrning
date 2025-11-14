package Biluthyrning;

// Hanterar ändring av medlemsnivå
public class MembershipService {

    // Gör medlemmen till Standard
    public void setStandard(Member member) {
        member.setMembershipLevel("Standard");
        System.out.println(member.getName() + " är nu Standard-medlem.");
    }

    // Gör medlemmen till Student
    public void setStudent(Member member) {
        member.setMembershipLevel("Student");
        System.out.println(member.getName() + " är nu Student-medlem.");
    }
}
