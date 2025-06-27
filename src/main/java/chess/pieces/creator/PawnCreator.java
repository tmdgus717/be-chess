package chess.pieces.creator;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.enums.Type;

public class PawnCreator implements PieceCreator{

    @Override
    public Type getType() {
        return Type.PAWN;
    }

    @Override
    public Piece create(Color color) {
        return null;
    }
}
