package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;

public class Pawn extends Piece{

    public Pawn(Color color) {
        super(color, Type.PAWN, Direction.pawnDirection(color));
    }

    @Override
    public boolean verifyMovePosition(Position curr, Position after) {
        int dx = after.getX() - curr.getX();
        int dy = after.getY() - curr.getY();

        System.out.println(dx);
        System.out.println(Math.abs(dy));
        Position position = new Position(after.getX(), after.getY());

        if (!position.isInsideBoard() || Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            System.out.println("??");
            return false;
        }

        return directions.stream().anyMatch(direction -> direction.isSame(dx, dy));
    }
}
