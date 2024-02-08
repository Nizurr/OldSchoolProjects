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
class LadybirdTest {

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
    public void testMoveNormal() {
        setUp();
        System.out.println("testMoveNormal");
        animals = new Animal[]{
                new Ladybird(new Position(0, 0)),
        };
        Position expResult = new Position(0, 2);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);

    }


    @Test
    public void testMoveFail() {
        setUp();
        System.out.println("testMoveFail");
        animals = new Animal[]{
                new Ladybird(new Position(1, 0)),
        };
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        animals[0].move(board, Direction.EAST, animals);
        });

    }


    @Test
    public void testMoveBlockedByWall() {
        setUp();
        System.out.println("Dont move");
        Square[][] brdOfSq = board.getSquares();
        Square sq = brdOfSq[0][0];
        sq.setEastWall(true);
        animals = new Animal[]{
                new Ladybird(new Position(0, 0)),
        };
        Position expResult = new Position(0, 0);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }

    @Test
    public void testMoveBlockedByAnimal() {
        setUp();
        System.out.println("Dont move");
        animals = new Animal[]{
                new Ladybird(new Position(0, 0)),
                new Ladybird(new Position(0, 1))

        };
        Position expResult = new Position(0, 0);
        Position result = animals[0].move(board, Direction.EAST, animals);
        assertEquals(expResult, result);
    }
}






