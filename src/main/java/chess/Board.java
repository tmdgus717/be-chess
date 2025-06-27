package chess;

import chess.pieces.Piece;

import chess.pieces.Piece.Color;
import chess.pieces.PieceFactory;
import chess.pieces.Position;
import chess.pieces.enums.Type;
import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int RANK_SIZE = 8;

    private final List<Rank> ranks = new ArrayList<>(RANK_SIZE);

    public void initialize() { // 중복 삭제
        for (int row = 0; row < RANK_SIZE; row++) {
            ranks.add(new Rank(row));
        }
    }

    public void initializeEmpty() {
        for (int row = 0; row < RANK_SIZE; row++) {
            ranks.add(new Rank());
        }
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public int countPieceBy(Color color, Type type) {
        int count = 0;

        for (Rank rank : ranks) {
            count += rank.countPieceBy(color, type);
        }

        return count;
    }

    public int countAllPieces() {
        int count = 0;

        for (Rank rank : ranks) {
            count += rank.countPieces();
        }

        return count;
    }

    public Piece findPiece(String positionString) {
        //a8 : a->col/ 8->row (1~8)
        Position position = new Position(positionString);

        Rank rank = findRank(position);
        return rank.getPiece(position);
    }

    public void move(String positionString, Piece piece) {
        Position position = new Position(positionString);

        Rank rank = findRank(position);
        rank.setPiece(position, piece);
    }

    public void move(String before, String after) {
        Position beforePos = new Position(before);

        Piece beforePiece = findRank(beforePos).getPiece(beforePos);
        move(after, beforePiece);
        move(before, PieceFactory.getInstance().createBlank());
    }

    private Rank findRank(Position position) {
        return ranks.get(position.getY());
    }
}
