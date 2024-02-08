package g54435.humbug.model;


/**
 * Project projet-humbug
 * Represent the board of the game
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Board {


    private Square[][] squares;

    public Board() {
    }

    /**
     * Constructor of the plate
     *
     * @param squares level
     */
    public Board(Square[][] squares) { // SI TEST ALORS METTRE PUBLIC
        this.squares = squares;

    }

    /**
     * first level of the plate
     *
     * @return a plate of the level
     */
    public static Board getInitalBoard() {

        Square[][] sqr = new Square[][]{
                {new Square(SquareType.GRASS), new Square(SquareType.GRASS), null}, //Ligne 1
                {null, new Square(SquareType.GRASS), new Square(SquareType.GRASS)}, //Ligne 2
                {null, null, new Square(SquareType.STAR)}}; //Ligne 3
        Board board = new Board(sqr);

        return board;
    }

    /**
     * Say if the current box is a square of the game
     *
     * @param pos position on the board
     * @return boolean true if pos is on the board
     */
    public boolean isInside(Position pos) {
        if (pos == null) {
            throw new IllegalArgumentException("pos null");
        } else if (pos.getRow() < 0 || pos.getRow() >= getNbRow()) {
            return false;
        } else if (pos.getColumn() < 0 || pos.getColumn() >= getNbColumn()) {
            return false;
        } else if (squares[pos.getRow()][pos.getColumn()] == null) {
            return false;
        } else return true;

    }

    /**
     * Say the type of square.
     *
     * @param pos position on the board
     * @return type of Square
     */
    public SquareType getSquareType(Position pos) {

        if (!isInside(pos)) {
            throw new IllegalArgumentException("out-of-the-game position");
        } else {
            return squares[pos.getRow()][pos.getColumn()].getType();
        }

    }

    /**
     * Remove the star of the square
     *
     * @param pos pos of the square to remove star
     */
    public void removeStar(Position pos) {
        if (getSquareType(pos) != SquareType.STAR) {
            throw new IllegalArgumentException("You are trying to remove a star from a grass star");
        } else {
            int col = pos.getColumn();
            int row = pos.getRow();

            this.squares[row][col].setType(SquareType.GRASS);
        }
    }

    /**
     * Say the number of row on the board
     *
     * @return int of row
     */
    public int getNbRow() {
        return squares.length;

    }

    /**
     * Say number of column on the board
     *
     * @return int of column
     */
    public int getNbColumn() {
        return squares[0].length;

    }

    /**
     * Getter of a specific square of the baord
     * @return a square
     */
    public Square[][] getSquares() {
        return squares;
    }

}
