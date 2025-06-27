package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;
import java.util.List;

public abstract class Piece {

    private final Color color;

    private final Type type;

    private final List<Direction> directions;

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

    public abstract boolean verifyMovePosition();

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

    @Override
    public boolean equals(Object o) {
        Piece piece = (Piece) o;
        return isSame(piece.color, piece.type);
    }
}
