package src;

import java.util.Date;
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
    void updateAccount(Account current)
    {

    }
    void depositAmount()
    {

    }
    void withdrawAmount()
    {

    }
}