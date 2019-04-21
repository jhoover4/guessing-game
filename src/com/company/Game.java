package com.company;

import java.util.concurrent.ThreadLocalRandom;

class Game {
    private int _minGuessRange;
    private int _maxGuessRange;
    private int _highScore;
    private int _correctNumber;
    private int _turns;

    Game(int minGuessRange, int maxGuessRange, int highScore) {
        this._minGuessRange = minGuessRange;
        this._maxGuessRange = maxGuessRange;

        this._highScore = highScore;
        this._turns = 0;
        this.generateGameNumber();
    }

    Game(int minGuessRange, int maxGuessRange) {
        this._minGuessRange = minGuessRange;
        this._maxGuessRange = maxGuessRange;

        this._highScore = this._maxGuessRange;
        this._turns = 0;
        this.generateGameNumber();
    }

    public int getHighScore() {
        return this._highScore;
    }

    public String userGuessResponse(int userGuessNum) {
        if (userGuessNum > this._maxGuessRange || userGuessNum < this._minGuessRange) {
            return "Number outside of guessing range." + "Range is " + this._minGuessRange + " to " + this._maxGuessRange;
        }

        this._turns++;
        if (userGuessNum == this._correctNumber) {
            return this.endGame();
        } else if (userGuessNum > this._correctNumber) {
            return "The number is lower";
        } else {
            return "The number is higher";
        }
    }

    public boolean isUserGuessCorrect(int userGuessNum) {
        return userGuessNum == this._correctNumber;
    }

    public String startGame() {
        String prompt;

        prompt = "Welcome to the Command Line Number Guessing Game!\n\n";
        prompt += "Guess a number between " + this._minGuessRange + " and " + this._maxGuessRange + "\n";
        prompt += "high score is: " + this._highScore + "\n\n";
        prompt += "Press enter to start\n";
        prompt += "Type (q) to quit.\n";

        return prompt;
    }

    public String endGame() {
        String prompt;

        this.updateHighScore();

        prompt = "\nYou got it!\n";
        prompt += "It took you " + this._turns + " tries\n";
        prompt += "Current high score is: " + this._highScore + "\n\n";
        prompt += "Press enter to play again\n";
        prompt += "Type (q) to quit.\n";

        return prompt;
    }

    private void updateHighScore() {
        this._highScore = this._turns < _highScore ? this._turns : _highScore;
    }

    private void generateGameNumber() {
        this._correctNumber = ThreadLocalRandom.current().nextInt(this._minGuessRange, this._maxGuessRange + 1);
    }
}
