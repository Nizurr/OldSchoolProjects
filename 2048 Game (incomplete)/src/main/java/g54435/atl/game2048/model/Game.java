package g54435.atl.game2048.model;

import java.util.Arrays;

/**
 * Class Game
 */
public class Game implements ModelInterface {

    // Board of the game (4x4 grid)
    private Board board;
    // Initial Score of the game
    private int score = 0;
    // Initial Status of the game
    private LevelStatus levelStatus = LevelStatus.NOT_STARTED;

    /**
     * Constructor
     */
    public Game() {
        this.board = new Board(4, 4);
    }

    /**
     * @return the board
     */
    @Override
    public Board getBoard() {
        return board;
    }

    /**
     * Setter of the levelStatus
     *
     * @param levelStatus levelstatus to set
     */
    public void setLevelStatus(LevelStatus levelStatus) {
        this.levelStatus = levelStatus;
    }

    /**
     * Principal methode, move each piece in the direction gived
     *
     * @param dir direction to move
     * @return a boolean : true if not one piece moved
     */
    @Override
    public boolean move(Direction dir) {
        if (dir == null) throw new IllegalArgumentException("Arugments excepted");
        int alreadyMoved = 0;

        Tile[][] tempBoard = board.clone();

        switch (dir) {
            case UP:
                alreadyMoved = 0;
                for (int col = 0; col < board.getHeigth(); col++) {
                    for (int row = 0; row < board.getHeigth(); row++) {
                        if (checkEntireLine(row, col, dir)) break;
                        alreadyMoved = makeMove(row, col, dir, alreadyMoved);
                    }
                    alreadyMoved = 0;
                }
                break;
            case DOWN:
                alreadyMoved = 0;
                for (int col = board.getWidth() - 1; col >= 0; col--) {
                    for (int row = board.getHeigth() - 1; row >= 0; row--) {
                        if (checkEntireLine(row, col, dir)) break;
                        alreadyMoved = makeMove(row, col, dir, alreadyMoved);
                    }
                    alreadyMoved = 0;
                }
                break;
            case LEFT:
                for (int row = 0; row < board.getHeigth(); row++) {
                    for (int col = 0; col < board.getHeigth(); col++) {
                        if (checkEntireLine(row, col, dir)) break;
                        alreadyMoved = makeMove(row, col, dir, alreadyMoved);
                    }
                    alreadyMoved = 0;
                }
                break;
            case RIGHT:
                for (int row = 0; row < board.getHeigth(); row++) {
                    for (int col = board.getWidth() - 1; col >= 0; col--) {
                        if (checkEntireLine(row, col, dir)) break;
                        Position from = new Position(row, col);
                        Position to = from.getAdjacent(dir);
                        if (!board.isEmptyOn(from)) {
                            while (board.posExist(to)) {
                                if (board.isEmptyOn(to)) {
                                    board.move(from, to, 0);
                                    from = new Position(to.getRow(), to.getColumn());
                                    to = to.getAdjacent(dir);
                                } else if (board.posExist(to) && !board.isEmptyOn(to) &&
                                        board.getTileOn(to).getValue() == board.getTileOn(from).getValue()) {
                                    board.move(from, to, board.getTileOn(from).getValue() * 2);
                                    from = new Position(to.getRow(), to.getColumn());
                                    to = to.getAdjacent(dir);
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
        }

        boolean sameGrid = Arrays.deepEquals(tempBoard, this.board.getGrid());
        if (!sameGrid) {
            this.board.newTile();
        }
        return sameGrid;
    }

    /**
     * Check the Status and change it if needed
     *
     * @param sameGrid a boolean : true if not one piece was moved
     */
    public void checkStatusAndEnd(boolean sameGrid) {
        if (this.board.gridIsFull() && sameGrid) setLevelStatus(LevelStatus.FAIL);
        if (this.board.gridContain2048()) setLevelStatus(LevelStatus.WIN);
    }

    @Override
    public void cleanGrid() {
        this.board = new Board(4,4);
        this.levelStatus = LevelStatus.NOT_STARTED;
        this.score = 0;
    }

    /**
     * core of a move in specific direction (except for right dir who need specific move)
     *
     * @param row          actual row
     * @param col          actual column
     * @param dir          direction to move
     * @param alreadyMoved alreadyMoved is a parameter who say if in the same line a move was made
     *                     exemple case : 8 4 2 2 => 8 4 4 0 and not 16 0 0 0
     * @return alreadyMoved
     */
    private int makeMove(int row, int col, Direction dir, int alreadyMoved) {
        Position from = new Position(row, col);
        Position to = from.getAdjacent(dir);
        if (!this.board.isEmptyOn(from)) {
            while (this.board.posExist(to)) {
                if (this.board.isEmptyOn(to)) {
                    this.board.move(from, to, 0);
                    from = new Position(to.getRow(), to.getColumn());
                    to = to.getAdjacent(dir);
                } else if (this.board.posExist(to) && !this.board.isEmptyOn(to) &&
                        this.board.getTileOn(to).getValue() == this.board.getTileOn(from).getValue() && alreadyMoved == 0) {
                    this.board.move(from, to, this.board.getTileOn(from).getValue() * 2);
                    from = new Position(to.getRow(), to.getColumn());
                    to = to.getAdjacent(dir);
                    alreadyMoved += 1;
                    this.score += this.board.getTileOn(from).getValue();
                } else {
                    break;
                }
            }
            return alreadyMoved;
        }
        return alreadyMoved;
    }

    /**
     * exemple : le cas suivant est géré ici
     * 0 0 0 0
     * 4 4 4 4
     * 0 0 0 0
     * 0 0 0 0
     *
     * @param row actual row
     * @param col actual column
     * @param dir direction to move
     * @return true if all piece is the same in the same line
     */
    private boolean checkEntireLine(int row, int col, Direction dir) {
        if (dir == null) throw new IllegalArgumentException("Arguments excepted");
        boolean b;
        if (dir.equals(Direction.RIGHT) || dir.equals(Direction.LEFT)) {
            //TODO Y a mieux que cette façon pour check des lignes
            b = ((board.getValue(new Position(row, 0)) == board.getValue(new Position(row, 1))
            ) && (board.getValue(new Position(row, 1)) == board.getValue(new Position(row, 2))) &&
                    (board.getValue(new Position(row, 2)) == board.getValue(new Position(row, 3))));
        } else {
            b = ((board.getValue(new Position(0, col)) == board.getValue(new Position(1, col))
            ) && (board.getValue(new Position(1, col)) == board.getValue(new Position(2, col))) &&
                    (board.getValue(new Position(2, col)) == board.getValue(new Position(3, col))));
        }
        if (b && board.getValue(new Position(row, col)) == 0) return false;
        if (b) {
            if (dir.equals(Direction.LEFT)) {
                int v = board.getValue(new Position(row, 0)) * 2;
                board.set(new Position(row, 0), new Tile(v));
                board.set(new Position(row, 1), new Tile(v));
                board.set(new Position(row, 2), new Tile());
                board.set(new Position(row, 3), new Tile());
                this.score += board.getTileOn(new Position(row, 0)).getValue() * 2;
            } else if (dir.equals(Direction.RIGHT)) {
                int v = board.getValue(new Position(row, 0)) * 2;
                board.set(new Position(row, 0), new Tile());
                board.set(new Position(row, 1), new Tile());
                board.set(new Position(row, 2), new Tile(v));
                board.set(new Position(row, 3), new Tile(v));
                this.score += board.getTileOn(new Position(row, 0)).getValue() * 2;
            } else if (dir.equals(Direction.DOWN)) {
                int v = board.getValue(new Position(0, col)) * 2;
                board.set(new Position(0, col), new Tile());
                board.set(new Position(1, col), new Tile());
                board.set(new Position(2, col), new Tile(v));
                board.set(new Position(3, col), new Tile(v));
                this.score += board.getTileOn(new Position(0, col)).getValue() * 2;

            } else if (dir.equals(Direction.UP)) {
                int v = board.getValue(new Position(0, col)) * 2;
                board.set(new Position(0, col), new Tile(v));
                board.set(new Position(1, col), new Tile(v));
                board.set(new Position(2, col), new Tile());
                board.set(new Position(3, col), new Tile());
                this.score += board.getTileOn(new Position(0, col)).getValue() * 2;
            }
        }

        return b;

    }

    /**
     * @return the actual score
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * @return actual LevelStatus
     */
    @Override
    public LevelStatus getLevelStatus() {
        return levelStatus;
    }


}
