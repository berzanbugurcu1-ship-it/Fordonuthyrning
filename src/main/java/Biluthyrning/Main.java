package Biluthyrning;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner för att läsa input från användaren
        Scanner input = new Scanner(System.in);

        // Skapar alla objekt som behövs
        Inventory inventory = new Inventory();
        MemberRegistry memberRegistry = new MemberRegistry();
        RentalService rentalService = new RentalService();

        // Håller programmet igång tills användaren väljer att avsluta
        boolean running = true;

        // Huvudloop - visar menyn om och om igen
        while (running) {
            // Skriver ut menyn
            System.out.println("FORDONSUTHYRNING");
            System.out.println("1. Visa bilar");
            System.out.println("2. Visa medlemmar");
            System.out.println("3. Lägg till medlem");
            System.out.println("4. Hyr bil/motorcykel");
            System.out.println("5. Visa uthyrningar");
            System.out.println("0. Avsluta");
            System.out.print("Välj: ");

            // Läser in användarens val
            int val = input.nextInt();
            input.nextLine(); // Tar bort enter-tryckningen

            // Kollar vad användaren valde
            switch (val) {
                case 1:
                    // Visa alla bilar som finns
                    int nr = 1; // Räknare för numrering
                    for (Vehicle bil : inventory.getVehicles()) {
                        System.out.println(nr + ". " + bil);
                        nr = nr + 1; // Ökar med 1 för varje bil
                    }
                    break;

                case 2:
                    // Visa alla medlemmar
                    memberRegistry.printMembers();
                    break;

                case 3:
                    // Lägg till ny medlem
                    System.out.print("Namn: ");
                    String namn = input.nextLine(); // Läser in namnet

                    System.out.print("Medlemskap (Standard/Student): ");
                    String typ = input.nextLine(); // Läser in typen

                    // Skapar ny medlem med namn och typ
                    Member nyMedlem = new Member(namn, typ);
                    memberRegistry.addMember(nyMedlem); // Lägger till i registret
                    System.out.println("Medlem tillagd!");
                    break;

                case 4:
                    // Hyr en bil
                    System.out.println("Välj medlem:");

                    // Visar alla medlemmar med nummer
                    int nummer = 1;
                    for (Member m : memberRegistry.getAllMembers()) {
                        System.out.println(nummer + ". " + m);
                        nummer = nummer + 1;
                    }

                    // Användaren väljer medlem
                    System.out.print("Nummer: ");
                    int medlemNr = input.nextInt();
                    input.nextLine(); // Tar bort enter-tryckningen
                    // Hämtar den valda medlemmen (minus 1 för att listor börjar på 0)
                    Member medlem = memberRegistry.getAllMembers().get(medlemNr - 1);

                    System.out.println("Välj bil:");

                    // Visar alla bilar med nummer
                    nummer = 1;
                    for (Vehicle bil : inventory.getVehicles()) {
                        System.out.println(nummer + ". " + bil);
                        nummer = nummer + 1;
                    }

                    // Användaren väljer bil
                    System.out.print("Nummer: ");
                    int bilNr = Integer.parseInt(input.nextLine());
                    // Hämtar den valda bilen
                    Vehicle bil = inventory.getVehicles().get(bilNr - 1);

                    // Frågar hur många dagar
                    System.out.print("Antal dagar: ");
                    int dagar = Integer.parseInt(input.nextLine());

                    // Skapar uthyrningen
                    rentalService.rentVehicle(medlem, bil, dagar);
                    break;

                case 5:
                    // Visa alla uthyrningar som har gjorts
                    System.out.println("Uthyrningar:");

                    // Kollar om det finns några uthyrningar
                    if (rentalService.getRentals().isEmpty()) {
                        System.out.println("Inga uthyrningar än");
                    } else {
                        // Skriver ut varje uthyrning
                        for (Rental r : rentalService.getRentals()) {
                            System.out.println(r);
                        }
                        // Visar totala inkomsten
                        System.out.println("Total inkomst: " + rentalService.getTotalIncome() + " kr");
                    }
                    break;

                case 0:
                    // Avslutar programmet
                    System.out.println("Hej då!");
                    running = false; // Gör att while-loopen slutar
                    break;
            }
        }

        // Stänger scannern när programmet är klart
        input.close();
    }
}