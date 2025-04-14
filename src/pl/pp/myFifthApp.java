package pl.pp;

public class myFifthApp {
    public static void main(String[] args) {
        /*
         // ----------------------------
         // Previous demonstration code
         // ----------------------------
         System.out.println("Calculations and display of the result for values assigned in the application code");
         boolean gameOver = true;
         int score = 800;
         int levelCompleted = 5;
         int bonus = 100;

         int finalScore = score;
         if (gameOver) {
             finalScore += (levelCompleted * bonus);
             finalScore += 1000;
             System.out.println("Your score #1 is " + finalScore);
         }

         System.out.println("Calculations and display of the result for values assigned in the application code (different than before)");
         score = 10000;
         levelCompleted = 8;
         bonus = 200;

         finalScore = score;
         if (gameOver) {
             finalScore += (levelCompleted * bonus);
             finalScore += 1000;
             System.out.println("Your score #2 is " + finalScore);
         }

         System.out.println("Calculations using the method calculateScore_noArguments(), but still for values assigned in the method code");
         calculateScore_noArguments();

         System.out.println("Calculations using the method calculateScore(), but this time for values entered into the method call argument");
         calculateScore_arguments(true, 2500, 9, 250);
         calculateScore_arguments(gameOver, score, levelCompleted, bonus);

         finalScore = calculateScore_argumentsReturn(gameOver, score, levelCompleted, bonus);
         System.out.println("Your score #5 is " + finalScore);
        */


        printCharacter('*', 5, 3);

    }


    private static void printCharacter(char character, int times, int lines) {
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < times; j++) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    /*
    
    private static void calculateScore_noArguments() {
        boolean gameOver = true;
        int score = 150;
        int levelCompleted = 2;
        int bonus = 1000;
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your score #3 is " + finalScore);
        }
    }

    private static void calculateScore_arguments(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
            System.out.println("Your score #4 is " + finalScore);
        }
    }

    private static int calculateScore_argumentsReturn(boolean gameOver, int score, int levelCompleted, int bonus) {
        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            finalScore += 1000;
        }
        return finalScore;
    }
    */
}
