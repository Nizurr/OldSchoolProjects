package g54435.humbug.model;

/**
 * Project projet-humbug
 * the bumbelbee fly two squares (even above the void).
 * If the box arrival is busy, it stops at the next one;
 * flying animals jump and fly over walls
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Bumbelbee extends Animal {


    /**
     * Constructor of Bumbelbee
     */
    public Bumbelbee() {
    }

    /**
     * Constructor of Bumbelbee
     *
     * @param positionOnBoard position of the bumbelbee
     */
    public Bumbelbee(Position positionOnBoard) {
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
        pos = moveOneJumpingOrFlying(board, direction, animal);

        pos = result(board, pos, direction, animal);
        return pos;
    }
}