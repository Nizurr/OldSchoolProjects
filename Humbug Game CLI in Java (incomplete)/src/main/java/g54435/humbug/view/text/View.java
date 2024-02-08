package g54435.humbug.view.text;

import g54435.humbug.model.*;
import g54435.humbug.utils.*;
import java.util.Scanner;

/**
 * Project projet-humbug
 * View the board and user input management
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class View implements InterfaceView {

    /**
     * Display  the board in console
     *
     * @param board board to show
     */
    public void displayBoard(Board board, int nLevel, int moves, Animal... animals) {

        String[][] boardToDisplay = new String[board.getNbRow() * 3][board.getNbColumn() * 2 + 1];

        int ipos = 0;
        int jpos = 0;
        boolean posnull;

        //Remplis le nouveau plateau
        for (int i = 0; i < boardToDisplay.length; i = i + 3) {
            for (int j = 0; j < boardToDisplay[0].length; j = j + 2) {
                if (j == boardToDisplay[0].length - 1) {
                    break;
                }
                posnull = false;
                if (j == 0) {
                    jpos = 0;
                }

                Position pos = new Position(ipos, jpos);
                if (!board.isInside(pos)) {
                    for (int x = 0; x < 3; x++) {
                        boardToDisplay[i + x][j + 1] = displayNull();
                        posnull = true;

                    }
                } else if (board.getSquareType(pos).equals(SquareType.GRASS)) {
                    for (int x = 0; x < 3; x++) {
                        boardToDisplay[i + x][j + 1] = displayGrass();
                    }
                } else if (board.getSquareType(pos).equals(SquareType.STAR)) {
                    boardToDisplay[i][j + 1] = displayGrass();
                    boardToDisplay[i + 1][j + 1] = displayStar();
                    boardToDisplay[i + 2][j + 1] = displayGrass();


                }
                if (!posnull) {

                    if (board.getSquares()[ipos][jpos].hasWall(Direction.SOUTH)) {
                        boardToDisplay[i + 2][j + 1] = displaySquareWall();
                    }
                    if (board.getSquares()[ipos][jpos].hasWall(Direction.NORTH)) {
                        boardToDisplay[i][j + 1] = displaySquareWall();
                    }
                    if (board.getSquares()[ipos][jpos].hasWall(Direction.EAST)) {
                        boardToDisplay[i + 1][j + 2] = displayWall();
                    }
                    if (board.getSquares()[ipos][jpos].hasWall(Direction.WEST)) {
                        boardToDisplay[i + 1][j] = displayWall();
                    }

                }
                jpos++;
            }
            ipos++;
        }

        // Ajout animaux dans le tableau
        for (Animal animal : animals) {
            if (animal.getPositionOnBoard() == null && animal.isOnStar()) { //si l'animal est null ignore
                continue;//ignore l'animal null
            }
            //NRI: use Position.equal
            int aRow = animal.getPositionOnBoard().getRow();
            int aCol = animal.getPositionOnBoard().getColumn();
            aRow = aRow * 3 + 1;
            aCol = aCol + aCol + 1;
            if (!animal.isOnStar()) {
                if (animal instanceof Spider) {
                    boardToDisplay[aRow][aCol] = displaySpider();
                } else if (animal instanceof Snail) {
                    boardToDisplay[aRow][aCol] = displaySnail();
                } else if (animal instanceof Ladybird) {
                    boardToDisplay[aRow][aCol] = displayLadybird();
                } else if (animal instanceof Grasshopper) {
                    boardToDisplay[aRow][aCol] = displayGrasshopper();
                } else if (animal instanceof Bumbelbee) {
                    boardToDisplay[aRow][aCol] = displayBumbelbee();
                } else if (animal instanceof Butterfly) {
                    boardToDisplay[aRow][aCol] = displayButterfly();
                }
            }
        }

        String separation = "";
        switch (board.getNbColumn()) {
            case 3:
                separation = " -----------------------";
                break;
            case 4:
                separation = " -------------------------------";
                break;
            case 5:
                separation = " ---------------------------------------";
                break;
            case 6:
                separation = " -----------------------------------------------";
                break;
        }

        displayNLevel(nLevel);
        displayRemainingMoves(moves);
        // affiche le tableau2D précedemment crée
        for (int i = 0; i < boardToDisplay.length; i++) {
            if (i % 3 == 0) {
                System.out.println(separation);
            }

            for (int j = 0; j < boardToDisplay[0].length; j++) {
                if (boardToDisplay[i][j] == null) {
                    boardToDisplay[i][j] = " ";
                }
                boardToDisplay[i][j] = boardToDisplay[i][j];
                System.out.print(boardToDisplay[i][j]);


            }
            System.out.println();
        }
        System.out.println(separation);


    }

    /**
     * Sout a message with the number of actual level
     * @param nLevel int of level
     */
    private static void displayNLevel(int nLevel) {
        System.out.println("Niveau : " + nLevel);
    }

    /**
     * Sout a message with reMainingMoves
     * @param moves reMainingMoves
     */
    private static void displayRemainingMoves(int moves) {
        System.out.println("Il reste " + moves + " déplacements possible.");
    }

    /**
     * Shows a wall in red (for east west walls)
     * @return a string
     */
    private static String displayWall() {
        return TerminalColor.RED + "|" + "\033[m";
    }

    /**
     * Shows a wall (for north south walls)
     * @return aa string
     */
    private static String displaySquareWall() {
        return TerminalColor.RED + "|" + TerminalColor.BG_BLUE + "-----" + "\033[m" + TerminalColor.RED + "|" + "\033[m";
    }

    /**
     * representation of a GrassSquare
     *
     * @return a String to be displayed
     */
    private static String displayGrass() {
        return "|" + TerminalColor.BG_BLUE + "     " + "\033[m" + "|";
    }

    /**
     * representation of a StarSquare
     *
     * @return a String to be displayed
     */
    private static String displayStar() {
        return "|" + TerminalColor.BG_BLUE + TerminalColor.RED + "  *  " + "\033[m" + "|";
    }

    /**
     * representation of a NullSquare
     *
     * @return a String to be displayed
     */
    private static String displayNull() {
        return "|     |";
    }

    /**
     * representation of a Snail on square
     *
     * @return a String to be displayed
     */
    private static String displaySnail() {
        return "|" + TerminalColor.BG_BLUE + TerminalColor.RED + " SNL " + "\033[m" + "|";
    }

    /**
     * representation of a Grasshopper on square
     *
     * @return a String to be displayed
     */
    private static String displayGrasshopper() {
        return "|" + TerminalColor.BG_BLUE + TerminalColor.RED + " GRH " + "\033[m" + "|";
    }

    /**
     * representation of a Spider on square
     *
     * @return a String to be displayed
     */
    private static String displaySpider() {
        return "|" + TerminalColor.BG_BLUE + TerminalColor.RED + " SPD " + "\033[m" + "|";
    }

    /**
     * representation of a Ladybird on square
     *
     * @return a String to be displayed
     */
    private static String displayLadybird() {
        return "|" + TerminalColor.BG_BLUE + TerminalColor.RED + " LDB " + "\033[m" + "|";
    }

    /**
     * representation of a Bumbelbee on square
     *
     * @return a String to be displayed
     */
    private static String displayBumbelbee() {
        return "|" + TerminalColor.BG_BLUE + TerminalColor.RED + " BBB " + "\033[m" + "|";
    }

    /**
     * representation of a Butterfly on square
     *
     * @return a String to be displayed
     */
    private static String displayButterfly() {
        return "|" + TerminalColor.BG_BLUE + TerminalColor.RED + " BTR " + "\033[m" + "|";
    }

    /**
     * Show a error message.
     *
     * @param message String message to show
     */
    public void displayError(String message) {
        System.out.println(message);
    }

    /**
     * Method asking the user to encode a position
     *
     * @return a position
     */
    public Position askPosition() {
        Scanner clavier = new Scanner(System.in);
        int ligne = -1;
        int col = -1;
        while (ligne < 0 || col < 0) {
            System.out.print("Entrez une Ligne : ");
            if (clavier.hasNextInt()) {
                ligne = clavier.nextInt();

            }
            System.out.print("Entrez une Colonne : ");

            if (clavier.hasNextInt()) {
                col = clavier.nextInt();

            } else {
                String s = clavier.next();
            }
            if (ligne < 0 || col < 0) {
                System.out.println();
                System.out.println("Vous avez entré mauvaise valeur (la valeur doit etre un chiffre et doit etre positif). Merci de re-essayer.");
            }

        }
        Position pos = new Position(ligne, col);
        return pos;
    }

    /**
     * Ask a direction
     *
     * @return a direction
     */
    public Direction askDirection() {
        //NRI: this variable could be a class variable (final, static, private) so as to reuse it in both askDirection and askPosition methods.
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez indiquer une direction (NORTH, SOUTH, EAST, WEST)");

        String rep = clavier.next();
        rep = rep.toUpperCase();

        switch (rep) {
            case "EAST":
                return Direction.EAST;
            case "WEST":
                return Direction.WEST;
            case "SOUTH":
                return Direction.SOUTH;
            case "NORTH":
                return Direction.NORTH;
            default:
                return askDirection();
        }

    }

    /**
     * This method display a message to the person who completes level 100
     */
    public void displayWin() {
        for (int i = 0; i < 6; i++) {
            System.out.println("---------------------------------------------------------------------------");
        }
        System.out.println("Bravo ! Vous avez réussi tous les niveaux ! Je suis tellement fière de vous !");
        for (int i = 0; i < 6; i++) {
            System.out.println("---------------------------------------------------------------------------");
        }
    }

}
