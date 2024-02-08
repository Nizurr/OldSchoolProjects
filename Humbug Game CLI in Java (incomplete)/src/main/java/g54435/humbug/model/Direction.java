package g54435.humbug.model;

/**
 * Project projet-humbug
 * Direction of the animal.
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public enum Direction {

    NORTH(-1, 0),
    SOUTH(1, 0),
    EAST(0, 1),
    WEST(0, -1);
    /**
     * Attribute delta of Column
     */
    private int deltaColumn;

    /**
     * Attribute delta of Row
     */
    private int deltaRow;

    /**
     * Constructor of Direction, to have a direction, we use Points of the compass
     * each direction is defined by deltaColumn and DeltaRow.
     *
     * @param deltaColumn direction column ( south = 1, north -1)
     * @param deltaRow    direction column ( east = 1, west -1)
     */
    Direction(int deltaRow, int deltaColumn) {
        this.deltaColumn = deltaColumn;
        this.deltaRow = deltaRow;
    }

    /**
     * Accessor of DeltaColumn
     *
     * @return Column direction
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

    /**
     * Accessor of DeltaRow
     *
     * @return Row direction
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * Donne la direction opposée à une direction
     *
     * @return opposite direction
     */
    public Direction opposite() {
        switch (this) {
            case NORTH:
                return SOUTH;
            case WEST:
                return EAST;
            case EAST:
                return WEST;
            case SOUTH:
                return NORTH;
            default:
                throw new IllegalArgumentException("switch case not found");
        }
    }

}
