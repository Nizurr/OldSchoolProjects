package g54435.humbug.model;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static g54435.humbug.model.SquareType.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
class BoardTest {
    private Board board;

    public BoardTest() {

    }

    @BeforeEach
    public void setUp() {
        board = new Board(new Square[][]{
                {new Square(GRASS),  new Square(GRASS), null},
                {null, new Square(GRASS), new Square(GRASS)},
                {null, null, new Square(STAR)}
        });
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_general_true() {
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), null},
                {null, new Square(GRASS), new Square(GRASS)},
                {null, null, new Square(STAR)}
        });

        System.out.println("isInside general");
        Position position = new Position(0,0);
        boolean expResult = true;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_false_null() {
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), null},
                {null, new Square(GRASS), new Square(GRASS)},
                {null, null, new Square(STAR)}
        });
        System.out.println("isInside false null");
        Position position = new Position(1,0);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_false_outbound_negative() {
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), null},
                {null, new Square(GRASS), new Square(GRASS)},
                {null, null, new Square(STAR)}
        });
        System.out.println("isInside false out of bound");
        Position position = new Position(-1,0);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_false_outbound_positive_row() {
        board = new Board(new Square[][]{
                {new Square(GRASS), new Square(GRASS), null},
                {null, new Square(GRASS), new Square(GRASS)},
                {null, null, new Square(STAR)}
        });

        System.out.println("isInside false out of bound");
        Position position = new Position(10,1);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    /**
     * Test of isInside method, of class Board.
     */
    @Test
    public void testIsInside_false_outbound_positive_column() {
        System.out.println("isInside false out of bound");
        Position position = new Position(2,23);
        boolean expResult = false;
        boolean result = board.isInside(position);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_exist() {
        System.out.println("get square type exist");
        SquareType expResult = SquareType.GRASS;
        SquareType result = board.getSquareType(new Position(0,0));
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_exist_star() {
        System.out.println("get square type exist");
        SquareType expResult = SquareType.STAR;
        SquareType result = board.getSquareType(new Position(2,2));
        assertEquals(expResult, result);
    }

    @Test
    public void testGetSquareType_null() {
        System.out.println("get case type illegal argument");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> { board.getSquareType(new Position(1, 0));
                });

    }

    /**
     * @author Pierre Bettens (pbt) <pbettens@he2b.be>
     * Ajout de test par Adnane G54435
     */
    public static class SnailTest {

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
}