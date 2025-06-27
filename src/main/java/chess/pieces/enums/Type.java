package chess.pieces.enums;

public enum Type {
    PAWN('p', 1),
    ROOK('r', 5),

    KNIGHT('n', 2.5),
    BISHOP('b', 3),

    QUEEN('q', 9),
    KING('k', 0),
    NO_PIECE('.', 0);

    private char representation;
    private double score;

    Type(char representation, double score) {
        this.representation = representation;
        this.score = score;
    }

    public char getWhiteRepresentation() {
        return this.representation;
    }

    public char getBlackRepresentation() {
        return Character.toUpperCase(this.representation);
    }

    public double getScore() {
        return score;
    }
}
