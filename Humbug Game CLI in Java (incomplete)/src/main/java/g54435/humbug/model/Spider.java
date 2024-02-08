package g54435.humbug.model;

/**
 * Project projet-humbug
 * The spider moves in the direction
 * indicated as long as it does not encounter any obstacles.
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Spider extends Animal {

    /**
     * Constructor of Spider
     */
    public Spider() {
    }

    /**
     * Constructor of Spider
     *
     * @param positionOnBoard where is the Spider on the board
     */
    public Spider(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * The spider moves in the direction
     * indicated as long as it does not encounter any obstacles.
     *
     * @param board     board of the game
     * @param direction direction to move
     * @param animal    what animal on the board
     * @return the new position of the Spider
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {

        Position pos = moveOneCrawling(board, direction, animal);
        if (pos == null) {
            return null;
        }

        if (direction.equals(Direction.EAST) || direction.equals(Direction.WEST)) {
            for (int i = 0; i < board.getNbColumn(); i++) {
                pos = moveOneCrawling(board, direction, animal);
                if (pos == null) {
                    return null;
                }
            }
            checkFinalOnStar(board, pos);

        } else {
            for (int i = 0; i < board.getNbRow(); i++) {
                pos = moveOneCrawling(board, direction, animal);
                if (pos == null) {
                    return null;
                }
            }
            checkFinalOnStar(board, pos);
        }

        return pos;
    }


}


