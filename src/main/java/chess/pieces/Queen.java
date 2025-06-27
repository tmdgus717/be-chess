package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;

public class Queen extends Piece{

    public Queen(Color color) {
        super(color, Type.QUEEN, Direction.queensDirection());
    }

    @Override
    public boolean verifyMovePosition() {
        return false;
    }
}
