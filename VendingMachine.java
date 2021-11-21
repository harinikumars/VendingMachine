package assignments.VendingMachine;

import java.text.SimpleDateFormat;
import java.util.*;

public class VendingMachine {
    static int itemID;
    static Scanner scanner;
    static List<String> transactionDump = new ArrayList<>();
    static String[][] vendingMachineItems;
    static double amountInVendingMachine = 0;
    static double amountFromUser;
    static double balanceAmount;

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        while (true) {
            vendingMachine.printVendingMachineMenu();
            int userInput = vendingMachine.getUserInput();
            vendingMachine.refundBalanceAndDispenseItem(userInput);
        }
    }

    void printVendingMachineMenu() {
        vendingMachineItems = new String[][]{{"1", "Jasmine Tea", "10"}, {"2", "Chamomile Tea", "12"}, {"3", "Hibiscus Tea", "14"}, {"4", "Green Tea", "8"}};
        //printing out the vending machine display to the user
        System.out.println("Hi! Please provide an input for me to dispense :)");
        System.out.println("ID\t\t Name\t\t\t\t Price\t\n" +
                vendingMachineItems[0][0] + "\t\t" + vendingMachineItems[0][1] + "\t\t\t" + vendingMachineItems[0][2] + "\t\n" +
                vendingMachineItems[1][0] + "\t\t" + vendingMachineItems[1][1] + "\t\t" + vendingMachineItems[1][2] + "\t\n" +
                vendingMachineItems[2][0] + "\t\t" + vendingMachineItems[2][1] + "\t\t" + vendingMachineItems[2][2] + "\t\n" +
                vendingMachineItems[3][0] + "\t\t" + vendingMachineItems[3][1] + "\t\t\t" + vendingMachineItems[3][2] + "\t\n" +
                "\nOr enter 5 to view the balance in Vending Machine\t\t\n" +
                "\nOr enter 6 to view the previous transactions in Vending Machine\t\t\n");
    }

    int getUserInput() {
        //take the input from the user regarding the item to be dispensed
        scanner = new Scanner(System.in);
        System.out.println("Enter the ID of the item you want : ");
        itemID = scanner.nextInt();
        return itemID;
    }

    void refundBalanceAndDispenseItem(int userInput) {

        if (userInput == 1 || userInput == 2 || userInput == 3 || userInput == 4) {
            System.out.println("Please proceed with payment!");
            amountFromUser = scanner.nextDouble();
            double priceOfTheItem = Double.parseDouble(vendingMachineItems[(userInput) - 1][2]);
            if (amountFromUser >= priceOfTheItem) {
                amountInVendingMachine += priceOfTheItem;
                balanceAmount = Math.abs(priceOfTheItem - amountFromUser);
                System.out.println("Your balance amount is : " + balanceAmount);
                System.out.println("Dispensing " + vendingMachineItems[userInput - 1][1]);
                recordPreviousTransactions(userInput);
            } else {
                System.out.println("Amount is insufficient! Please try again!");
            }
        } else if (userInput == 5) {
            System.out.println("The balance amount in vending machine is :" + amountInVendingMachine);
        } else if (userInput == 6) {
            viewPreviousTransactions();
        } else {
            System.out.println("Please enter a valid ID.");
        }
    }

    void recordPreviousTransactions(int userInput) {
        String transactionDateAndTime = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String dayWiseTransaction = "\n On " + transactionDateAndTime + " is :\n The itemID dispensed :" + String.valueOf(userInput) + " user paid : " + String.valueOf(amountFromUser) + " balance amount : " + String.valueOf(balanceAmount) + " and the amount in vending machine was : " + String.valueOf(amountInVendingMachine)+ "\n";
        transactionDump.add(dayWiseTransaction);
    }

    void viewPreviousTransactions() {
        if (transactionDump.size() == 0) {
            System.out.println("No transactions yet!");
        } else {
            System.out.println("\n Displaying transaction details below : ");
            for (int i = 0; i < transactionDump.size(); i++) {
                System.out.println(transactionDump.get(i));
            }
        }
    }
}