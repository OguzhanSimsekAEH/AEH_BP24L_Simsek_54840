package pl.pp;
import java.util.Scanner;

public class myThirdApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ------------------------- PART 1: Days to weeks & days -------------------------
        System.out.println("=== Part 1: Convert days to weeks/days ===");
        int days;
        do {
            System.out.print("Enter the number of days (non-positive to quit): ");
            days = sc.nextInt();

            if (days > 0) {
                int weeks = days / 7;
                int remainder = days % 7;
                System.out.println(days + " day(s) is " + weeks + " week(s) and "
                        + remainder + " day(s).");
            }
        } while (days > 0);

        System.out.println("Days conversion finished.\n");

        // ------------------------- PART 2: Celsius to Fahrenheit & Kelvin -------------------------
        System.out.println("=== Part 2: Convert Celsius to Fahrenheit/Kelvin ===");
        double celsius;
        do {
            System.out.print("Enter temperature in Celsius (-1 to quit): ");
            celsius = sc.nextDouble();

            if (celsius != -1) {
                double fahrenheit = 1.8 * celsius + 32.0;
                double kelvin     = celsius + 273.16;
                // Print with two decimal places
                System.out.printf("Celsius: %.2f, Fahrenheit: %.2f, Kelvin: %.2f%n",
                        celsius, fahrenheit, kelvin);
            }
        } while (celsius != -1);

        System.out.println("Temperature conversion finished.");

        sc.close();
    }
}
        /*
        Scanner scanner = new Scanner(System.in);

        // Prompt for a number greater than 100
        System.out.println("Enter a number greater than 100:");
        var number1 = scanner.nextDouble();
        while (number1 <= 100) {
            System.out.println("The number is not greater than 100, enter again:");
            number1 = scanner.nextDouble();
        }
        System.out.println("Thank you! You've entered: " + number1);

        // Prompt for a number greater than 200 (do..while)
        double number2;
        do {
            System.out.println("Enter a number greater than 200:");
            number2 = scanner.nextDouble();
        } while (number2 <= 200);
        System.out.println("Thank you! You've entered: " + number2);

        // For loop
        int wynik = 0;
        for (var i = 1; i <= 10; i++) {
            wynik = wynik + i;
            System.out.println("Iteration no. " + i + " in the for loop, and the result (wynik) = " + wynik);
        }

        // If..else conditional statements
        System.out.println("Enter the value of x: ");
        var x = scanner.nextDouble();
        System.out.println("Enter the value of y: ");
        var y = scanner.nextDouble();

        if (x > y) {
            System.out.println("x is greater than y");
        } else if (x < y) {
            System.out.println("x is smaller than y");
        } else {
            System.out.println("x equals y");
        }

        // Terminating the program by pressing a specific key
        while (true) {
            System.out.println("Enter -1 to exit the program");
            var input = scanner.nextDouble();
            if (input == -1) {
                System.out.println("Exit...");
                break;
            }
        }

        scanner.close();
        */

