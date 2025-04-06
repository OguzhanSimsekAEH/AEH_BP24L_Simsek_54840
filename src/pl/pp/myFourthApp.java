package pl.pp;
import java.util.Scanner;

public class myFourthApp {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Sum of Squares");
                System.out.println("2. Simple Calculator");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        sumOfSquares(scanner);
                        break;
                    case "2":
                        simpleCalculator(scanner);
                        break;
                    case "3":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

            scanner.close();
        }

        public static void sumOfSquares(Scanner scanner) {
            while (true) {
                System.out.print("Enter lower and upper integer limits: ");
                int lower = scanner.nextInt();
                int upper = scanner.nextInt();

                if (upper <= lower) {
                    System.out.println("Done");
                    scanner.nextLine();
                    break;
                }

                int sum = 0;
                for (int i = lower; i <= upper; i++) {
                    sum += i * i;
                }

                System.out.println("The sum of the squares from " + (lower * lower) + " to " + (upper * upper) + " is " + sum);
                scanner.nextLine();
            }
        }

        public static void simpleCalculator(Scanner scanner) {
            while (true) {
                System.out.println("\nCalculator Menu:");
                System.out.println("a. Add");
                System.out.println("b. Subtract");
                System.out.println("c. Multiply");
                System.out.println("d. Divide");
                System.out.println("e. Back to Main Menu");
                System.out.print("Choose operation: ");
                String op = scanner.nextLine();

                if (op.equals("e")) break;

                System.out.print("Enter first number: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Try again.");
                    scanner.nextLine();
                    continue;
                }
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Try again.");
                    scanner.nextLine();
                    continue;
                }
                double num2 = scanner.nextDouble();
                scanner.nextLine();

                switch (op) {
                    case "a":
                        System.out.println("Result: " + (num1 + num2));
                        break;
                    case "b":
                        System.out.println("Result: " + (num1 - num2));
                        break;
                    case "c":
                        System.out.println("Result: " + (num1 * num2));
                        break;
                    case "d":
                        if (num2 == 0) {
                            System.out.println("Cannot divide by zero.");
                        } else {
                            System.out.println("Result: " + (num1 / num2));
                        }
                        break;
                    default:
                        System.out.println("Invalid operation. Try again.");
                }
            }
        }
    }
