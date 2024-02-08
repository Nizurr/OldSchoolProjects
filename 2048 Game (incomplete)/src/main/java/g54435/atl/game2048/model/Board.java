package g54435.atl.game2048.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Board {
    //2D Array for the grid
    private Tile[][] grid;
    private int width, heigth;

    /**
     * Constructor
     *
     * @param width  width of the grid
     * @param heigth height of the grid
     */
    Board(int width, int heigth) {
        this.heigth = heigth;
        this.width = width;
        this.grid = new Tile[width][heigth];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                this.grid[i][j] = new Tile();
            }
        }
    }

    /**
     * @return the grid
     */
    public Tile[][] getGrid() {
        return grid;
    }

    /**
     * get value on a specified position on the grid
     *
     * @param pos position on the grid
     * @return int value of the piece
     */
    public int getValue(Position pos) {
        if (pos == null) throw new IllegalArgumentException("arguments excepted");
        if (grid[pos.getRow()][pos.getColumn()].getValue() == 0) {
            return 0;
        } else return grid[pos.getRow()][pos.getColumn()].getValue();
    }

    public int getValue(int i, int j) {
        return getValue(new Position(i,j));
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeigth() {
        return heigth;
    }

    /**
     * j'ai utilisé cette façon car un probleme survenait lorsque je faisais un Tile[][] temp = board.getGrid()
     *
     * @return a clone of the grid
     */
    @Override
    protected Tile[][] clone() {
        Tile[][] temp = new Tile[heigth][width];
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                temp[i][j] = grid[i][j];
            }
        }
        return temp;
    }

    /**
     * getter of an object Tile on the grid with a gived position
     *
     * @param pos position on the grid
     * @return an object Tile/ piece on the grid
     */
    protected Tile getTileOn(Position pos) {
        if (pos == null) throw new IllegalArgumentException("arguments excepeted");
        return grid[pos.getRow()][pos.getColumn()];
    }

    /**
     * Move a single piece of the grid with two position
     *
     * @param from     position where is the piece
     * @param to       position to set the piece
     * @param newValue new value of the piece (ex:  piece 4 -> 8)
     */
    protected void move(Position from, Position to, int newValue) {
        Tile tfrom = getTileOn(from); //On prends la case
        if (newValue != 0) {
            set(to, tfrom); //On la change de place
            tfrom.setValue(newValue);
            set(from, new Tile(0)); // on créer une nouvelle case vide là ou la case à bougé (qui sera peut etre remplacée par la suite)

        } else {
            set(to, tfrom); //On la change de place
            set(from, new Tile(0)); // on créer une nouvelle case vide là ou la case à bougé (qui sera peut etre remplacée par la suite)

        }
    }

    /**
     * Set a new tile in a given pos
     *
     * @param pos  position on the grid
     * @param tile
     */
    protected void set(Position pos, Tile tile) {
        if (pos == null || tile == null) {
            throw new IllegalArgumentException("arguments excepted");
        }
        grid[pos.getRow()][pos.getColumn()] = tile;
    }

    /**
     * check if the gived pos is on the grid
     *
     * @param pos position on the grid
     * @return a boolean
     */
    protected boolean posExist(Position pos) {
        if (pos == null) throw new IllegalArgumentException("arguments excepted");
        return (pos.getRow() >= 0 && pos.getRow() < heigth &&
                pos.getColumn() >= 0 && pos.getColumn() < width);
    }

    /**
     * say if a pos on the grid is free
     *
     * @param pos position on the grid
     * @return true if the pos on grid is free
     */
    protected boolean isEmptyOn(Position pos) {
        if (pos == null) throw new IllegalArgumentException("arguments excepted");
        return grid[pos.getRow()][pos.getColumn()].getValue() == 0;
    }

    /**
     * used to check if the game is loose
     *
     * @return boolean true = not one free space on the grid
     */
    protected boolean gridContain2048() {
        for (Tile[] tarr : grid) {
            for (Tile t : tarr) {
                if (t.getValue() == 2048) return true;
            }
        }
        return false;
    }

    /**
     * used to check if the game is loose
     *
     * @return boolean true = not one free space on the grid
     */
    protected boolean gridIsFull() {
        int nbval = 0;
        for (Tile[] tarr : grid) {
            for (Tile t : tarr) {
                if (t.getValue() != 0) nbval += 1;
            }
        }
        return nbval == (heigth * width);
    }

    /**
     * Add randomly a new tile on the grid
     * 50% piece of value 2 || piece of value 4
     */
    public void newTile() {
        if (gridIsFull()) return;

        int rndH, rndW;
        rndH = (int) (Math.random() * heigth);
        rndW = (int) (Math.random() * width);
        Position pos = new Position(rndH, rndW);
        while (!isEmptyOn(pos)) {
            rndH = (int) (Math.random() * heigth);
            rndW = (int) (Math.random() * width);
            pos = new Position(rndH, rndW);
        }
        Random random = new Random();
        float lucky = random.nextFloat();
        if (lucky <= 0.90f) {
            getTileOn(pos).setValue(2);
        } else {
            getTileOn(pos).setValue(4);
        }
    }


    @Override
    public String toString() {
        String s = "";
        for (Tile[] t : getGrid()) {
            for (Tile y : t) {
                s = s + y.getValue() + "  ";
            }
            s = s + "\n";
        }
        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return width == board.width &&
                heigth == board.heigth &&
                Arrays.equals(grid, board.grid);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(width, heigth);
        result = 31 * result + Arrays.hashCode(grid);
        return result;
    }
}
