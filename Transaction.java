
package banking_management_system;

public interface Transaction {
    
    void deposit(double amount);

    void withdraw(double amount);

    void transfer(
        BankAccount receiver,
        double amount
    );
    
}
