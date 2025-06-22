package chess;

import chess.pieces.Piece;
import java.util.ArrayList;
import java.util.List;

public class Rank {

    private final List<Piece> rank = new ArrayList<>();

    public Rank(List<Piece> pieces) {
        rank.addAll(pieces);
    }

    public List<Piece> getRank() {
        return rank;
    }

    public int size() {
        return rank.size();
    }

    public Piece getPiece(int index) {
        return rank.get(index);
    }
}
