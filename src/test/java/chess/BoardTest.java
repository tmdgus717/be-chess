package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoardTest {

    Board board;
    ChessView chessView;

    @BeforeEach
    public void setUp() {

        board = new Board();
        chessView = new ChessView(board);
    }

    @Test
    @DisplayName("보드 생성시 기물 갯수와 출력값 테스트")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.countAllPieces()).isEqualTo(32);

        String blankRank = appendNewLine("........");
        assertThat(chessView.showBoard()).isEqualTo(
            appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("검정 폰과 흰색 폰이 8개씩 올바르게 생성되었는지 확인")
    public void initialize() throws Exception {
        board.initialize();

        assertThat(board.countPieceBy(Color.BLACK, Type.PAWN)).isEqualTo(8);
        assertThat(board.countPieceBy(Color.WHITE, Type.PAWN)).isEqualTo(8);
    }

    @Test
    public void findPiece() throws Exception {
        board.initialize();

        assertThat(board.findPiece("a8")).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(board.findPiece("h8")).isEqualTo(Piece.createBlack(Type.ROOK));
        assertThat(board.findPiece("a1")).isEqualTo(Piece.createWhite(Type.ROOK));
        assertThat(board.findPiece("h1")).isEqualTo(Piece.createWhite(Type.ROOK));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlack(Type.ROOK);
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(chessView.showBoard());
    }


    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlack(Type.PAWN));
        addPiece("e6", Piece.createBlack(Type.QUEEN));
        addPiece("b8", Piece.createBlack(Type.KING));
        addPiece("c8", Piece.createBlack(Type.ROOK));

        addPiece("f2", Piece.createWhite(Type.PAWN)); //1
        addPiece("g2", Piece.createWhite(Type.PAWN)); //1.5
        addPiece("g3", Piece.createWhite(Type.PAWN)); //2
        addPiece("e1", Piece.createWhite(Type.ROOK)); //7
        addPiece("f1", Piece.createWhite(Type.KING)); //7

        assertThat(board.calculatePoint(Color.BLACK)).isEqualTo(15.0);
        assertThat(board.calculatePoint(Color.WHITE)).isEqualTo(7.0);

        System.out.println(chessView.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    public void move2() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        board.move(sourcePosition, targetPosition);

        System.out.println(chessView.showBoard());

        assertThat(board.findPiece(sourcePosition)).isEqualTo(Piece.createBlank());
        assertThat(board.findPiece(targetPosition)).isEqualTo(Piece.createWhite(Type.PAWN));
    }
}
