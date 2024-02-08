package g54435.humbug.model;

/**
 * Project projet-humbug
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 * <p>
 * Square on the board. A square has a type grass or star and it's all.
 * A square doesn't know where it is on the board
 */
public class Square {
    /**
     * Type of Square
     */
    private SquareType type;

    /**
     * NorthWall
     */
    private boolean northWall;
    /**
     * southWall
     */
    private boolean southWall;
    /**
     * westWall
     */
    private boolean westWall;
    /**
     * eastWall
     */
    private boolean eastWall;

    /**
     * Setter of northWall.
     * Add a wall to the square
     * @param northWall Attribute northWall of the square
     */
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }
    /**
     * Setter of southWall.
     * Add a wall to the square
     * @param southWall Attribute southWall of the square
     */
    public void setSouthWall(boolean southWall) {
        this.southWall = southWall;
    }

    /**
     * Setter of westWall.
     * Add a wall to the square
     * @param westWall Attribute westWall of the square
     */
    public void setWestWall(boolean westWall) {
        this.westWall = westWall;
    }
    /**
     * Setter of eastWall.
     * Add a wall to the square
     * @param eastWall Attribute eastWall of the square
     */
    public void setEastWall(boolean eastWall) {
        this.eastWall = eastWall;
    }

    public Square() {
    }

    /**
     * Constructor of Square on board
     *
     * @param type type is grass or star
     */
    public Square(SquareType type) {
        this.type = type;
        this.eastWall = false;
        this.northWall = false;
        this.southWall = false;
        this.westWall = false;
    }

    /**
     * Getter of type
     *
     * @return type of square
     */
    public SquareType getType() {
        return type;
    }

    /**
     * A setter of the type
     *
     * @param type type to set
     */
    public void setType(SquareType type) {
        this.type = type;
    }

    /**
     * Précise si il y a un mur dans la direction donnée
     * @param dir direction
     * @return a boolean
     */
    public boolean hasWall(Direction dir) {
        boolean res;
        switch (dir) {
            case EAST:
                res = eastWall;
                break;
            case WEST:
                res = westWall;
                break;
            case NORTH:
                res = northWall;
                break;
            case SOUTH:
                res = southWall;
                break;
            default:
                throw new IllegalArgumentException("bad direction");
        }
        return res;
    }

}