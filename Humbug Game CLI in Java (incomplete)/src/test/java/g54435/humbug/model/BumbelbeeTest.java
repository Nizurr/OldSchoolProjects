package g54435.humbug.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static g54435.humbug.model.SquareType.*;
import static org.junit.jupiter.api.Assertions.*;


/**
 * Project projet-humbug
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
class BumbelbeeTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS), new Square(GRASS)},
                {new Square(GRASS), null, new Square(GRASS)},
                {new Square(GRASS), null, new Square(GRASS)},
                {new Square(STAR)}, {new Square(GRASS), new Square(GRASS)}});
    }

    @Test
    public void testMoveJump() {
        setUp();
        System.out.println("testMoveJump");
        animals = new Animal[]{
                new Bumbelbee(new Position(0, 0))

        };
        Position expResult = new Position(0, 2);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }

    @Test
    public void testMoveJump1Animal() {
        setUp();
        System.out.println("testMoveJump1Animal");
        animals = new Animal[]{
                new Bumbelbee(new Position(0, 0)),
                new Snail(new Position(0, 1)),
                new Snail(new Position(0, 2)),

        };
        Position expResult = new Position(0, 3);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }

    @Test
    public void testMoveJump2Animal() {
        setUp();
        System.out.println("testMoveJump2Animal");
        animals = new Animal[]{
                new Bumbelbee(new Position(0, 0)),
                new Snail(new Position(0, 1)),
                new Snail(new Position(0, 2)),
                new Snail(new Position(0, 3)),

        };
        Position expResult = new Position(0, 4);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }

    @Test
    public void testMoveOnStar() {
        setUp();
        System.out.println("testMoveOnStar");
        animals = new Animal[]{
                new Bumbelbee(new Position(1, 0)),

        };

        Position expResult = new Position(3, 0);
        Position result = animals[0].move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());
        assertEquals(GRASS, board.getSquareType(result));

    }

    @Test
    public void testMoveJumpAuDessusDeVoid() {
        setUp();
        System.out.println("testMoveJumpAuDessusDeVoid");
        animals = new Animal[]{
                new Bumbelbee(new Position(1, 0)),


        };
        Position expResult = new Position(1, 2);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }

    @Test
    public void testMoveJumpWithWall() {
        setUp();
        System.out.println("testMoveJumpWithWall");
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][0];
        Square sq1 = brdOfSq[0][1];
        sq.setEastWall(true);
        sq1.setEastWall(true);
        animals = new Animal[]{
                new Bumbelbee(new Position(0, 0)),


        };
        Position expResult = new Position(0, 2);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }
}






