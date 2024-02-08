package g54435.atl.game2048.model;

import g54435.atl.game2048.view.text.View;
import g54435.atl.game2048.model.Game.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class GameTest {

    private View v = new View();

    public void move(Board board, Direction dir) {
        int ajouted = 0;
        Tile[][] tempBoard = board.clone();

        switch (dir) {
            case UP:
                ajouted = 0;
                for (int col = 0; col < board.getHeigth(); col++) {
                    for (int row = 0; row < board.getHeigth(); row++) {
                        if (checkEntireLine(row, col, dir, board)) break;
                        ajouted = makeMove(row, col, dir, ajouted, board);
                    }
                    ajouted = 0;
                }
                break;
            case DOWN:
                ajouted = 0;
                for (int col = board.getWidth() - 1; col >= 0; col--) {
                    for (int row = board.getHeigth() - 1; row >= 0; row--) {
                        if (checkEntireLine(row, col, dir, board)) break;
                        ajouted = makeMove(row, col, dir, ajouted, board);
                    }
                    ajouted = 0;
                }
                break;
            case LEFT:
                for (int row = 0; row < board.getHeigth(); row++) {
                    for (int col = 0; col < board.getHeigth(); col++) {
                        if (checkEntireLine(row, col, dir, board)) break;
                        ajouted = makeMove(row, col, dir, ajouted, board);
                    }
                    ajouted = 0;
                }
                break;
            case RIGHT:
                for (int row = 0; row < board.getHeigth(); row++) {
                    for (int col = board.getWidth() - 1; col >= 0; col--) {
                        if (checkEntireLine(row, col, dir, board)) break;
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


    }

    private int makeMove(int row, int col, Direction dir, int ajouted, Board board) {
        Position from = new Position(row, col);
        Position to = from.getAdjacent(dir);
        if (!board.isEmptyOn(from)) {
            while (board.posExist(to)) {
                if (board.isEmptyOn(to)) {
                    board.move(from, to, 0);
                    from = new Position(to.getRow(), to.getColumn());
                    to = to.getAdjacent(dir);
                } else if (board.posExist(to) && !board.isEmptyOn(to) &&
                        board.getTileOn(to).getValue() == board.getTileOn(from).getValue() && ajouted == 0) {
                    board.move(from, to, board.getTileOn(from).getValue() * 2);
                    from = new Position(to.getRow(), to.getColumn());
                    to = to.getAdjacent(dir);
                    ajouted += 1;
                } else {
                    break;
                }
            }
            return ajouted;
        }
        return ajouted;
    }

    /**
     * exemple : le cas suivant est géré ici
     * 0 0 0 0
     * 4 4 4 4
     * 0 0 0 0
     * 0 0 0 0
     *
     * @param i
     * @param j
     * @param dir
     * @return
     */
    private boolean checkEntireLine(int i, int j, Direction dir, Board board) {
        boolean b = false;
        if (dir.equals(Direction.RIGHT) || dir.equals(Direction.LEFT)) {
            b = ((board.getValue(new Position(i, 0)) == board.getValue(new Position(i, 1))
            ) && (board.getValue(new Position(i, 1)) == board.getValue(new Position(i, 2))) &&
                    (board.getValue(new Position(i, 2)) == board.getValue(new Position(i, 3))));
        } else {
            b = ((board.getValue(new Position(0, j)) == board.getValue(new Position(1, j))
            ) && (board.getValue(new Position(1, j)) == board.getValue(new Position(2, j))) &&
                    (board.getValue(new Position(2, j)) == board.getValue(new Position(3, j))));
        }
        if (b && board.getValue(new Position(i, j)) == 0) return false;
        if (b) {
            if (dir.equals(Direction.LEFT)) {
                int v = board.getValue(new Position(i, 0)) * 2;
                board.set(new Position(i, 0), new Tile(v));
                board.set(new Position(i, 1), new Tile(v));
                board.set(new Position(i, 2), new Tile());
                board.set(new Position(i, 3), new Tile());
            } else if (dir.equals(Direction.RIGHT)) {
                int v = board.getValue(new Position(i, 0)) * 2;
                board.set(new Position(i, 0), new Tile());
                board.set(new Position(i, 1), new Tile());
                board.set(new Position(i, 2), new Tile(v));
                board.set(new Position(i, 3), new Tile(v));
            } else if (dir.equals(Direction.DOWN)) {
                int v = board.getValue(new Position(0, j)) * 2;
                board.set(new Position(0, j), new Tile());
                board.set(new Position(1, j), new Tile());
                board.set(new Position(2, j), new Tile(v));
                board.set(new Position(3, j), new Tile(v));

            } else if (dir.equals(Direction.UP)) {
                int v = board.getValue(new Position(0, j)) * 2;
                board.set(new Position(0, j), new Tile(v));
                board.set(new Position(1, j), new Tile(v));
                board.set(new Position(2, j), new Tile());
                board.set(new Position(3, j), new Tile());
            }
        }

        return b;

    }


    @Test
    public void simpleMove() {
        Direction dir = Direction.DOWN;
        Board brd = new Board(4, 4);
        brd.set(new Position(0, 0), new Tile(4));

        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(3, 0), new Tile(4));
        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);
        assertEquals(brdexpected.toString(), brd.toString());
    }

    @Test
    public void testMoveDown() {
        Direction dir = Direction.DOWN;
        Board brd = new Board(4, 4);

        brd.set(new Position(3, 0), new Tile(4));
        brd.set(new Position(2, 0), new Tile(4));
        brd.set(new Position(1, 0), new Tile(8));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(3, 0), new Tile(8));
        brdexpected.set(new Position(2, 0), new Tile(8));
        brdexpected.set(new Position(1, 0), new Tile(0));

        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);
        assertEquals(brdexpected.toString(), brd.toString());

    }

    @Test
    public void testMoveRight() {
        Direction dir = Direction.RIGHT;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 3), new Tile(2));
        brd.set(new Position(0, 1), new Tile(4));
        brd.set(new Position(1, 3), new Tile(2));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 3), new Tile(2));
        brdexpected.set(new Position(0, 2), new Tile(4));
        brdexpected.set(new Position(1, 3), new Tile(2));

        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);
        assertEquals(brdexpected.toString(), brd.toString());

    }

    @Test
    public void testMoveDoubleRight() {
        Direction dir = Direction.RIGHT;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 0), new Tile(2));
        brd.set(new Position(0, 1), new Tile(2));
        brd.set(new Position(0, 2), new Tile(4));
        brd.set(new Position(0, 3), new Tile(4));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 2), new Tile(4));
        brdexpected.set(new Position(0, 3), new Tile(8));

        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);
        assertEquals(brdexpected.toString(), brd.toString());

    }

    @Test
    public void testMoveLeft() {
        Direction dir = Direction.LEFT;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 1), new Tile(4));
        brd.set(new Position(0, 2), new Tile(4));
        brd.set(new Position(0, 3), new Tile(8));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 0), new Tile(8));
        brdexpected.set(new Position(0, 1), new Tile(8));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

    }

    @Test
    public void testMoveLeftFour4() {
        Direction dir = Direction.LEFT;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 0), new Tile(4));
        brd.set(new Position(0, 1), new Tile(4));
        brd.set(new Position(0, 2), new Tile(4));
        brd.set(new Position(0, 3), new Tile(4));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 0), new Tile(8));
        brdexpected.set(new Position(0, 1), new Tile(8));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

        //brd.set(new Position(0,0),new Tile(0,new Position(3,0)));
    }

    @Test
    public void testMoveRightFour4() {
        Direction dir = Direction.RIGHT;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 0), new Tile(4));
        brd.set(new Position(0, 1), new Tile(4));
        brd.set(new Position(0, 2), new Tile(4));
        brd.set(new Position(0, 3), new Tile(4));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 2), new Tile(8));
        brdexpected.set(new Position(0, 3), new Tile(8));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

        //brd.set(new Position(0,0),new Tile(0,new Position(3,0)));
    }

    @Test
    public void testMoveUpFour4() {
        Direction dir = Direction.UP;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 0), new Tile(4));
        brd.set(new Position(1, 0), new Tile(4));
        brd.set(new Position(2, 0), new Tile(4));
        brd.set(new Position(3, 0), new Tile(4));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 0), new Tile(8));
        brdexpected.set(new Position(1, 0), new Tile(8));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

        //brd.set(new Position(0,0),new Tile(0,new Position(3,0)));
    }

    @Test
    public void testMoveDownFour4() {
        Direction dir = Direction.DOWN;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 0), new Tile(4));
        brd.set(new Position(1, 0), new Tile(4));
        brd.set(new Position(2, 0), new Tile(4));
        brd.set(new Position(3, 0), new Tile(4));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(2, 0), new Tile(8));
        brdexpected.set(new Position(3, 0), new Tile(8));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

        //brd.set(new Position(0,0),new Tile(0,new Position(3,0)));
    }

    @Test
    public void testMoveDownOther() {
        Direction dir = Direction.DOWN;
        Board brd = new Board(4, 4);

        brd.set(new Position(1, 0), new Tile(2));
        brd.set(new Position(2, 0), new Tile(2));
        brd.set(new Position(3, 0), new Tile(4));
        brd.set(new Position(0, 3), new Tile(4));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(1, 0), new Tile(0));
        brdexpected.set(new Position(2, 0), new Tile(4));
        brdexpected.set(new Position(3, 0), new Tile(4));
        brdexpected.set(new Position(3, 3), new Tile(4));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

        //brd.set(new Position(0,0),new Tile(0,new Position(3,0)));
    }

    @Test
    public void testMoveUp() {
        Direction dir = Direction.UP;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 0), new Tile(4));
        brd.set(new Position(1, 0), new Tile(2));
        brd.set(new Position(2, 0), new Tile(2));
        brd.set(new Position(3, 0), new Tile(4));
        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 0), new Tile(4));
        brdexpected.set(new Position(1, 0), new Tile(4));
        brdexpected.set(new Position(2, 0), new Tile(4));
        //brdexpected.set(new Position(3, 0), new Tile(4));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());


        //brd.set(new Position(0,0),new Tile(0,new Position(3,0)));
    }

    @Test
    public void testMoveDownOther2() {
        Direction dir = Direction.DOWN;
        Board brd = new Board(4, 4);
        brd.set(new Position(0, 0), new Tile(4));
        brd.set(new Position(2, 0), new Tile(4));
        brd.set(new Position(3, 0), new Tile(16));
        brd.set(new Position(1, 2), new Tile(2));
        brd.set(new Position(3, 1), new Tile(8));
        brd.set(new Position(3, 2), new Tile(2));
        brd.set(new Position(3, 3), new Tile(4));

        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(2, 0), new Tile(8));
        brdexpected.set(new Position(3, 0), new Tile(16));
        brdexpected.set(new Position(3, 1), new Tile(8));
        brdexpected.set(new Position(3, 2), new Tile(4));
        brdexpected.set(new Position(3, 3), new Tile(4));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

    }

    @Test
    public void testMoveDownOther3() {
        Direction dir = Direction.DOWN;
        Board brd = new Board(4, 4);
        brd.set(new Position(0, 0), new Tile(4));
        brd.set(new Position(1, 0), new Tile(4));
        brd.set(new Position(2, 0), new Tile(0));
        brd.set(new Position(3, 0), new Tile(8));


        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 0), new Tile(0));
        brdexpected.set(new Position(1, 0), new Tile(0));
        brdexpected.set(new Position(2, 0), new Tile(8));
        brdexpected.set(new Position(3, 0), new Tile(8));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

    }

    @Test
    public void testMoveDownOther4() {
        Direction dir = Direction.DOWN;
        Board brd = new Board(4, 4);
        brd.set(new Position(0, 0), new Tile(8));
        brd.set(new Position(1, 0), new Tile(0));
        brd.set(new Position(2, 0), new Tile(4));
        brd.set(new Position(3, 0), new Tile(4));


        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 0), new Tile(0));
        brdexpected.set(new Position(1, 0), new Tile(0));
        brdexpected.set(new Position(2, 0), new Tile(8));
        brdexpected.set(new Position(3, 0), new Tile(8));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

    }


    @Test
    public void testMoveLeftBugSeen() {
        Direction dir = Direction.LEFT;
        Board brd = new Board(4, 4);

        brd.set(new Position(0, 0), new Tile(2));
        brd.set(new Position(1, 0), new Tile(4));
        brd.set(new Position(2, 0), new Tile(2));
        brd.set(new Position(3, 0), new Tile(32));

        brd.set(new Position(2, 1), new Tile(2));
        brd.set(new Position(2, 2), new Tile(4));
        brd.set(new Position(2, 3), new Tile(2));


        System.out.println("ORIGINAL : ");
        v.displayBoard(brd);
        move(brd, dir);

        Board brdexpected = new Board(4, 4);
        brdexpected.set(new Position(0, 0), new Tile(2));
        brdexpected.set(new Position(1, 0), new Tile(4));
        brdexpected.set(new Position(2, 0), new Tile(4));
        brdexpected.set(new Position(3, 0), new Tile(32));

        brdexpected.set(new Position(2, 0), new Tile(4));
        brdexpected.set(new Position(2, 1), new Tile(4));
        brdexpected.set(new Position(2, 2), new Tile(2));


        System.out.println("DIRECTION : " + dir);
        System.out.println("ATTENDU :");
        v.displayBoard(brdexpected);
        System.out.println("RESULTAT : ");
        v.displayBoard(brd);

        assertEquals(brdexpected.toString(), brd.toString());

        //brd.set(new Position(0,0),new Tile(0,new Position(3,0)));
    }
}