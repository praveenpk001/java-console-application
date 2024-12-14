 import java.sql.SQLOutput;
 import java.util.Scanner;

public class Mynewcalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double num1=1;
        double num2=2;
        double num3=3;

        do {
            System.out.println("Calculator");
            System.out.println("Select your option:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power");
            System.out.println("6. Exit");

            choice = scanner.nextInt();

            if (choice == 6) {
                System.out.println("Exiting the calculator.");
                break;
            }
            System.out.println("Enter you want 2 number or 3 number :");
            int userchoice = scanner.nextInt();
            if (userchoice==2)
            {
                System.out.println("Enter the first number:");
                num1 = scanner.nextDouble();
                System.out.println("Enter the second number:");
                num2 = scanner.nextDouble();
                if(choice==1)
                {
                    System.out.println(Calculator.add(num1,num2));
                }
                else if(choice ==2)
                {
                    System.out.println(Calculator.sub(num1,num2));
                }
                else if(choice==3)
                {
                    System.out.println(Calculator.mul(num1,num2));
                }
                else if(choice==4)
                {
                    System.out.println(Calculator.div(num1,num2));
                }
                else if(choice==5)
                {
                    System.out.println(Calculator.power(num1,num2));
                }
            }

            if (userchoice==3)
            {
                System.out.println("Enter the first number:");
                num1 = scanner.nextDouble();
                System.out.println("Enter the second number:");
                num2 = scanner.nextDouble();
                System.out.println("Enter the third number:");
                num3 = scanner.nextDouble();
                double result = Calculator.add(num1,num2,num3);
                if(choice==1)
                {
                    System.out.println(Calculator.add(num1,num2,num3));
                }
                else if(choice ==2)
                {
                    System.out.println(Calculator.sub(num1,num2,num3));
                }
                else if(choice==3)
                {
                    System.out.println(Calculator.mul(num1,num2,num3));
                }
                else if(choice==4)
                {
                    System.out.println(Calculator.div(num1,num2,num3));
                }
                else if(choice==5)
                {
                    System.out.println(Calculator.power(num1,num2,num3));
                }
            }


            double result = 0;

            switch (choice) {
                case 1:
                    if(userchoice==2)
                    {
                        result = Calculator.add(num1,num2);
                    }
                    else if(userchoice==3) {
                        result = Calculator.add(num1, num2, num3);

                        System.out.println("Result: " + result);
                        break;
                    }
                case 2:
                    if(userchoice==2)
                    {
                        result = Calculator.sub(num1,num2);
                    }
                    else if(userchoice==3) {
                        result = Calculator.sub(num1, num2, num3);
                        System.out.println("Result: " + result);
                        break;
                    }

                case 3:
                    if(userchoice==2)
                    {
                        result = Calculator.mul(num1,num2);
                    }
                    else if(userchoice==3) {
                        result = Calculator.mul(num1, num2, num3);
                        System.out.println("Result: " + result);
                        break;
                    }
                case 4:
                    if(userchoice==2)
                    {
                        result = Calculator.div(num1,num2);
                    }
                    else if(userchoice==3) {
                        result = Calculator.div(num1, num2, num3);
                        System.out.println("Result: " + result);
                        break;
                    }
                case 5:
                    if(userchoice==2)
                    {
                        result = Calculator.power(num1,num2);
                    }
                    else if(userchoice==3) {
                        result = Calculator.power(num1, num2, num3);
                        System.out.println("Result: " + result);
                        break;
                    }


                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        scanner.close();
    }
}

