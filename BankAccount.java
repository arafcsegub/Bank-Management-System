package banking_management_system;

public abstract class BankAccount implements Transaction {

    private String name;
    private int accountNumber;
    private double balance;

   public BankAccount(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Deposit amount must be greater than zero.");
            }

            balance += amount;
            System.out.println("Deposit of " + amount + " successful. Current balance: " + balance);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Deposit Amount: " + e.getMessage());
        }
    }

    
    @Override
    public void transfer(BankAccount receiver, double amount) {
        try {
            if (amount <= 0) {
                throw new IllegalArgumentException("Transfer amount must be greater than zero.");
            }

            if (balance < amount) {
                throw new ArithmeticException("Insufficient balance for transfer.");
            }

            balance -= amount;
            receiver.setBalance(receiver.getBalance() + amount);

            System.out.println("Transfer of " + amount + " successful to Account No: " + receiver.getAccountNumber());

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Transfer Amount: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }

    
    public abstract void withdraw(double amount);

    public void displayInfo() {
        System.out.println("Account Holder: " + name);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}
