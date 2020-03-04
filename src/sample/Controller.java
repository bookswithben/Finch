// PACKAGE
package sample;

// Imports
import com.jfoenix.controls.JFXTextField;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;

import javafx.scene.shape.Circle;
import javafx.stage.Popup;

import javax.swing.*;

public class Controller {
    //private Finch myFinch = Main.finch;
    // Getting the speed & duration fields from the forward section
    @FXML
    JFXTextField forwardSpeed, forwardDuration;

    // Getting the speed & duration fields from the backward section
    @FXML
    JFXTextField backwardSpeed, backwardDuration;

    // Getting the speed & duration fields from the left section
    @FXML
    JFXTextField leftSpeed, leftDuration;

    // Getting the speed & duration fields from the right section
    @FXML
    JFXTextField rightSpeed, rightDuration;

    // declaring my variables for use in all of the ui component controllers
    public Circle middleCircle;
    private Directions direction;
    private Movement move = new Movement();
    private Validation validate = new Validation();
    private Retracing retrace = new Retracing();
    private FileManagement file = new FileManagement();
    private int speed, duration;



    // What happens once you click the forward button
    public void forwards(ActionEvent actionEvent) {

        direction = Directions.FORWARD;

        speed = validate.fieldToInt(forwardSpeed);
        duration = validate.fieldToInt(forwardDuration);
        //move.move(direction,speed,duration,myFinch);
        move.move(direction,speed,duration);
        retrace.addRetracing(direction,speed,duration);
        System.out.println("FINCH TURN " + direction + " Left Wheel " + speed + " Right Wheel " + speed + " For " + duration);
    }

    // What happens once you click the backwards button
    public void backwards(ActionEvent actionEvent) {
        direction = Directions.BACKWARDS;

        speed = validate.fieldToInt(backwardSpeed);
        duration = validate.fieldToInt(backwardDuration);

        //move.move(direction,speed,duration,myFinch);
        move.move(direction,speed,duration);
        retrace.addRetracing(direction,speed,duration);
        System.out.println("FINCH TURN " + direction + " Left Wheel " + speed + " Right Wheel " + speed + " For " + duration);
    }

    // What happens once you click the left button
    public void left(ActionEvent actionEvent) {
        direction = Directions.LEFT;

        speed = validate.fieldToInt(leftSpeed);
        duration = validate.fieldToInt(leftDuration);

       //move.move(direction,speed,duration,myFinch);
        move.move(direction,speed,duration);
        retrace.addRetracing(direction,speed,duration);
        System.out.println("FINCH TURN " + direction + " Left Wheel " + speed + " Right Wheel " + speed + " For " + duration);

    }

    // What happens once you click the right button
    public void right(ActionEvent actionEvent) {
        direction = Directions.RIGHT;

        speed = validate.fieldToInt(rightSpeed);
        duration = validate.fieldToInt(rightDuration);

        //move.move(direction,speed,duration,myFinch);
        move.move(direction,speed,duration);
        retrace.addRetracing(direction,speed,duration);
        System.out.println("FINCH TURN " + direction + " Left Wheel " + speed + " Right Wheel " + speed + " For " + duration);
    }

    public void retrace(ActionEvent actionEvent) {
        // Do Retracing
        System.out.println("Start Retrace");
        PopUp.retracingWindow(retrace);
        System.out.println("End Retrace");
    }

    public void write(ActionEvent actionEvent) {
        // Do Write
        file.write();

    }

    public void read(ActionEvent actionEvent) {
        // Do Read
        file.read();

    }


    public void quit(ActionEvent actionEvent) {
        // Do Quit
        System.exit(0);
    }


    public void forwardSpeedValidate(KeyEvent ke) {
        Directions direction = Directions.FORWARD;
       speed = validate.textFieldCheck(forwardSpeed);
       validate.speed(direction,speed);
    }

    public void forwardDurationValidate(KeyEvent ke) {
        Directions direction = Directions.FORWARD;
        duration = validate.textFieldCheck(forwardDuration);
        validate.duration(direction,duration);
    }

    public void backwardSpeedValidate(KeyEvent ke) {
        Directions direction = Directions.BACKWARDS;
        speed = validate.textFieldCheck(backwardSpeed);
        validate.speed(direction,speed);
    }

    public void backwardDurationValidate(KeyEvent ke) {
        Directions direction = Directions.BACKWARDS;
        duration = validate.textFieldCheck(backwardDuration);
        validate.duration(direction,duration);
    }

    public void leftSpeedValidate(KeyEvent ke) {
        Directions direction = Directions.LEFT;
        speed = validate.textFieldCheck(leftSpeed);
        validate.speed(direction,speed);
    }

    public void leftDurationValidate(KeyEvent ke) {
        Directions direction = Directions.LEFT;
        duration = validate.textFieldCheck(leftDuration);
        validate.duration(direction,duration);
    }

    public void rightSpeedValidate(KeyEvent ke) {
        Directions direction = Directions.RIGHT;
        speed = validate.textFieldCheck(rightSpeed);
        validate.speed(direction,speed);
    }

    public void rightDurationValidate(KeyEvent ke) {
        Directions direction = Directions.RIGHT;
        duration = validate.textFieldCheck(rightDuration);
        validate.duration(direction,duration);
    }

    // GAMEPAD


}
