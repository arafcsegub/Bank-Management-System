package banking_management_system;


public class SavingsAccount extends BankAccount {

   public SavingsAccount(
            String name,
            int accNo,
            double balance){

        super(
            name,
            accNo,
            balance
        );
    }


    @Override
    public void withdraw(
            double amount){

        try{

            if(amount <= 0){
                throw new IllegalArgumentException();
            }

            if(getBalance() < amount){
                throw new ArithmeticException();
            }

            setBalance(
                getBalance() - amount
            );

            System.out.println(
            "Withdraw Successful."
            );

        }

        catch(IllegalArgumentException e){
            System.out.println("Invalid Amount.");
        }

        catch(ArithmeticException e){
            System.out.println("Insufficient Funds.");
        }
    }


    // ===== NEW METHOD (Interest) =====
    public void addInterest() {

        try {

            double rate = 0.05; // 5% interest

            if(getBalance() <= 0){
                throw new ArithmeticException();
            }

            double interest =
                getBalance() * rate;

            setBalance(
                getBalance() + interest
            );

            System.out.println(
            "Interest Added: " + interest
            );

        }

        catch(ArithmeticException e){

            System.out.println(
            "No balance to add interest."
            );
        }
    }
}
