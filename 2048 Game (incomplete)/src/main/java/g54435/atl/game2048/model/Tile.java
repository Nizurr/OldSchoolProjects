package g54435.atl.game2048.model;

import java.util.Objects;

/**
 * A piece on the grid (4x4 grid = 16 tile)
 */
public class Tile {
    // Value of an tile
    private int value;

    /**
     * Constructor
     */
    Tile() {
    }

    /**
     * Constructor
     * @param value value to set to the tile
     */
    Tile(int value) {
        this.value = value;
    }

    /**
     * @return value of the tile. 0 == in theory piece doesnt exist
     */
    public int getValue() {
        return value;
    }

    /**
     * set value to the Tile
     * @param value to set
     */
    protected void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return value == tile.value;
    }

}
