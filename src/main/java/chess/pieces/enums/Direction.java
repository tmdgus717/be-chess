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
    SOUTH_EAST(1,1),

    //knight
    KNIGHT_NORTH_WEST(-1,-2),
    KNIGHT_NORTH_EAST(1,-2),
    KNIGHT_WEST_NORTH(-2,-1),
    KNIGHT_WEST_SOUTH(-2,1),
    KNIGHT_SOUTH_WEST(-1,2),
    KNIGHT_SOUTH_EAST(1,2),
    KNIGHT_EAST_NORTH(2,-1),
    KNIGHT_EAST_SOUTH(2,1);

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

    public boolean isSame(int dx, int dy) {
        return this.xDegree == dx && this.yDegree == dy;
    }

    public static Direction findDirection(int x, int y) {
        int dx = Integer.compare(x, 0);
        int dy = Integer.compare(y, 0);
        for (Direction direction : Direction.values()) {
            if (direction.isSame(dx, dy)) {
                return direction;
            }
        }
        return null;
    }

    //초기화 메서드
    public static List<Direction> kingsDirection() {
        return List.of(NORTH_WEST, NORTH, NORTH_EAST, WEST, EAST, SOUTH, SOUTH_EAST, SOUTH_WEST);
    }

    public static List<Direction> queensDirection() {
        return List.of(NORTH_WEST, NORTH, NORTH_EAST, WEST, EAST, SOUTH, SOUTH_EAST, SOUTH_WEST);
    }

    public static List<Direction> rooksDirection() {
        return List.of(NORTH, WEST, EAST, SOUTH);
    }

    public static List<Direction> bishopsDirection() {
        return List.of(NORTH_WEST, NORTH_EAST, SOUTH_EAST, SOUTH_WEST);
    }

    public static List<Direction> knightsDirection() {
        return List.of(
            KNIGHT_NORTH_WEST, KNIGHT_NORTH_EAST,
            KNIGHT_WEST_NORTH, KNIGHT_WEST_SOUTH,
            KNIGHT_SOUTH_WEST, KNIGHT_SOUTH_EAST,
            KNIGHT_EAST_NORTH, KNIGHT_EAST_SOUTH
            );
    }

    public static List<Direction> pawnDirection(Color color) {
        if (color == Color.BLACK) {
            return blackPawnDirection();
        }
        return whitePawnDirection();
    }

    public static List<Direction> blackPawnDirection() {
        return List.of(SOUTH, SOUTH_WEST, SOUTH_EAST);
    }

    public static List<Direction> whitePawnDirection() {
        return List.of(NORTH, NORTH_WEST, NORTH_EAST);
    }
}
