package chess;

import static utils.StringUtils.appendNewLine;

import chess.pieces.Piece;

public class ChessView {

    private final Board board;

    public ChessView(Board board) {
        this.board = board;
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
        for (Rank rank : board.getRanks()) {
            stringBuilder.append(appendNewLine(makeRepresentations(rank)));
        }
        return String.valueOf(stringBuilder);
    }
}
