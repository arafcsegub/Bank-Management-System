package banking_management_system;
import java.util.Scanner;
 
public class Banking_Management_System {
static int nextAccountNumber = 103;
    
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

        BankAccount[] accounts = new BankAccount[20];
        int count = 0;

        accounts[count++] = new SavingsAccount("Rahim", 101, 5000);
        accounts[count++] = new CurrentAccount("Karim", 102, 3000);

        BankAccount selectedAccount = null;

        System.out.println("1. Create Account");
        System.out.println("2. Login");
        System.out.print("Enter choice: ");
        int startChoice = sc.nextInt();

        // CREATE ACCOUNT
        if (startChoice == 1) {

            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter initial balance: ");
            double balance = sc.nextDouble();

            System.out.println("Select account type:");
            System.out.println("1. Savings");
            System.out.println("2. Current");
            System.out.print("Choice: ");
            int type = sc.nextInt();

            int accNo = nextAccountNumber++;

            if (type == 1) {
                accounts[count++] = new SavingsAccount(name, accNo, balance);
            } 
            else if (type == 2) {
                accounts[count++] = new CurrentAccount(name, accNo, balance);
            } 
            else {
                System.out.println("Invalid account type.");
                return;
            }

            System.out.println("Account created successfully.");
            System.out.println("Your account number is: " + accNo);
        }

        // LOGIN
        System.out.print("\nEnter account number to login: ");
        int loginAcc = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == loginAcc) {
                selectedAccount = accounts[i];
                break;
            }
        }

        if (selectedAccount == null) {
            System.out.println("Account not found.");
            return;
        }

        int choice;

        do {

            System.out.println("\n----- BANK MENU -----");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. View Account");
            System.out.println("5. Add Interest");
            System.out.println("6. Switch User");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount: ");
                    selectedAccount.deposit(sc.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    selectedAccount.withdraw(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter receiver account number: ");
                    int receiverNo = sc.nextInt();

                    BankAccount receiver = null;

                    for (int i = 0; i < count; i++) {
                        if (accounts[i].getAccountNumber() == receiverNo) {
                            receiver = accounts[i];
                            break;
                        }
                    }

                    if (receiver == null) {
                        System.out.println("Invalid receiver.");
                        break;
                    }

                    if (receiver == selectedAccount) {
                        System.out.println("Cannot transfer to same account.");
                        break;
                    }

                    System.out.print("Enter amount: ");
                    selectedAccount.transfer(receiver, sc.nextDouble());
                    break;

                case 4:
                    selectedAccount.displayInfo();
                    break;

                case 5:
                    if (selectedAccount instanceof SavingsAccount) {
                        ((SavingsAccount) selectedAccount).addInterest();
                    } else {
                        System.out.println("Interest only for savings accounts.");
                    }
                    break;

                case 6:
                    System.out.print("Enter new account number: ");
                    int newAcc = sc.nextInt();

                    selectedAccount = null;

                    for (int i = 0; i < count; i++) {
                        if (accounts[i].getAccountNumber() == newAcc) {
                            selectedAccount = accounts[i];
                            break;
                        }
                    }

                    if (selectedAccount == null) {
                        System.out.println("Account not found.");
                    } else {
                        System.out.println("User switched successfully.");
                    }
                    break;

                case 7:
                    System.out.println("Thank you.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}
