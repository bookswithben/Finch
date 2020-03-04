package sample;

public enum Directions {
    LEFT(new int[]{-200,200,1000}),
    RIGHT(new int[]{200,-200,1000}),
    FORWARD(new int[]{100,100,1000}),
    BACKWARDS(new int[]{-100,-100,1000});

    private final int[] turnSpeed;

    private Directions(int[] turnSpeed) {
        this.turnSpeed = turnSpeed;
    }

    public int[] getTurnSpeed() {
        return this.turnSpeed;
    }
}