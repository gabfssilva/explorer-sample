package br.com.explorer.sample.model;

/**
 * @author Gabriel Francisco - gabfssilva@gmail.com
 */
public enum  Direction {
    N("north", 0, 1), S("south", 0, -1), W("west", -1, 0), E("east", 1, 0);

    private final String description;
    private final int movementXValue;
    private final int movementYValue;
    private Direction rightDirection;
    private Direction leftDirection;

    static {
        N.rightDirection = Direction.E;
        N.leftDirection = Direction.W;

        S.rightDirection = Direction.W;
        S.leftDirection = Direction.E;

        W.rightDirection = Direction.N;
        W.leftDirection = Direction.S;

        E.rightDirection = Direction.S;
        E.leftDirection = Direction.N;
    }

    Direction(String description, int movementXValue, int movementYValue) {
        this.description = description;
        this.movementXValue = movementXValue;
        this.movementYValue = movementYValue;
    }

    public int getMovementXValue() {
        return movementXValue;
    }

    public int getMovementYValue() {
        return movementYValue;
    }

    public String getDescription() {
        return description;
    }

    public Direction getRightDirection() {
        return rightDirection;
    }

    public Direction getLeftDirection() {
        return leftDirection;
    }
}
