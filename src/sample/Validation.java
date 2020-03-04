package sample;

import com.jfoenix.controls.JFXTextField;

import java.util.regex.*;

public class Validation {
    public int speed (Directions direction, int speed){
        switch (direction) {
            case FORWARD:
            case LEFT:
            case RIGHT:
                if (speed > 200 || speed < -200) {
                    System.out.println("Please Input Valid Speed - Throw - " + speed);
                    return 0;
                } else {
                    if (speed < 0 ) {
                        return Math.abs(speed);
                    } else {
                        return speed;
                    }
                }
            case BACKWARDS:
                if (speed > 200 || speed < -200) {
                    System.out.println("Please Input Valid Speed - Throw " + speed);
                    return 0;
                } else {
                    if (speed > 0 ) {
                        return speed * -1;
                    } else {
                        return speed;
                    }
                }
        }

        return 0;
    }

    public int duration(Directions directions, int seconds) {
        int ms;
        double msTemp;
        if (seconds > 6 || seconds < 0) {
            System.out.println("Please Try Again");
            return 0;
        }
        msTemp = seconds * 1000;
        ms = (int)msTemp;
        return ms;
    }

    public int fieldToInt (JFXTextField input) {
        String text = input.getText();
        Boolean valid = containsCharacters(text);
        if (!valid) {
            if (text.length() <= 0) {
                PopUp.displayError("Please Enter a Number", "Hey! So it seems like you haven't actually entered anything. Please enter a value that is ONLY a number! Feel free to try again!");
                return 0;
            }
            return Integer.parseInt(text);
        }
        PopUp.displayError("Please Enter a Number", "Hey! So it seems like you've entered a dodgy value that isn't accepted by me. Please enter a value that is ONLY a number! Feel free to try again!");
        return 0;
    }

    private Boolean containsCharacters(String input) {
        Pattern pattern = Pattern.compile("[^\\d]", Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(input);
        return match.find();
    }

    public int textFieldCheck(JFXTextField field) {
        String text = field.getText();

        text = text.replaceAll("[^\\d]", "");
        field.setText(text);
        field.positionCaret(field.getText().length());
        if (text.length() <= 0) {
            return 0;
        }
        return Integer.parseInt(text);
    }
}
