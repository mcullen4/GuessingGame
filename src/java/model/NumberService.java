/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Michele
 */
public class NumberService implements Serializable {
    
    private static final long serialVersionID = 1L;

    public String checkGuessAndReturnMessage(int guess, int randomNumber) {
        String returnMessage = null;
        if (guess == randomNumber) {
            returnMessage = "Correct";
        } else if (guess < randomNumber) {
            returnMessage = "Low Guess";
        } else {
            returnMessage = "High Guess";
        }
        return returnMessage;
    }

    public int getRandomNumber() {

        Random random = new Random();
        int randomNum = random.nextInt((10 - 1) + 1) + 1;
        return randomNum;
    }

}
