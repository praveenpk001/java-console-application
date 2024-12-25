import java.util.Scanner;

class Helper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userChoice;

        Adminlogin admin = new Adminlogin();
        admin.setadmin_id("admin123");
        admin.setadminpass(12345);

        UserOperation userOperation = new UserOperation();
        System.out.println("\t\tWelcome");

        while (true) {
            System.out.println("Enter whether you are a customer or admin:\n1. Customer\n2. Admin\n3. Exit");
            userChoice = Integer.parseInt(sc.nextLine());

            if (userChoice == 1) userOperation.userOperations(admin.acc, admin.numofacc);
            else if (userChoice == 2) {
                admin.adminOperations();
            } else if (userChoice == 3) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}



