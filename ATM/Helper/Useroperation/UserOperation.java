import java.util.Scanner;

class UserOperation {
    private int balance = 0;
    private String transactionHistory = "";

    public void userOperations(String[][] acc, int numofacc) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account ID:");
        String enteredId = sc.nextLine();

        System.out.println("Enter PIN:");
        String enteredPin = sc.nextLine();

        boolean authenticated = false;
        for (int i = 0; i < numofacc; i++) {
            if (acc[i][0].equals(enteredId) && acc[i][1].equals(enteredPin)) {
                authenticated = true;
                break;
            }
        }

        if (!authenticated) {
            System.out.println("Invalid Account ID or PIN.");
            return;
        }

        int userop = 0;
        while (userop != 7) {
            System.out.println("""
                 Enter your operation:
                1. Check balance
                2. Withdraw cash
                3. Initial deposit
                4. Deposit cash
                5. Change PIN
                6. View transaction history
                7. Exit
               """);
            userop = Integer.parseInt(sc.nextLine());

            switch (userop) {
                case 1 -> checkBalance();
                case 2 -> withdraw();
                case 3 -> initialDeposit();
                case 4 -> deposit();
                case 5 -> changePin(acc, numofacc);
                case 6 -> viewTransactions();
                case 7 -> System.out.println("Exiting user operations.");
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    public void withdraw() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to withdraw:");
        int amount = Integer.parseInt(sc.nextLine());

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            addTransaction("Failed withdrawal of ₹" + amount + " due to insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
            addTransaction("Withdrawal of ₹" + amount + ". Remaining balance: ₹" + balance);
        }
    }

    public void initialDeposit() {
        Scanner sc = new Scanner(System.in);
        int totalDeposit = 0;

        System.out.println("Enter the number of 2000 notes:");
        totalDeposit += Integer.parseInt(sc.nextLine()) * 2000;

        System.out.println("Enter the number of 500 notes:");
        totalDeposit += Integer.parseInt(sc.nextLine()) * 500;

        System.out.println("Enter the number of 200 notes:");
        totalDeposit += Integer.parseInt(sc.nextLine()) * 200;

        System.out.println("Enter the number of 100 notes:");
        totalDeposit += Integer.parseInt(sc.nextLine()) * 100;

        balance += totalDeposit;
        System.out.println("Initial deposit successful. New balance: ₹" + balance);
        addTransaction("Initial deposit of ₹" + totalDeposit + ". New balance: ₹" + balance);
    }

    public void deposit() {
        Scanner sc = new Scanner(System.in);
        int totalDeposit = 0;

        System.out.println("Enter the number of 2000 notes:");
        totalDeposit += Integer.parseInt(sc.nextLine()) * 2000;

        System.out.println("Enter the number of 500 notes:");
        totalDeposit += Integer.parseInt(sc.nextLine()) * 500;

        System.out.println("Enter the number of 200 notes:");
        totalDeposit += Integer.parseInt(sc.nextLine()) * 200;

        System.out.println("Enter the number of 100 notes:");
        totalDeposit += Integer.parseInt(sc.nextLine()) * 100;

        balance += totalDeposit;
        System.out.println("Deposit successful. New balance: ₹" + balance);
        addTransaction("Deposit of ₹" + totalDeposit + ". New balance: ₹" + balance);
    }

    public void changePin(String[][] acc, int numofacc) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your current PIN:");
        String currentPin = sc.nextLine();
        boolean authenticated = false;
        int accountIndex = -1;
        for (int i = 0; i < numofacc; i++) {
            if (acc[i][1].equals(currentPin)) {
                authenticated = true;
                accountIndex = i;
                break;
            }
        }

        if (!authenticated) {
            System.out.println("Invalid PIN. Cannot change PIN.");
            return;
        }

        System.out.println("Enter your new PIN:");
        String newPin = sc.nextLine();

        System.out.println("Re-enter your new PIN to confirm:");
        String confirmPin = sc.nextLine();

        if (!newPin.equals(confirmPin)) {
            System.out.println("PINs do not match. Try again.");
            return;
        }
        acc[accountIndex][1] = newPin;
        System.out.println("PIN changed successfully.");
    }

    public void viewTransactions() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            System.out.println(transactionHistory);
        }
    }

    private void addTransaction(String transaction) {
        transactionHistory += transaction + "\n";
    }
}
