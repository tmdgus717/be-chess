package chess.pieces;

import chess.pieces.enums.Direction;
import chess.pieces.enums.Type;
import java.util.List;

public class Blank extends Piece{

    public Blank(Color color) {
        super(color, Type.NO_PIECE, null);
    }

    @Override
    public boolean verifyMovePosition(Position curr, Position after) {
        return false;
    }
}
