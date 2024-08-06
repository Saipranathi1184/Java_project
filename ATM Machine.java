import java.util.Scanner;

class ATM {
    float balance;
    int pin;

    public void checkPin() {
        System.out.println("Enter PIN number: ");
        Scanner sc = new Scanner(System.in);
        int enteredPin = sc.nextInt();
        if (enteredPin == pin) {
            menu();
        } else {
            System.out.println("Invalid PIN entered.");
            checkPin();
        }
    }

    public void menu() {
        System.out.println("\nEnter your choice: ");
        System.out.println("1. Check Account Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Exit");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                depositMoney();
                break;
            case 4:
                System.out.println("\nThank you for using our ATM. Goodbye!");
                return;
            default:
                System.out.println("Invalid option selected.");
                menu();
        }
    }

    public void checkBalance() {
        System.out.println("\nAccount balance: " + balance);
        menu();
    }

    public void withdrawMoney() {
        System.out.println("\nEnter amount to withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        if (amount > balance) {
            System.out.println("\nInsufficient balance.");
        } else {
            balance -= amount;
            System.out.println("\nMoney withdrawal successful.");
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("\nEnter amount to deposit:");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        balance += amount;
        System.out.println("\nMoney deposited successfully.");
        menu();
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.pin = 1234; // set initial PIN
        obj.balance = 5000.0f; // set initial balance
        obj.checkPin();
    }
}

/*OUTPUT:
Enter PIN number: 
1234

Enter your choice: 
1. Check Account Balance
2. Withdraw Money
3. Deposit Money
4. Exit
2

Enter amount to withdraw: 
2000

Money withdrawal successful.

Enter your choice: 
1. Check Account Balance
2. Withdraw Money
3. Deposit Money
4. Exit
1

Account balance: 3000.0

Enter your choice: 
1. Check Account Balance
2. Withdraw Money
3. Deposit Money
4. Exit
3

Enter amount to deposit:
1000

Money deposited successfully.

Enter your choice: 
1. Check Account Balance
2. Withdraw Money
3. Deposit Money
4. Exit
1

Account balance: 4000.0

Enter your choice: 
1. Check Account Balance
2. Withdraw Money
3. Deposit Money
4. Exit
4

Thank you for using our ATM. Goodbye!
*/



