package java.lab.java.lab;

import java.util.ArrayList;
import java.util.Scanner;cd

public class lab4 {
    static int accountNumber;
    static String accountHolderName;
    static double accountBalance;
    static ArrayList<String> transactions = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeAccount(scanner);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Print Transactions");
            System.out.println("4. Print Account Summary");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    depositMoney(scanner);
                    break;
                case 2:
                    withdrawMoney(scanner);
                    break;
                case 3:
                    printTransactions();
                    break;
                case 4:
                    printAccountSummary();
                    break;
                case 5:
                    System.out.println("Thank you for using our service!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void initializeAccount(Scanner scanner) {
        System.out.println("Enter account number: ");
        accountNumber = scanner.nextInt();

        System.out.println("Enter account holder name: ");
        accountHolderName = scanner.next();

        System.out.println("Enter account balance: ");
        accountBalance = scanner.nextDouble();

        transactions.add(String.format("Account initialized with balance: %.2f", accountBalance));
    }

    public static void depositMoney(Scanner scanner) {
        System.out.println("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        accountBalance += amount;

        transactions.add(String.format("Deposit: %.2f", amount));
        transactions.add(String.format("New balance: %.2f", accountBalance));
    }

    public static void withdrawMoney(Scanner scanner) {
        System.out.println("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > accountBalance) {
            System.out.println("Insufficient balance!");
            return;
        }

        accountBalance -= amount;

        transactions.add(String.format("Withdrawal: %.2f", amount));
        transactions.add(String.format("New balance: %.2f", accountBalance));
    }

    public static void printTransactions() {
        System.out.println("Transactions:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void printAccountSummary() {
        System.out.println("Account Summary:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
        System.out.println("Account Balance: " + accountBalance);
    }
}
