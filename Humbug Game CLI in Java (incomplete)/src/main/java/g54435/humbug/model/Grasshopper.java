package g54435.humbug.model;

/**
 * Project projet-humbug
 * the grasshopper jumps up to the next free square by bouncing
 * other animals that may be in its path.
 * Jumping animals jump and fly over walls;
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Grasshopper extends Animal {

    /**
     * Constructor of GrassHopper
     */
    public Grasshopper() {
    }

    /**
     * Constructor of GrassHopper
     *
     * @param positionOnBoard position of the animal.
     */
    public Grasshopper(Position positionOnBoard) {
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
        Position pos = moveOneJumpingOrFlying(board, direction, animal);
        pos = result(board, pos, direction, animal);

        return pos;

    }
}