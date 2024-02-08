package g54435.humbug.model;

/**
 * Project projet-humbug
 * the ladybird moves two squares and stops before if there is an obstacle
 * (a wall or other animal)
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Ladybird extends Animal {

    /**
     * Constructor Ladybird
     */
    public Ladybird() {
    }

    /**
     * Constructor of LadyBird
     *
     * @param positionOnBoard where is the Ladybird on the board
     */
    public Ladybird(Position positionOnBoard) {
        super(positionOnBoard);
    }

    /**
     * Move the animal, change its position. If it fall, null is returned
     *
     * @param board     board of the game
     * @param direction direction to move
     * @param animal    what animal on the board
     * @return new Position after moving. or null if he fall.
     */
    @Override
    public Position move(Board board, Direction direction, Animal... animal) {
        Position pos = moveOneCrawling(board, direction, animal);
        pos = moveOneCrawling(board, direction, animal);

        if (pos == null) {
            return null;
        }

        checkFinalOnStar(board, pos);
        return pos;
    }
}
