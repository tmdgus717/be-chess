package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import chess.pieces.Position;
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

    private String makeRepresentations(Rank rank) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Piece piece : rank.getPieces()) {
            if (piece.isBlack()){
                stringBuilder.append(piece.getType().getBlackRepresentation());
            }else {
                stringBuilder.append(piece.getType().getWhiteRepresentation());
            }
        }
        return String.valueOf(stringBuilder);
    }

    public String showBoard() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Rank rank : ranks) {
            stringBuilder.append(appendNewLine(makeRepresentations(rank)));
        }
        return String.valueOf(stringBuilder);
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

        return ranks.get(position.getY()).getPiece(position.getX());
    }

    public void move(String positionString, Piece piece) {
        Position position = new Position(positionString);

        ranks.get(position.getY()).setPiece(position.getX(), piece);
    }

    public void move(String before, String after) {

    }

    public Double calculatePoint(Color color) {
        double point = 0;
        for (Rank rank : ranks) {
            point += rank.calculatePointBy(color);
        }

        point = calculatePointDetail(point, color);

        return point;
    }

    private double calculatePointDetail(double point, Color color) {

        for (int i = 0; i < 8; i++) {
            int count = 0;
            for (Rank rank : ranks) {
                Piece piece = rank.getPiece(i);
                if (piece.isSame(color, Type.PAWN)) {
                    count++;
                }
            }

            if (count >= 2) {
                double pawnPoint = Type.PAWN.getScore() * count;
                pawnPoint /= 2;
                point -= pawnPoint;
            }
        }

        return point;
    }
}
