package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userGuess;
        int highScore = 0;
        int userGuessInt;

        Scanner scanner = new Scanner(System.in);

        Game game = new Game(1, 100);
        System.out.println(game.startGame());

        userGuess = scanner.next();
        while (!userGuess.equals("q")) {
            try {
                userGuessInt = Integer.parseInt(userGuess);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid response.");
                userGuess = scanner.next();
                continue;
            }

            System.out.println(game.userGuessResponse(userGuessInt));

            if (game.isUserGuessCorrect(userGuessInt)) {
                highScore = game.getHighScore();
                game = new Game(1, 100, highScore);
            }

            userGuess = scanner.next();
        }

        System.out.println("Bye!");
    }
}