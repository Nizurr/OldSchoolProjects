package g54435.humbug.model;

/**
 * Project projet-humbug
 * The snail moves one square in the
 * direction indicated on the condition that the square is not occupied by another
 * Animal.
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Snail extends Animal {

    /**
     * Constructor of Snail
     */
    public Snail() {
    }

    /**
     * Constructor of Snail
     *
     * @param positionOnBoard position on the board
     */
    public Snail(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * The movement of the snail on the tray, it moves case by case
     *
     * @param board     board of the game
     * @param direction direction to move
     * @param animal    what animal on the board
     * @return new position of the snail after moving
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {

        Position pos = moveOneCrawling(board, direction, animal);


        if (pos == null) {
            return null;
        }
        checkFinalOnStar(board, pos);
        return pos;
    }
}
