package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

import chess.pieces.Piece.Color;
import chess.pieces.PieceFactory;
import chess.pieces.enums.Type;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoardTest {

    Board board;
    ChessGame chessGame;
    ChessView chessView;

    PieceFactory pieceFactory;

    @BeforeEach
    public void setUp() {

        board = new Board();
        chessGame = new ChessGame(board);
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

        assertThat(board.findPiece("a8")).isEqualTo(pieceFactory.createBlack(Type.ROOK));
        assertThat(board.findPiece("h8")).isEqualTo(pieceFactory.createBlack(Type.ROOK));
        assertThat(board.findPiece("a1")).isEqualTo(pieceFactory.createWhite(Type.ROOK));
        assertThat(board.findPiece("h1")).isEqualTo(pieceFactory.createWhite(Type.ROOK));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = pieceFactory.createBlack(Type.ROOK);
        chessGame.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(chessView.showBoard());
    }


    @Test
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", pieceFactory.createBlack(Type.PAWN));
        addPiece("e6", pieceFactory.createBlack(Type.QUEEN));
        addPiece("b8", pieceFactory.createBlack(Type.KING));
        addPiece("c8", pieceFactory.createBlack(Type.ROOK));
        addPiece("f2", pieceFactory.createWhite(Type.PAWN)); //1
        addPiece("g2", pieceFactory.createWhite(Type.PAWN)); //1.5
        addPiece("g3", pieceFactory.createWhite(Type.PAWN)); //2
        addPiece("e1", pieceFactory.createWhite(Type.ROOK)); //7
        addPiece("f1", pieceFactory.createWhite(Type.KING)); //7

        assertThat(chessGame.calculatePoint(Color.BLACK)).isEqualTo(15.0);
        assertThat(chessGame.calculatePoint(Color.WHITE)).isEqualTo(7.0);

        System.out.println(chessView.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        chessGame.move(position, piece);
    }

    @Test
    public void move2() throws Exception {
        board.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        chessGame.move(sourcePosition, targetPosition);

        System.out.println(chessView.showBoard());

        assertThat(board.findPiece(sourcePosition)).isEqualTo(pieceFactory.createBlank());
        assertThat(board.findPiece(targetPosition)).isEqualTo(pieceFactory.createWhite(Type.PAWN));
    }
}
