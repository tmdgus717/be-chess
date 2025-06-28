package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;

public class Knight extends Piece{

    public Knight(Color color) {
        super(color, Type.KNIGHT, Direction.knightsDirection());
    }

    @Override
    public boolean verifyMovePosition(Position curr, Position after) {
        int dx = after.getX() - curr.getX();// x축으로 얼마나 이동했는가
        int dy = after.getY() - curr.getY();// y축으로 얼마나 이동했는가?

        return directions.stream()
            .anyMatch(direction -> direction.isSame(dx, dy));
    }
}
