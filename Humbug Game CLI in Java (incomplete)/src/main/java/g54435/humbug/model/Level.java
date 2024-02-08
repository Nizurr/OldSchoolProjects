package g54435.humbug.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Project projet-humbug
 * A Level class that will be responsible for providing a level of game
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Level {
    private Board board;
    private Animal[] animals;
    private int nMoves;

    /**
     * Constructor of the level
     */
    public Level() {
    }

    /**
     * Constructor of the level.
     *
     * @param board   board of the game
     * @param animals animals on the board
     * @param nMoves  nombre number of possible moves on the level
     */
    private Level(Board board, Animal[] animals, int nMoves) {
        this.board = board;
        this.animals = animals;
        this.nMoves = nMoves;
    }

    /**
     * Getter of the level (board, animals et nmoves)
     *
     * @param lvl number of the level to get
     * @return Level a level
     */
    public static Level getLevel(int lvl) {
        return readLevel(lvl);
    }

    /**
     * Getter of the board on the level
     *
     * @return a board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Getter of animals on the level
     *
     * @return Animals
     */
    public Animal[] getAnimals() {
        return animals;
    }

    /**
     * Getter of possible moves on the level
     *
     * @return nMoves
     */
    public int getnMoves() {
        return nMoves;
    }

    /**
     * Import a level from JSON data.
     *
     * @param lvl level to import
     * @return a complete lvl (board, animals et nmoves)
     */
    private static Level readLevel(int lvl) {
        try {
            var objectMapper = new ObjectMapper();
            var inputStream = Level.class.getResourceAsStream(
                    "/data/level-" + lvl + ".json");
            var level = objectMapper.readValue(inputStream, Level.class);
            return level;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;

    }
}
