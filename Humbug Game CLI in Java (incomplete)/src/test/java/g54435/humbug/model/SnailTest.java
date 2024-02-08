package g54435.humbug.model.animals;

import static g54435.humbug.model.SquareType.GRASS;
import static g54435.humbug.model.SquareType.STAR;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import g54435.humbug.model.Animal;
import g54435.humbug.model.Snail;
import g54435.humbug.view.text.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import g54435.humbug.model.Board;
import g54435.humbug.model.Direction;
import g54435.humbug.model.Position;
import g54435.humbug.model.Square;

/**
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 * Ajout de test par Adnane G54435
 */
public class SnailTest {

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
                new Snail(new Position(0, 0)),
                new Snail(new Position(1, 2))
        };
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove() {
        setUp();
        System.out.println("move_general");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 1); //.next(Direction.EAST);
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
        Snail instance = (Snail) animals[0];
        animals[1].setPositionOnBoard(new Position(0, 1));
        Position expResult = new Position(0, 0); //don't move
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }


    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_onstar() {
        setUp();
        System.out.println("move next on star");
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(2, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);
        assertEquals(expResult, result);
        assertTrue(instance.isOnStar());
        assertEquals(GRASS, board.getSquareType(result));
    }

    /**
     * Test of move method, of class Snail.
     */
    @Test
    public void testMove_next_notinside_2() {
        setUp();
        System.out.println("move next case null");
        Snail instance = (Snail) animals[0];
        Position expResult = null; // move and fall

        Position result = instance.move(board, Direction.WEST, animals);
        assertEquals(expResult, result);
    }


    /**
     * Test of move method, of class Snail.
     */

    @Test
    public void testMove_blockByWall() {
        setUp();
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][0];
        sq.setEastWall(true);

        System.out.println("0,0 blocked by wall");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */

    @Test
    public void testMove_blockByNextSquareWall() {
        setUp();
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][1];
        sq.setWestWall(true);
        System.out.println("0,1 blocked by wall, snail stay in 0,0");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);
        Position result = instance.move(board, Direction.EAST, animals);

        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */

    @Test
    public void testMove_blockByWallAndNotFall() {
        setUp();
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][0];
        sq.setWestWall(true);

        System.out.println("0,0 blocked by Westwall, snail stay in 0,0. dont fall");
        Snail instance = (Snail) animals[0];
        Position expResult = new Position(0, 0);

        Position result = instance.move(board, Direction.WEST, animals);

        assertEquals(expResult, result);
    }

    /**
     * Test of move method, of class Snail.
     */

    @Test
    public void testMove_blockByWallCantChangeRow() {
        setUp();
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[2][2];
        sq.setNorthWall(true);

        System.out.println("0,0 blocked by Westwall, snail stay in 0,0. dont fall");
        Snail instance = (Snail) animals[1];
        Position expResult = new Position(1, 2);
        Position result = instance.move(board, Direction.SOUTH, animals);

        assertEquals(expResult, result);
    }


}
