package chess.pieces.creator;

import chess.pieces.Piece;
import chess.pieces.Piece.Color;
import chess.pieces.Queen;
import chess.pieces.enums.Type;

public class QueenCreator implements PieceCreator{

    @Override
    public Type getType() {
        return Type.QUEEN;
    }

    @Override
    public Piece create(Color color) {
        return new Queen(color);
    }
}
