package g54435.humbug.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static g54435.humbug.model.SquareType.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Project projet-humbug
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
class GrasshopperTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
                {new Square(GRASS), null, new Square(GRASS)},
                {new Square(GRASS), null, new Square(GRASS)},
                {new Square(STAR)}, {new Square(GRASS), new Square(GRASS)}});
    }


    @Test
    public void testMoveJump() {
        setUp();
        System.out.println("moveGrassHopperJump");
        animals = new Animal[]{
                new Grasshopper(new Position(0, 0)),
                new Snail(new Position(0, 1))

        };
        Position expResult = new Position(0, 2);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }

    @Test
    public void testMoveNormal() {
        setUp();
        System.out.println("testMoveNormal");
        animals = new Animal[]{
                new Grasshopper(new Position(0, 0)),
        };
        Position expResult = new Position(0, 1);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }

    @Test
    public void testMoveFail() {
        setUp();
        System.out.println("testMoveFail");
        animals = new Animal[]{
                new Grasshopper(new Position(1, 0)),
        };
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        animals[0].move(board, Direction.EAST, animals);
        });

    }

    @Test
    public void testMoveFailAfterJumpWithWall() {
        setUp();
        System.out.println("testMoveFailAfterJumpWithWall");
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][0];
        sq.setNorthWall(true);
        animals = new Animal[]{
                new Grasshopper(new Position(0, 0)),
        };
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        animals[0].move(board, Direction.NORTH, animals);
        });
    }

    @Test
    public void testMoveJumpOnAnimalAndArrivalOnStar() {
        setUp();
        System.out.println("testMoveJumpOnAnimalAndArrivalOnStar");
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][0];
        sq.setNorthWall(true);
        animals = new Animal[]{
                new Grasshopper(new Position(1, 0)),
                new Snail(new Position(2, 0))
        };
        Position expResult = new Position(3, 0);
        Position result = animals[0].move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }
}






