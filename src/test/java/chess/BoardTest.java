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

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 생성시 기물 갯수와 출력값 테스트")
    void create() throws Exception {
        board.initialize();
        assertThat(board.pieceCount()).isEqualTo(32);

        String blankRank = appendNewLine("........");
        assertThat(board.showBoard()).isEqualTo(
            appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr"));
    }

    @Test
    @DisplayName("검정 폰과 흰색 폰이 8개씩 올바르게 생성되었는지 확인")
    void initialize() throws Exception {
        board.initialize();
        assertThat(board.getWhitePawnsResult()).isEqualTo("pppppppp");
        assertThat(board.getBlackPawnsResult()).isEqualTo("PPPPPPPP");
    }

    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환")
    void countPiecesTest() throws Exception{
        board.initialize();
        assertThat(board.countPieces(Color.WHITE, Type.PAWN)).isEqualTo(8);
        assertThat(board.countPieces(Color.BLACK, Type.KING)).isEqualTo(1);
    }

    @Test
    @DisplayName("입력한 위치에 존재하는 기물 반환")
    public void findPiece() throws Exception {
        board.initialize();

        assertThat(Piece.createBlackRook()).isEqualTo(board.findPiece("a8"));
        assertThat(Piece.createBlackRook()).isEqualTo(board.findPiece("h8"));
        assertThat(Piece.createWhiteRook()).isEqualTo(board.findPiece("a1"));
        assertThat(Piece.createWhiteRook()).isEqualTo(board.findPiece("h1"));
    }

    @Test
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertThat(board.findPiece(position)).isEqualTo(piece);
        System.out.println(board.showBoard());
    }

}