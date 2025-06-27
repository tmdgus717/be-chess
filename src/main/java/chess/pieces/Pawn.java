package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;
import java.util.List;

public class Pawn extends Piece{

    public Pawn(Color color) {
        super(color, Type.PAWN, Direction.pawnDirection(color));
    }

    @Override
    public boolean verifyMovePosition() {
        return false;
    }
}
