package src;
import java.util.ArrayList;
import java.util.Scanner;
class BankEasy {
    private static ArrayList<Account> accounts = new ArrayList<>();
    private static void createAccount(Scanner input) {

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

        if (balance < 2000 && accountType.equals("Current")) {
            System.out.println("Error: Failed to Create Account!");
            System.out.println("Minimum balance required to open a Current account is " + 2000);
            return;
        }
        if (balance < 10000 && accountType.equals("Saving")) {
            System.out.println("Error: Failed to Create Account!");
            System.out.println("Minimum balance required to open a Saving account is " + 10000);
            return;
        }
        if (balance < 0 && accountType.equals("Salary")) {
            System.out.println("Error: Failed to Create Account!");
            System.out.println("Error: Minimum balance must be positive for Salary account");
            return;
        }

        Account account= new Account(firstName,lastName, accountNumber, accountType, balance);
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    private static void displayAllAccounts() {
        System.out.println("Accounts List :");
        for (Account account : accounts) {
            System.out.println("Name: " + account.getAccountName() + ", Account Number: " + account.getAccountNumber() +
                    ", Account Type: " + account.getAccountType() + ", Creation Date: " + account.getCreationDate() +
                    ", Balance: $" + account.getBalance());
        }
    }

    private static void updateAccount(Scanner input) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found. Please create an account first.");
            return;
        }
        System.out.println("Enter account number to update:");
        int accountNumber = input.nextInt();
        Account account = null;
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                account = acc;
                account.updateAccount(input);
            }
        }
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
    }

    private static void deleteAccount(Scanner input) {
        System.out.print("Enter an account number to delete: ");
        int accountNumber = input.nextInt();

        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccountNumber() == accountNumber) {
                accounts.remove(i);
                System.out.println("Account deleted successfully!");
                return;
            }
        }
        System.out.println("Account not found.");
    }

    private static void depositAmount(Scanner input) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found. Please create an account first.");
            return;
        }
        System.out.println("Enter account number to deposit:");
        int accountNumber = input.nextInt();
        Account account = null;
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                account = acc;
                account.deposit(input);
            }
        }
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
    }

    private static void withdrawAmount(Scanner input) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found. Please create an account first.");
            return;
        }
        System.out.println("Enter account number to withdraw:");
        int accountNumber = input.nextInt();
        Account account = null;
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                account = acc;
                account.withdraw(input);
            }
        }
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
    }

    private static void searchAccount(Scanner input) {
        System.out.print("Enter an account number for search: ");
        int accountNumber = input.nextInt();
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.println("Account found:");
                System.out.println("Name: " + account.getAccountName() + ", Account Number: " + account.getAccountNumber() +
                        ", Account Type: " + account.getAccountType() + ", Creation Date: " + account.getCreationDate() +
                        ", Balance: $" + account.getBalance());
                return;
            }
        }

        System.out.println("Account not found.");
    }

    private static void choiceList() {
        System.out.println("Banking Application Menu:");
        System.out.println("1. Create a new account");
        System.out.println("2. Display all accounts");
        System.out.println("3. Update an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Deposit an amount into your account");
        System.out.println("6. Withdraw an amount from your account");
        System.out.println("7. Search for an account");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        while (true)
        {
            choiceList();
            int choice = input.nextInt();
            if(choice>8 || choice<1){
                System.out.println("Error: Please Enter a Valid choice!");
                continue;
            }
            if(choice==1)
            {
                createAccount(input);
            }
            else if(choice==2)
            {
                displayAllAccounts();
            }
            else if(choice==3)
            {
                updateAccount(input);
            }
            else if(choice==4)
            {
                deleteAccount(input);
            }
            else if(choice==5)
            {
                depositAmount(input);
            }
            else if(choice==6)
            {
                withdrawAmount(input);
            }
            else if(choice==7)
            {
                searchAccount(input);
            }
            else
            {
                break;
            }
        }
    }
}
