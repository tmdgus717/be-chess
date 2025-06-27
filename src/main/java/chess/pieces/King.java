package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;

public class King extends Piece{

    public King(Color color) {
        super(color, Type.KING, Direction.kingsDirection());
    }

    @Override
    public boolean verifyMovePosition() {
        return false;
    }
}
