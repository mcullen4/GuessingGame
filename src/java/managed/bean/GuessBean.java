/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managed.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.NumberService;

/**
 *
 * @author Michele
 */
@Named
@SessionScoped
public class GuessBean implements Serializable {
    private static final long serialVersionID = 1L;
    private int guess;
    private int randomNumber;
    private int noGuesses;
    private static final String LOW_GUESS = "Your guess is low - guess a higher number";
    private static final String HIGH_GUESS = "Your guess is high - guess a lower number";
    private static final String CORRECT_GUESS = "You guessed correctly";
    private int highNoGuesses=0;
    private int lowNoGuesses=0;
    private String message;
    private boolean guessText = false;
    private boolean guessField = false;
    private boolean submitGuessButton = false;
    private boolean startGameButton = true;
    private int gamesPlayed;

    @Inject
    private NumberService numberService;

    /**
     * Creates a new instance of Guess
     */
    public GuessBean() {
    }

    public String startGame() {
        guessText = true;
        guessField = true;
        submitGuessButton = true;
        startGameButton = false;
        message=null;
        guess=0;
        noGuesses=0;
        generateAndReturnRandomNumber();
        return null;
    }

    public String generateAndReturnRandomNumber() {
        randomNumber = numberService.getRandomNumber();
        //System.out.println(randomNumber);
        return null;
    }

    public String checkGuess() {
        String guessResult = numberService.checkGuessAndReturnMessage(guess, randomNumber);
        switch (guessResult) {
            case "Correct":
                message = CORRECT_GUESS;
                guessText = false;
                guessField = false;
                submitGuessButton = false;
                startGameButton = true;
                setLowNoGuesses(noGuesses);
                setHighNoGuesses(noGuesses);
                break;
            case "Low Guess":
                message = LOW_GUESS;
                noGuesses++;
                break;
            case "High Guess":
                message = HIGH_GUESS;
                noGuesses++;
                break;
        }
        return null;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getNoGuesses() {
        return noGuesses;
    }

    public void setNoGuesses(int noGuesses) {
        this.noGuesses = noGuesses;
    }

    public int getHighNoGuesses() {
        return highNoGuesses;
    }

    public void setHighNoGuesses(int guess) {
        if(guess>highNoGuesses){
        this.highNoGuesses = guess;
        }
    }

    public int getLowNoGuesses() {
        return lowNoGuesses;
    }

    public void setLowNoGuesses(int guess) {
        if(guess<lowNoGuesses || lowNoGuesses==0){
        this.lowNoGuesses = guess;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isGuessText() {
        return guessText;
    }

    public void setGuessText(boolean guessText) {
        this.guessText = guessText;
    }

    public boolean isGuessField() {
        return guessField;
    }

    public void setGuessField(boolean guessField) {
        this.guessField = guessField;
    }

    public boolean isSubmitGuessButton() {
        return submitGuessButton;
    }

    public void setSubmitGuessButton(boolean submitGuessButton) {
        this.submitGuessButton = submitGuessButton;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public NumberService getNumberService() {
        return numberService;
    }

    public void setNumberService(NumberService numberService) {
        this.numberService = numberService;
    }

    public boolean isStartGameButton() {
        return startGameButton;
    }

    public void setStartGameButton(boolean startGameButton) {
        this.startGameButton = startGameButton;
    }

}
