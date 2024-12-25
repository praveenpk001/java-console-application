import java.util.Scanner;

class Adminlogin {
    private String admin_id;
    private int adminpass;
    public int numofacc = 0;
    String[][] acc = new String[10][3];
    public static int totalAmount;

    // Getters and Setters
    public String getadmin_id() {
        return admin_id;
    }

    public void setadmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public int getadminpass() {
        return adminpass;
    }

    public void setadminpass(int adminpass) {
        this.adminpass = adminpass;
    }

    // Admin operations
    public void adminOperations() {
        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        System.out.println("Enter the admin_id:");
        String enteredId = sc.nextLine();

        if (enteredId.equals(admin_id)) {
            while (attempts < 3) {
                System.out.println("Enter your password:");
                int enteredPass = Integer.parseInt(sc.nextLine());

                if (enteredPass == adminpass) {
                    System.out.println("Successfully logged in!");
                    while (true) {
                        System.out.println("""
                                Enter your operation:
                                1. Add user account
                                2. Delete user account
                                3. Deposit amount
                                4. View all transactions
                                5. Exit
                                """);
                        int operation = Integer.parseInt(sc.nextLine());

                        switch (operation) {
                            case 1 -> addUser();
                            case 2 -> deleteUser();
                            case 3 -> depositAmount();
                            case 4 -> viewAllTransactions();
                            case 5 -> {
                                System.out.println("Exiting admin operations.");
                                return;
                            }
                            default -> System.out.println("Invalid operation. Try again.");
                        }
                    }
                } else {
                    attempts++;
                    System.out.println("Incorrect password. Attempts remaining: " + (3 - attempts));
                }
            }

            if (attempts == 3) {
                System.out.println("Maximum attempts reached. Exiting admin operations.");
            }
        } else {
            System.out.println("Invalid admin ID.");
        }
    }

    public void addUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many accounts do you want to create?");
        int numacc = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numacc; i++) {
            System.out.println((numofacc + 1) + "st Account Details");
            System.out.println("--------------------");

            System.out.println("Enter Account ID:");
            acc[numofacc][0] = sc.nextLine();

            System.out.println("Enter New PIN Number:");
            acc[numofacc][1] = sc.nextLine();

            System.out.println("Account " + (numofacc + 1) + " created with ID: " + acc[numofacc][0] + ", PIN: " + acc[numofacc][1]);
            numofacc++;
        }

        System.out.println("All accounts have been created successfully.");
    }

    public void deleteUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Account ID to delete:");
        String accountId = sc.nextLine(); // Account IDs are strings

        boolean accountFound = false;
        for (int i = 0; i < numofacc; i++) {
            if (acc[i][0].equals(accountId)) {
                System.out.println("Account with ID " + acc[i][0] + " has been deleted.");
                acc[i][0] = null; // Reset account ID
                acc[i][1] = null; // Reset PIN
                accountFound = true;
                break;
            }
        }

        if (!accountFound) {
            System.out.println("Account ID not found.");
        }
    }

    public void depositAmount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of 2000rs notes:");
        int tn = Integer.parseInt(sc.nextLine());
        System.out.println("Enter no. of 500rs notes:");
        int tp = Integer.parseInt(sc.nextLine());
        System.out.println("Enter no. of 200rs notes:");
        int tc = Integer.parseInt(sc.nextLine());
        System.out.println("Enter no. of 100rs notes:");
        int tv = Integer.parseInt(sc.nextLine());

        totalAmount = (tn * 2000) + (tp * 500) + (tc * 200) + (tv * 100);
        System.out.println("Deposited amount is: ₹" + totalAmount);
    }

    public void viewAllTransactions() {
        System.out.println("Transaction history:");
        System.out.println("Total Deposited Amount: ₹" + totalAmount);
    }
}