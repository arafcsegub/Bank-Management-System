# Bank Management System

A Java-based console application built using **Object-Oriented Programming (OOP)** concepts.  
This project simulates a simple banking system where users can create accounts, log in, and perform various transactions.

## 🚀 Features
- Create Savings or Current accounts with unique account numbers
- Deposit money with validation
- Withdraw money with rules:
  - Savings Account → must have sufficient balance
  - Current Account → overdraft limit up to 500
- Transfer money between accounts
- View account holder details and balance
- Add 5% interest to Savings Accounts
- Switch between users
- Exit safely

## 🛠️ Technologies Used
- Java  
- OOP principles: Abstraction, Inheritance, Polymorphism, Encapsulation  
- Exception Handling for invalid transactions  

## 📂 Project Structure
- **BankAccount.java** → Abstract base class with deposit, transfer, and display methods  
- **SavingsAccount.java** → Extends BankAccount, adds interest feature  
- **CurrentAccount.java** → Extends BankAccount, supports overdraft withdrawal  
- **Transaction.java** → Interface defining deposit, withdraw, and transfer  
- **Banking_Management_System.java** → Main class with menu-driven console interface  

## ▶️ How to Run
1. Open in any Java IDE (IntelliJ, NetBeans, Eclipse)  
2. Compile and run `Banking_Management_System.java`  
3. Use the console menu to create accounts, log in, and perform transactions  

## 🔮 Future Improvements
- Add Graphical User Interface (GUI)  
- Connect with a database (MySQL/SQLite)  
- Implement user authentication and transaction logs  
