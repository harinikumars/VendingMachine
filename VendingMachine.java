package assignments.vendingmachine;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        //printing out the vending machine display to the user
        System.out.println("Hi! Please provide an input for me to dispense :)");
        System.out.println("ID\t\t Name\t\t\t\t Price\t\n" +
                "1.\t\t Jasmine Tea\t\t 10\t\n" +
                "2.\t\t Chamomile Tea\t\t 12\t\n" +
                "3.\t\t Hibiscus Tea\t\t 14\t\n" +
                "4.\t\t Green Tea\t\t\t 8\t\n");
        //take the input from the user regarding the item to be dispensed
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the item you want : ");
        int itemID = scanner.nextInt();
        //checking the input item ID if it is valid or not
        if (itemID < 1 || itemID > 4) {
            System.out.println("Please enter a valid Item ID.");
        }else {
            System.out.println("Proceed with payment!");
        }
        //If the input of item id is valid, take the payment from the user.
        double amountFromUser = scanner.nextDouble();
        //initialising the amount available in the vending machine.
        double amountInVendingMachine = 0;

        //verify the payment sufficiency and dispense the item 1
        if (itemID == 1) {
            if (amountFromUser > 10) {
                amountInVendingMachine += 10;
                double balanceAmount = 10 - amountFromUser;
                System.out.println("Your balance amount is : " + Math.abs(balanceAmount));
                System.out.println("Dispensing Jasmine Tea.");
            } else {
                System.out.println("Sorry! payment insufficient!");
            }
        }

        //verify the payment sufficiency and dispense the item 2
        if (itemID == 2) {
            if (amountFromUser > 12) {
                amountInVendingMachine += 12;
                double balanceAmount = 12 - amountFromUser;
                System.out.println("Your balance amount is : " + Math.abs(balanceAmount));
                System.out.println("Dispensing Chamomile Tea.");
            } else {
                System.out.println("Sorry! payment insufficient!");
            }
        }

        //verify the payment sufficiency and dispense the item 3
        if (itemID == 3) {
            if (amountFromUser > 14) {
                amountInVendingMachine += 14;
                double balanceAmount = 14 - amountFromUser;
                System.out.println("Your balance amount is : " + Math.abs(balanceAmount));
                System.out.println("Dispensing Hibiscus Tea.");
            } else {
                System.out.println("Sorry! payment insufficient!");
            }
        }

        //verify the payment sufficiency and dispense the item 4
        if (itemID == 4) {
            if (amountFromUser > 8) {
                amountInVendingMachine += 8;
                double balanceAmount = 8 - amountFromUser;
                System.out.println("Your balance amount is : " + Math.abs(balanceAmount));
                System.out.println("Dispensing Green Tea.");
            } else {
                System.out.println("Sorry! Payment insufficient!");
            }
        }
        //print the balance amount in the vending machine
        System.out.println("The balance amount in vending machine is :" + amountInVendingMachine);
    }
}
