package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color, Type.BISHOP, Direction.bishopsDirection());
    }

    @Override
    public boolean verifyMovePosition() {
        return false;
    }
}
