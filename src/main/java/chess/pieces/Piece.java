package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;
import java.util.List;

public abstract class Piece {

    protected final Color color;

    protected final Type type;

    protected final List<Direction> directions;

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public Piece(Color color, Type type, List<Direction> directions) {
        this.color = color;
        this.type = type;
        this.directions = directions;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    public abstract boolean verifyMovePosition(Position curr, Position after);

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isWhite() {
        return this.color == Color.WHITE;
    }

    public Double getPoint() {
        return this.type.getScore();
    }

    public boolean isSame(Color color, Type type) {
        if (this.color == color && this.type == type) {
            return true;
        }
        return false;
    }

    protected boolean canMove(Position curr, Position after) {
        int dx = after.getX() - curr.getX();// x축으로 얼마나 이동했는가
        int dy = after.getY() - curr.getY();// y축으로 얼마나 이동했는가?

        System.out.println(after.getX());
        System.out.println(after.getY());

        Direction direction = Direction.findDirection(dx, dy);
        System.out.println(direction);
        Position position = new Position(curr.getX(), curr.getY());

        while (position.isInsideBoard()){
            System.out.println("while");
            position.update(direction);
            if (position.equals(after)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object o) {
        Piece piece = (Piece) o;
        return isSame(piece.color, piece.type);
    }
}
