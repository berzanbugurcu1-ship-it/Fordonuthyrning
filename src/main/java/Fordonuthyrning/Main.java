package Fordonuthyrning;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner för att läsa input från användaren
        Scanner input = new Scanner(System.in);

        // Skapar alla objekt som behövs
        Inventory inventory = new Inventory();
        MemberRegistry memberRegistry = new MemberRegistry();
        RentalService rentalService = new RentalService();
        MembershipService membershipService = new MembershipService();

        // Håller programmet igång tills användaren väljer att avsluta
        boolean running = true;

        // Huvudloop - visar menyn om och om igen
        while (running) {
            // Skriver ut menyn
            System.out.println("FORDONSUTHYRNING");
            System.out.println("1. Visa bilar");
            System.out.println("2. Visa medlemmar");
            System.out.println("3. Lägg till medlem");
            System.out.println("4. Ändra medlemskap");
            System.out.println("5. Hyr bil/motorcykel");
            System.out.println("6. Visa uthyrningar");
            System.out.println("0. Avsluta");
            System.out.print("Välj: ");

            // Läser in användarens val
            int val = input.nextInt();
            input.nextLine(); // Tar bort enter-tryckningen

            // Kollar vad användaren valde
            switch (val) {
                case 1:
                    // Visa alla bilar som finns
                    int nummer = 1; // Räknare för numrering
                    for (Item fordon : inventory.getVehicles()) {
                        System.out.println(nummer + ". " + fordon);
                        nummer = nummer + 1; // Ökar med 1 för varje bil
                    }
                    break;

                case 2:
                    // Visa alla medlemmar
                    memberRegistry.printMembers();
                    break;

                case 3:
                    // Lägg till ny medlem
                    System.out.print("Namn: ");
                    String name = input.nextLine(); // Läser in namnet

                    System.out.print("Medlemskap (Standard/Student): ");
                    String membershipLevel = input.nextLine(); // Läser in typen

                    // Skapar ny medlem med namn och typ
                    Member nyMedlem = new Member(name, membershipLevel);
                    memberRegistry.addMember(nyMedlem); // Lägger till i registret
                    System.out.println("Medlem tillagd!");
                    break;

                case 4:
                    // Ändra medlemskap
                    System.out.println("Välj medlem:");

                    int nummer2 = 1;
                    for (Member member : memberRegistry.getAllMembers()) {
                        System.out.println(nummer2 + ". " + member);
                        nummer2 = nummer2 + 1;
                    }

                    System.out.print("Nummer: ");
                    int medlemNummer = input.nextInt();
                    input.nextLine(); // Tar bort enter-tryckningen
                    Member member = memberRegistry.getAllMembers().get(medlemNummer - 1);

                    System.out.println("Nytt medlemskap:");
                    System.out.println("1. Standard");
                    System.out.println("2. Student");
                    System.out.print("Välj: ");
                    int typVal = input.nextInt();
                    input.nextLine(); // Tar bort enter-tryckningen

                    if (typVal == 1) {
                        membershipService.setStandard(member);
                    } else if (typVal == 2) {
                        membershipService.setStudent(member);
                    }
                    break;

                case 5:
                    // Hyr ett fordon
                    System.out.println("Välj medlem:");

                    // Visar alla medlemmar med nummer
                    int nummer3 = 1;
                    for (Member member2 : memberRegistry.getAllMembers()) {
                        System.out.println(nummer3 + ". " + member2);
                        nummer3 = nummer3 + 1;
                    }

                    // Användaren väljer medlem
                    System.out.print("Nummer: ");
                    int medlemNummer2 = input.nextInt();
                    input.nextLine(); // Tar bort enter-tryckningen
                    // Hämtar den valda medlemmen (minus 1 för att listor börjar på 0)
                    Member member2 = memberRegistry.getAllMembers().get(medlemNummer2 - 1);

                    System.out.println("Välj fordon:");

                    // Visar alla fordon med nummer, använder for loop så
                    int nummer4 = 1;
                    for (Item fordon : inventory.getVehicles()) {  // : = innebär inut i invneotry klassen-
                        System.out.println(nummer4 + ". " + fordon);
                        nummer4 = nummer4 + 1;
                    }

                    // Användaren väljer fordon
                    System.out.print("Nummer: ");
                    int fordonNummer = input.nextInt();
                    input.nextLine(); // Tar bort enter-tryckningen
                    // Hämtar det valda fordonet
                    Item vehicle = inventory.getVehicles().get(fordonNummer - 1);

                    // Frågar hur många dagar
                    System.out.print("Antal dagar: ");
                    int days = input.nextInt();
                    input.nextLine(); // Tar bort enter-tryckningen

                    // Skapar uthyrningen
                    rentalService.rentVehicle(member2, vehicle, days);
                    break;

                case 6:
                    // Visa alla uthyrningar som har gjorts
                    System.out.println("Uthyrningar:");

                    // Kollar om det finns några uthyrningar
                    if (rentalService.getRentals().isEmpty()) {
                        System.out.println("Inga uthyrningar än");
                    } else {
                        // Skriver ut varje uthyrning
                        for (Rental rental : rentalService.getRentals()) {
                            System.out.println(rental);
                        }
                        // Visar totala inkomsten
                        System.out.println("Total inkomst: " + rentalService.getTotalIncome() + " kr");
                    }
                    break;

                case 0:
                    // Avslutar programmet
                    System.out.println("tack");
                    running = false; // Gör att while-loopen slutar
                    break;
            }
        }

        // Stänger scannern när programmet är klart
        input.close();
    }
}