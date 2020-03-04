package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Retracing {
    private ArrayList<Object> retracingArray = new ArrayList<Object> ();
    Movement move = new Movement();

    public ArrayList<Object> getRetracingArray() {
        return retracingArray;
    }

    public int getRetracingArrayLength () {
        return retracingArray.size();
    }

    public void addRetracing(Directions direction, int speed, int seconds) {
        char directionChar = ' ';

        switch (direction) {
            case BACKWARDS:
                directionChar = 'B';
                break;
            case RIGHT:
                directionChar = 'R';
                break;
            case LEFT:
                directionChar = 'L';
                break;
            case FORWARD:
                directionChar = 'F';
                break;
        }

        Object[] localCommand = new Object[]{directionChar,speed,seconds};

        retracingArray.add(localCommand);
    }

    public void use(int steps) {

        for (int i = retracingArray.size(); i > steps; i--) {
           Object[] localCommand = (Object[]) retracingArray.get(0);
           String localCommandArray = Arrays.toString(localCommand);
           String[] command = localCommandArray.replace("[","").replace("]","").replace(",","").split(" ");

           String directionChar = command[0];
           int speed = Integer.parseInt(command[1]);
           int duration = Integer.parseInt(command[1]);
           Directions direction;
            switch (directionChar) {
                case "B":
                    direction = Directions.BACKWARDS;
                    break;
                case "R":
                    direction = Directions.RIGHT;
                    break;
                case "L":
                    direction = Directions.LEFT;
                    break;
                case "F":
                    direction = Directions.FORWARD;
                    break;
                default:
                    direction = Directions.FORWARD;
            }

            move.move(direction, speed, duration);
        }

    }
}
