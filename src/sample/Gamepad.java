package sample;

import com.studiohartman.jamepad.*;
import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Gamepad {

    // Notes: Square is x
    //        Triangle is y
    //        Circle is B
    //        Cross is A

    //        LB is L1
    //        Left Trigger is L1

    //        RB is R1
    //        Right Trigger is R1



    private final ControllerManager controller;

    public Gamepad() {
        controller = new ControllerManager();
        controller.initSDLGamepad();
    }

    public boolean isConnected() {
        ControllerState currState = controller.getState(0);
        return currState.isConnected;
    }

    public void move(Finch keith) throws InterruptedException {

        Directions move = Directions.FORWARD;
        boolean yeehaw = true;
        while (yeehaw) {
            ControllerState currState = controller.getState(0);

            // Right Buttons
            if (currState.a) {
                System.out.println("\"A\" on \"" + currState.controllerType + "\" is pressed");
                Thread.sleep(400);
                System.out.println("END");
            }
            if (currState.b) {
                System.out.println("\"B\" on \"" + currState.controllerType + "\" is pressed");
                Thread.sleep(400);
                System.out.println("END");
            }
            if (currState.y) {
                System.out.println("\"Y\" on \"" + currState.controllerType + "\" is pressed");
                Thread.sleep(400);
                System.out.println("END");
            }

            // Top Button
            if (currState.lb || currState.rb) {
                yeehaw = false;
                System.out.println("QUIT");
                Thread.sleep(400);
                System.out.println("END");
            }



            // Left Pad
            if (currState.dpadLeft) {
                //FinchPrototype.move(Directions.LEFT,200,4);
                Thread.sleep(400);
                System.out.println("END");
            }
            if (currState.dpadRight) {
                //FinchPrototype.move(Directions.RIGHT,200,4);
                Thread.sleep(400);
                System.out.println("END");
            }
            if (currState.dpadUp) {
                //FinchPrototype.move(Directions.FORWARD,200,4);
                Thread.sleep(400);
                System.out.println("END");
            }
            if (currState.dpadDown) {
                //FinchPrototype.move(Directions.BACKWARDS,200,4);
                Thread.sleep(400);
                System.out.println("END");
            }

            int triggerR = Math.round(currState.rightTrigger * 200);
            int stickL = Math.round(currState.leftStickMagnitude * -200);
            int stickR = Math.round(currState.rightStickMagnitude * -200);
            int triggerL = Math.round(currState.leftTrigger * 200);
            if (triggerR > 10 || stickL < -10 || triggerL > -10 || stickR < -10 ) {
                //int total = triggerR + stickL + triggerL;
//                System.out.println("Total"+total);
//                System.out.println("Right"+triggerR);
//                System.out.println("Left"+stickL);
                // FinchPrototype.move(Directions.FORWARD, total, 1);
//                if (triggerR > 10) {
//                    keith.setWheelVelocities(stickL, triggerR, 1);
//                }
//                if (triggerL < -10) {
//                    keith.setWheelVelocities(triggerL, stickL, 1);
//                }



                if (triggerL > 10 || triggerR > 10) {
                    keith.setWheelVelocities(triggerL, triggerR, 1);
                }

                if (stickL < -10 || stickR < -10) {
                    keith.setWheelVelocities(stickL, stickR, 1);
                }
            }

            //System.out.println(Math.round(currState.rightStickMagnitude * 100.0));
            //System.out.println(Math.round(currState.leftStickAngle * 100) / 100);
            // System.out.println(Math.round(currState.rightTrigger * 200));
            //System.out.println(Math.round(currState.leftStickX * 100.0));


        }
    }

    public void disconnect() {
        controller.quitSDLGamepad();
    }

}
