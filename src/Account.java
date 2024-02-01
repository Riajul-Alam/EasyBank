package src;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Account {
    private String firstName;
    private String lastName;
    private final int accountNumber;
    private String accountType;
    private final Date creationDate;
    private double balance;
    Account(String firstName,String lastName, int accountNumber, String accountType, double balance) {
        this.firstName = firstName;
        this.lastName=lastName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        creationDate=new Date();
        this.balance = balance;
    }
    public String getAccountName() {
        return firstName+" "+lastName;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public String getAccountType() {
        return accountType;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public double getBalance() {
        return balance;
    }
    public void updateAccount(Scanner input)
    {

        System.out.println("Choose what to update:");
        System.out.println("1. Name");
        System.out.println("2. Balance");
        int updateChoice = input.nextInt();

        switch (updateChoice) {
            case 1:
                System.out.println("Enter new firstName:");
                String firstName = input.nextLine();
                System.out.println("Enter new lastName:");
                String lastName = input.nextLine();
                this.firstName=firstName;
                this.lastName=lastName;
                System.out.println("Name updated successfully.");
                break;
            case 2:
                System.out.print("Enter a valid amount for update balance : ");
                double newBalance=input.nextInt();
                if (newBalance < 2000 && this.accountType.equals("Current")) {
                    System.out.println("Error: Failed !");
                    System.out.println("Minimum balance required for a Current account is " + 2000);
                    return;
                }
                if (newBalance < 10000 && this.accountType.equals("Saving")) {
                    System.out.println("Error: Failed!");
                    System.out.println("Minimum balance required for a Saving account is " + 10000);
                    return;
                }
                if (newBalance < 0 && this.accountType.equals("Salary")) {
                    System.out.println("Error: Failed!");
                    System.out.println("Error: Minimum balance must be positive for Salary account");
                    return;
                }
                this.balance=newBalance;
                System.out.println("Balance updated successfully.");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    void deposit(Scanner input)
    {
        System.out.print("Enter a valid amount for deposit : ");
        double newBalance=input.nextInt();
        this.balance=this.balance+newBalance;
        System.out.println("Deposit successful.");
    }
    void withdraw(Scanner input)
    {
        System.out.print("Enter a valid amount for withdraw : ");
        double newBalance=input.nextInt();
        if (this.balance-newBalance < 2000 && this.accountType.equals("Current")) {
            System.out.println("Error: Failed !");
            System.out.println("Minimum balance required for a Current account is " + 2000);
            return;
        }
        if (this.balance-newBalance < 10000 && this.accountType.equals("Saving")) {
            System.out.println("Error: Failed!");
            System.out.println("Minimum balance required for a Saving account is " + 10000);
            return;
        }
        if (this.balance-newBalance < 0 && this.accountType.equals("Salary")) {
            System.out.println("Error: Failed!");
            System.out.println("Error: Minimum balance must be positive for Salary account");
            return;
        }
        this.balance=this.balance-newBalance;
        System.out.println("Withdraw successful.");
    }
}