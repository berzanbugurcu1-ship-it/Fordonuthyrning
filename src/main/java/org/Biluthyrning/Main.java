package org.Biluthyrning;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Skapar objekt
        Inventory inventory = new Inventory();
        MemberRegistry memberRegistry = new MemberRegistry();
        RentalService rentalService = new RentalService();
        MembershipService membershipService = new MembershipService();

        // Lägger till testmedlemmar
        memberRegistry.addMember(new Member("Anna Andersson", "Standard"));
        memberRegistry.addMember(new Member("Bo Bengtsson", "Student"));

        boolean running = true;

        while (running) {
            // Meny
            System.out.println("\n=== BILUTHYRNING ===");
            System.out.println("1. Visa bilar");
            System.out.println("2. Visa medlemmar");
            System.out.println("3. Lägg till medlem");
            System.out.println("4. Hyr bil");
            System.out.println("5. Visa uthyrningar");
            System.out.println("0. Avsluta");
            System.out.print("Välj: ");

            String val = input.nextLine();

            if (val.equals("1")) {
                // Visa bilar
                System.out.println();
                int nr = 1;
                for (Vehicle bil : inventory.getVehicles()) {
                    System.out.println(nr + ". " + bil);
                    nr++;
                }

            } else if (val.equals("2")) {
                // Visa medlemmar
                System.out.println();
                memberRegistry.printMembers();

            } else if (val.equals("3")) {
                // Lägg till medlem
                System.out.print("\nNamn: ");
                String namn = input.nextLine();

                System.out.print("Medlemskap (Standard/Student): ");
                String typ = input.nextLine();

                Member nyMedlem = new Member(namn, typ);
                memberRegistry.addMember(nyMedlem);
                System.out.println("Medlem tillagd!");

            } else if (val.equals("4")) {
                // Hyr bil
                System.out.println("\n--- Välj medlem ---");
                int nr = 1;
                for (Member m : memberRegistry.getAllMembers()) {
                    System.out.println(nr + ". " + m);
                    nr++;
                }
                System.out.print("Nummer: ");
                int medlemNr = Integer.parseInt(input.nextLine());
                Member medlem = memberRegistry.getAllMembers().get(medlemNr - 1);

                System.out.println("\n--- Välj bil ---");
                nr = 1;
                for (Vehicle bil : inventory.getVehicles()) {
                    System.out.println(nr + ". " + bil);
                    nr++;
                }
                System.out.print("Nummer: ");
                int bilNr = Integer.parseInt(input.nextLine());
                Vehicle bil = inventory.getVehicles().get(bilNr - 1);

                System.out.print("Antal dagar: ");
                int dagar = Integer.parseInt(input.nextLine());

                rentalService.rentVehicle(medlem, bil, dagar);

            } else if (val.equals("5")) {
                // Visa uthyrningar
                System.out.println("\n--- Uthyrningar ---");
                if (rentalService.getRentals().isEmpty()) {
                    System.out.println("Inga uthyrningar än");
                } else {
                    for (Rental r : rentalService.getRentals()) {
                        System.out.println(r);
                    }
                    System.out.println("\nTotal inkomst: " + rentalService.getTotalIncome() + " kr");
                }

            } else if (val.equals("0")) {
                System.out.println("Hej då!");
                running = false;
            }
        }

        input.close();
    }
}