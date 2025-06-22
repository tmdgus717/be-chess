package chess;

import chess.pieces.Piece;

import static utils.StringUtils.appendNewLine;

import chess.pieces.Piece.Color;
import chess.pieces.Piece.Type;
import chess.pieces.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoardTest {

    Board board;

    @BeforeEach
    public void setUp() {
        board = new Board();
    }

    @Test
    @DisplayName("보드 생성시 기물 갯수와 출력값 테스트")
    public void create() throws Exception {
        board.initialize();
        assertThat(board.countAllPieces()).isEqualTo(32);

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
        System.out.println(board.showBoard());
    }
}
