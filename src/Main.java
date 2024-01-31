package src;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.next();
        System.out.print("Enter last name: ");
        String lastName = input.next();
        System.out.print("Enter account number: ");
        int accountNumber = input.nextInt();
        System.out.print("Enter account type: ");
        String accountType = input.next();
        System.out.print("Enter opening balance: ");
        double balance = input.nextDouble();
        Account account= new Account(firstName,lastName, accountNumber, accountType, balance);
        System.out.println("Account created successfully!");

        //Display Account
        System.out.print("Account name: ");
        System.out.println(account.getAccountName());
        System.out.print("Account number: ");
        System.out.println(account.getAccountNumber());
        System.out.print("Account type: ");
        System.out.println(account.getAccountType());
        System.out.print("balance: ");
        System.out.println(account.getBalance());
        System.out.print("Creation Date: ");
        System.out.println(account.getCreationDate());
    }
}
