package banking_management_system;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(String name, int accNo, double balance) {
        super(name, accNo, balance);
    }

    @Override
    public void withdraw(double amount) {
        try {
         
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
            }

           
            if (getBalance() + 500 < amount) {
                throw new ArithmeticException("Withdrawal exceeds overdraft limit.");
            }

            setBalance(getBalance() - amount);
            System.out.println("Withdrawal of " + amount + " successful. Current balance: " + getBalance());

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Amount: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
    }
}
