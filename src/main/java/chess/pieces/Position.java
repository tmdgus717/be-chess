package chess.pieces;

import chess.pieces.enums.Direction;

public class Position {
    private int x;
    private int y;

    public Position(String position) {
        var x = position.charAt(0) - 'a';
        // 8 -> 0
        // 1 -> 7
        var y = '8' - position.charAt(1);
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isInsideBoard() {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update(Direction direction) {
        this.x += direction.getxDegree();
        this.y += direction.getyDegree();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Position position = (Position) o;

        if (x != position.x) {
            return false;
        }
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
