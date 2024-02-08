package g54435.humbug.model;


/**
 * Project projet-humbug
 * The Game class brings together the elements needed for the game
 * to present a façade to the view
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Game implements Model {
    /**
     * Board of the game
     */
    private Board board;
    /**
     * Animals on board
     */
    private Animal[] animals;

    /**
     * Actual remaingingMoves
     */
    private int remainingMoves;

    /**
     * Actual number of the level
     */
    private int currentLevel;

    /**
     * Level status of the party
     */
    private LevelStatus levelStatus;

    /**
     * Getter of the board
     *
     * @return a board
     */
    @Override
    public Board getBoard() {
        return this.board;

    }


    /**
     * Getter of the currentLevel
     * @return a int of the level number
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * Getter of animals
     *
     * @return animal on the board
     */
    @Override
    public Animal[] getAnimals() {
        return this.animals;
    }

    /**
     * Getter of remainingMoves
     *
     * @return int remainingMoves
     */
    @Override
    public int getRemainingMoves() {
        return this.remainingMoves;
    }

    /**
     * Getter of levelStatus
     *
     * @return
     */
    @Override
    public LevelStatus getLevelStatus() {
        return this.levelStatus;
    }


    /**
     * Initialize the game board and the animals for indicated level
     *
     * @param level level of the game
     */
    @Override
    public void startLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level inferieur à 1");
        } else {
            this.levelStatus = LevelStatus.NOT_STARTED;
            Level.getLevel(level);
            this.currentLevel = level;
            this.board = Level.getLevel(level).getBoard();
            this.animals = Level.getLevel(level).getAnimals();
            this.remainingMoves = Level.getLevel(level).getnMoves();

        }

    }

    /**
     * Initialize the move of animal
     *
     * @param position  position of the animal choosed
     * @param direction direction choosed
     */
    @Override
    public void move(Position position, Direction direction) {
        if (position == null) {
            throw new IllegalArgumentException("Null Position");
        } else if (direction == null) {
            throw new IllegalArgumentException("Null Direction");
        }

        this.levelStatus = LevelStatus.IN_PROGRESSS;
        int animalNum = 0;
        for (Animal animal : animals) {
            if (position.equals(animal.getPositionOnBoard())) {
                break;
            } else {
                animalNum++;
            }

        }
        if (animalNum == animals.length) {
            throw new IllegalArgumentException("invalid position (You didn't choose an animal)");
        } else if (animalNum < animals.length) {
            Position pos = animals[animalNum].move(board, direction, animals);
            if (pos.equals(position)) {//si l'animal n'a pas réussi à bouger alors il ne perds pas de remainingmoves
                this.remainingMoves++;
            }
            this.remainingMoves--;
            this.levelStatus = udpateStatus(pos, animals);


        }


    }

    /**
     * Update the levelStatus
     *
     * @param pos     pos returned by move
     * @param animals animals on board
     */
    private LevelStatus udpateStatus(Position pos, Animal[] animals) {
        int isOnStar = 0;

        for (Animal animal : animals) { //Double foreach pour le break
            if (animal.isOnStar()) {
                isOnStar++;
            }
            if (!animal.isOnStar() && animal.getPositionOnBoard() == null) {
                //un animal qui est null et qui n'est pas sur onStar est tombé.
                return LevelStatus.FAIL;
            }
            if (isOnStar == animals.length) {
                return LevelStatus.WIN;
            }
            if (animal.getPositionOnBoard() == null && animal.isOnStar()) {
                continue;//ignore l'animal null
            } else if (!this.board.isInside(animal.getPositionOnBoard())) {
                return LevelStatus.FAIL;
            } else if (this.remainingMoves == 0) {
                return LevelStatus.FAIL;
            }
        }
                return LevelStatus.IN_PROGRESSS;
    }

}
