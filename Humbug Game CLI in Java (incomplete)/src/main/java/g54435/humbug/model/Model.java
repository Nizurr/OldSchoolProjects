package g54435.humbug.model;

/**
 * Project projet-humbug
 *  The Model interface defines the methods
 *  that must implement the Game class.
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public interface Model {

    /**
     * Getter of the board
     *
     * @return a board
     */
    Board getBoard();

    /**
     * Getter of animals
     *
     * @return animal on the board
     */
    Animal[] getAnimals();

    int getRemainingMoves();

    /**
     * starts the game board and the animals for this first level
     *
     * @param level level of the game
     */
    void startLevel(int level);

    /**
     * Getter of the LevelStatus
     * @return status of the level
     */
    LevelStatus getLevelStatus();

    /**
     * Initialize the move of animal
     *
     * @param position  position of the animal choosed
     * @param direction direction choosed
     */
    void move(Position position, Direction direction);


}
