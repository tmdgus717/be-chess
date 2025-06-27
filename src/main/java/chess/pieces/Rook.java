package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;

public class Rook extends Piece{

    public Rook(Color color) {
        super(color, Type.ROOK, Direction.rooksDirection());
    }

    @Override
    public boolean verifyMovePosition() {
        return false;
    }
}
