package g54435.humbug.model;

import com.fasterxml.jackson.annotation.*;

/**
 * Project projet-humbug
 * <p>
 * Represent a animal on the board
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Bumbelbee.class),
        @JsonSubTypes.Type(value = Grasshopper.class),
        @JsonSubTypes.Type(value = Ladybird.class),
        @JsonSubTypes.Type(value = Snail.class),
        @JsonSubTypes.Type(value = Spider.class),
})
public abstract class Animal {
    /**
     * represents the position of the animal on the game board
     */
    private Position positionOnBoard;

    /**
     * Says if the animal is on a star box
     */
    private boolean onStar;

    /**
     * Constructor of Animal
     */
    public Animal() {
    }

    /**
     * Constructor of Animal, onStar are initialized on false
     *
     * @param positionOnBoard pos on board
     */
    public Animal(Position positionOnBoard) {

        this.positionOnBoard = positionOnBoard;
        this.onStar = false;
    }

    /**
     * Getter of positionOnBoard
     *
     * @return a Position
     */
    public Position getPositionOnBoard() {
        return positionOnBoard;
    }

    /**
     * Setter of PositionOnBoard
     *
     * @param positionOnBoard Position to set
     */
    public void setPositionOnBoard(Position positionOnBoard) {
        this.positionOnBoard = positionOnBoard;
    }

    /**
     * Setter ofOnStar
     *
     * @param onStar true if the animal isOnStar
     */
    public void setOnStar(boolean onStar) {
        this.onStar = onStar;
    }

    /**
     * Getter of onStar
     *
     * @return true if the animal is on star
     */
    public boolean isOnStar() {
        return onStar;
    }

    /**
     * Move the animal, change its position. If it fall, null is returned
     *
     * @param board     board of the game
     * @param direction direction to move
     * @param animal    what animal on the board
     * @return new Position after moving. or null if he fall.
     */
    public abstract Position move(Board board, Direction direction, Animal... animal);

    /**
     * Move the animal, change its position.
     * moveOneCrawling is used by snails, ladybirds and spider
     *
     * @param board     board of the game
     * @param direction direction to move
     * @param animal    what animal on the board
     * @return new Position after moving
     */
    protected Position moveOneCrawling(Board board, Direction direction, Animal... animal) {
        if (getPositionOnBoard().equals(!board.isInside(getPositionOnBoard())) || getPositionOnBoard() == null) {
            return null;
        }
        boolean isOccupedByAnimal;
        boolean isOccupedByAnimalOnStar;
        boolean isOccupedByWall;
        boolean isOccupedByNextWall;
        Position nextPos = getPositionOnBoard().next(direction);

        for (Animal animalonboard : animal) {//chaque animals
            if (animalonboard.getPositionOnBoard() == null) {
                continue;//ignore l'animal null
            }
            isOccupedByAnimal = nextPos.equals(animalonboard.getPositionOnBoard());
            isOccupedByAnimalOnStar = nextPos.equals(animalonboard.isOnStar());
            int posAnimalRow = animalonboard.getPositionOnBoard().getRow();
            int posAnimalCol = animalonboard.getPositionOnBoard().getColumn();
            isOccupedByWall = board.getSquares()[posAnimalRow][posAnimalCol].hasWall(direction);


            if (animalonboard.getPositionOnBoard().equals(getPositionOnBoard())) { //animal choisi
                if (animalonboard.isOnStar()) {
                    return getPositionOnBoard();
                }
                if (board.isInside(nextPos)) {
                    isOccupedByNextWall = board.getSquares()[nextPos.getRow()][nextPos.getColumn()].hasWall(direction.opposite());
                    if (isOccupedByNextWall || isOccupedByWall) {
                        return getPositionOnBoard();
                    }
                } else {
                    if (isOccupedByWall) {
                        return getPositionOnBoard();
                    } else if (!board.isInside(nextPos)) {
                        setPositionOnBoard(null);
                        return null;
                    }

                }

            }
            if (isOccupedByAnimal) {
                if (animalonboard.isOnStar()) {
                    break;
                } else {
                    return getPositionOnBoard();
                }
            }
        }
        setPositionOnBoard(nextPos);
        return getPositionOnBoard();
    }

    /**
     * Move the animal, change its position
     * MoveOneJumping is used by GrassHopper
     * MoveOneFlying is used by Bumbelbee and Butterfly
     *
     * @param board     board of the game
     * @param direction direction to move
     * @param animal    what animal on the board
     * @return new Position after moving.
     */
    protected Position moveOneJumpingOrFlying(Board board, Direction direction, Animal... animal) {

        Position nextPos = getPositionOnBoard().next(direction);

        for (Animal animalonboard : animal) {
            if (animalonboard.getPositionOnBoard() == null) {
                continue;//ignore l'animal null
            }
            if (animalonboard.getPositionOnBoard().equals(getPositionOnBoard())) {
                if (animalonboard.isOnStar()) {
                    return getPositionOnBoard();
                } else {
                    setPositionOnBoard(nextPos);
                    return nextPos;
                }
            }
        }
        return null;

    }

    /**
     * if an animal is already on the square coveted by the chosen animal,
     * if it does, it changes the position of the chosen animal
     *
     * @param pos    Position to check
     * @param animal animals on board
     * @return int of number of animals on the actual square.
     */
    protected int checkActualCaseOccuped(Position pos, Animal... animal) {
        int countAnimalCase = 0;
        for (Animal animalonboard : animal) {
            if (animalonboard.getPositionOnBoard() == null) {
                continue;//ignore l'animal null
            }
            if (animalonboard.getPositionOnBoard().equals(pos)) {
                countAnimalCase++;
            }

        }
        return countAnimalCase;

    }

    /**
     * check if the animal is on a star square, if it does, it change squareType,
     * set animal on star and remove the animal of the board
     *
     * @param board actual board
     * @param pos   actual pos to check
     */
    protected void checkFinalOnStar(Board board, Position pos) {
        if (board.getSquareType(pos).equals(SquareType.STAR)) {
            setOnStar(true);
            setPositionOnBoard(null);
            board.removeStar(pos);
        }
    }

    protected Position result(Board board, Position pos, Direction direction,Animal... animal) {
        if (pos == null || !board.isInside(pos)) {
            pos = null;
        }
        int check = checkActualCaseOccuped(pos, animal);
        while (check >= 2) {
            pos = moveOneJumpingOrFlying(board, direction, animal);
            check = checkActualCaseOccuped(pos, animal);
        }
        if (pos == null || !board.isInside(pos)) {
            pos = null;
        }
        checkFinalOnStar(board, pos);
        return pos;
    }
}