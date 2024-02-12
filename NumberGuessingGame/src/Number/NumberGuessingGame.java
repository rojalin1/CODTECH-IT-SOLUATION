package Number;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Number Guessing Game!");

        int lowerBound = 1;
        int upperBound = 100;
        int numberToGuess = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        int maxAttempts = 10;
        int attempts = 0;
        int guess;

        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Too low. Try again!");
            } else {
                System.out.println("Too high. Try again!");
            }
        }

        if (attempts == maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numberToGuess + ".");
        }

        scanner.close();
    }
}


