package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;

public class King extends Piece{

    public King(Color color) {
        super(color, Type.KING, Direction.kingsDirection());
    }

    @Override
    public boolean verifyMovePosition(Position curr, Position after) {
        int dx = after.getX() - curr.getX();// x축으로 얼마나 이동했는가
        int dy = after.getY() - curr.getY();// y축으로 얼마나 이동했는가?

        Position position = new Position(after.getX(), after.getY());

        if (!position.isInsideBoard() || Math.abs(dx) > 1 || Math.abs(dy) > 1) {
            return false;
        }

        return directions.stream()
            .anyMatch(direction -> direction.isSame(dx, dy));
    }
}
