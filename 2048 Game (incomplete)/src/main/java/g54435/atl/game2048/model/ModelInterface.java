package g54435.atl.game2048.model;

/**
 * Interface model used in the Game class
 */
public interface ModelInterface {
    /**
     * @return the board
     */
    Board getBoard();

    /**
     * Principal methode, move each piece in the direction gived
     *
     * @param dir direction to move
     * @return a boolean : true if not one piece moved
     */
    boolean move(Direction dir);

    /**
     * @return the actual score
     */
    int getScore();

    /**
     * @return actual LevelStatus
     */
    LevelStatus getLevelStatus();

    /**
     * Setter of the levelStatus
     *
     * @param levelStatus levelstatus to set
     */
    void setLevelStatus(LevelStatus levelStatus);

    /**
     * Check if the game is end with the boolean gived by move()
     *
     * @param sameGrid a boolean : true if not one piece was moved
     */
    void checkStatusAndEnd(boolean sameGrid);

    /**
     * clean the grid for restarting the game
     */
    void cleanGrid();
}
