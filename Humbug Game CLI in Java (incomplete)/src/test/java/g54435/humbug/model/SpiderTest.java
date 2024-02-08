package g54435.humbug.model.animals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static g54435.humbug.model.SquareType.GRASS;
import static g54435.humbug.model.SquareType.STAR;

import g54435.humbug.model.Animal;
import g54435.humbug.model.Snail;
import g54435.humbug.model.Spider;
import g54435.humbug.view.text.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import g54435.humbug.model.Board;
import g54435.humbug.model.Direction;
import g54435.humbug.model.Position;
import g54435.humbug.model.Square;
//import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 * Ajout de test par Adnane G54435
 */
public class SpiderTest {

    private Board board;
    private Animal[] animals;

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), null},
                {null, new Square(GRASS), new Square(GRASS)},
                {null, null, new Square(STAR)}
        });
        animals = new Animal[]{
                new Spider(new Position(0, 0)),
                new Snail(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Spider.
     */
    @Test
    public void testMove() {
        setUp();
        System.out.println("move and fall");
        Spider instance = (Spider) animals[0];
        Position expResult = null; // fall
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Spider.
     */
    @Test
    public void testMove_endline() {
        setUp();
        System.out.println("move end line and fall");
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
                {null, new Square(GRASS), new Square(GRASS)},
                {null, null, new Square(STAR)}
        });
        Spider instance = (Spider) animals[0];
        Position expResult = null;
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Spider.
     */
    @Test
    public void testMove_tootheranimal() {
        setUp();
        System.out.println("move to other animal");
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), new Square(GRASS)},
                {null, new Square(GRASS), new Square(GRASS)},
                {null, null, new Square(STAR)}
        });
        animals[1] = new Snail(new Position(0, 2));
        Spider instance = (Spider) animals[0];
        Position expResult = new Position(0, 1);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notfree() {
        setUp();
        System.out.println("move next case not free");
        Spider instance = (Spider) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notinside() {
        setUp();
        System.out.println("move next case null and fall");
        Spider instance = (Spider) animals[0];
        Position expResult = null; // fall
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMove_passOnStar() {
        setUp();
        System.out.println("move and pass on star without win");
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(STAR), new Square(GRASS), new Square(GRASS)},
                {null, new Square(GRASS), new Square(GRASS), null},
                {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
                new Spider(new Position(0, 0)),
                new Snail(new Position(0, 3))
        };
        Spider instance = (Spider) animals[0];
        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertFalse(animals[0].isOnStar());
        assertFalse(board.getSquareType(new Position(0, 1)) == GRASS);
    }

    @Test
    public void testMove_nextOnStar() {
        setUp();
        System.out.println("move, next on star and win");
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), new Square(STAR), new Square(GRASS)},
                {null, new Square(GRASS), new Square(GRASS), null},
                {null, null, new Square(STAR), null}
        });
        animals = new Animal[]{
                new Spider(new Position(0, 0)),
                new Snail(new Position(0, 3))
        };
        Spider instance = (Spider) animals[0];

        Position expResult = new Position(0, 2);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
        assertTrue(animals[0].isOnStar());

        assertEquals(GRASS, board.getSquareType(result));
    }


    /**
     * Test of move method, of class Spider.
     */

    @Test
    public void testMove_blockByWall() {
        setUp();
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][0];
        sq.setEastWall(true);

        System.out.println("0,0 blocked by wall");
        Spider instance = (Spider) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Spider.
     */

    @Test
    public void testMove_blockByNextSquareWall() {
        setUp();
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][1];
        sq.setWestWall(true);
        System.out.println("0,1 blocked by wall, snail stay in 0,0");
        Spider instance = (Spider) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);

        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Spider.
     */

    @Test
    public void testMove_blockByWallAndNotFall() {
        setUp();
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][0];
        sq.setWestWall(true);

        System.out.println("0,0 blocked by Westwall, snail stay in 0,0. dont fall");
        Spider instance = (Spider) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.WEST, animals);

        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Spider.
     */

    @Test
    public void testMove_blockByWallBlockedByWallAndAnimal() {
        setUp();
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][1];
        sq.setWestWall(true);
        animals = new Animal[]{
                new Spider(new Position(0, 0)),
                new Snail(new Position(0, 1))
        };
        System.out.println("0,0 blocked by next.westwall and animal, Spider stay in 0,0. dont move");
        Spider instance = (Spider) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }


}