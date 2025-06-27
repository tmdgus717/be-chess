package chess.pieces.enums;

import chess.pieces.Piece.Color;
import java.util.List;

public enum Direction{
    NORTH_WEST(-1,-1),
    NORTH(0,-1),
    NORTH_EAST(1,-1),
    WEST(-1,0),
    EAST(1,0),
    SOUTH_WEST(-1,1),
    SOUTH(0,1),
    SOUTH_EAST(1,1);

    //knight
    //

    private final int xDegree;
    private final int yDegree;

    Direction(int xDegree, int yDegree) {
        this.xDegree = xDegree;
        this.yDegree = yDegree;
    }

    public int getxDegree() {
        return xDegree;
    }

    public int getyDegree() {
        return yDegree;
    }

    public static List<Direction> kingsDirection() {
        return List.of(NORTH, NORTH, NORTH_EAST, WEST, EAST, SOUTH, SOUTH_EAST, SOUTH_WEST);
    }

    public static List<Direction> queensDirection() {
        return List.of();
    }

    public static List<Direction> rooksDirection() {
        return List.of();
    }

    public static List<Direction> bishopsDirection() {
        return List.of();
    }

    public static List<Direction> knightsDirection() {
        return List.of();
    }

    public static List<Direction> pawnDirection(Color color) {
        if (color == Color.BLACK) {
            return blackPawnDirection();
        }
        return whitePawnDirection();
    }

    public static List<Direction> blackPawnDirection() {
        return List.of();
    }

    public static List<Direction> whitePawnDirection() {
        return List.of();
    }
}
