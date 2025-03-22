package pl.pp;

import java.util.Scanner;

public class mySecondApp {
    public static void main(String[] args) {

        int x = 10;
        int doubleX = 2 * x;
        int squaredX = x * x;

        System.out.println("x = " + x);
        System.out.println("Double of x = " + doubleX);
        System.out.println("x squared = " + squaredX);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your age in years:");
        int ageYears = scanner.nextInt();
        long ageSeconds = (long) ageYears * 365 * 24 * 60 * 60;

        System.out.println("My age in seconds: " + ageSeconds);

        scanner.close();
    }
}
