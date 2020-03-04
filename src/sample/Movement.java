package sample;

import edu.cmu.ri.createlab.terk.robot.finch.Finch;

public class Movement {

    public void move (Directions direction, int speed, int duration) {

        int ms;
        Validation validate = new Validation();
        speed = validate.speed(direction,speed);
        ms = validate.duration(direction,duration);

        switch (direction) {
            case FORWARD: case BACKWARDS:
//                finch.setWheelVelocities(speed,speed,ms);
                System.out.println("FINCH TURN " + direction + " Left Wheel " + speed + " Right Wheel " + speed + " For " + ms);
                break;
            case LEFT: case RIGHT:
                //  turn(direction,finch);
                 turn(direction);
                // finch.setWheelVelocities(speed,speed,ms);
                System.out.println("FINCH TURN " + direction + " Left Wheel " + speed + " Right Wheel " + speed + " For " + ms);
                break;
        }
    }

    public void turn(Directions direction) {
        int[] turnSpeed = direction.getTurnSpeed();
        int turnL = turnSpeed[0];
        int turnR = turnSpeed[1];
        int turnS = turnSpeed[2];
        //finch.setWheelVelocities(turnL,turnR,turnS);
        System.out.println("FINCH TURN " + direction + " Left Wheel " + turnL + " Right Wheel " + turnR + " For " + turnS);
    }

}
