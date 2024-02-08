package g54435.atl.game2048.view.text;

import g54435.atl.game2048.model.Board;
import g54435.atl.game2048.model.Direction;
import g54435.atl.game2048.model.Tile;

import java.util.Scanner;

/**
 * View classe
 */
public class View {
    /**
     * Console view of the board
     *
     * @param board board to show in the console
     */
    public void displayBoard(Board board) {
        for (Tile[] t : board.getGrid()) {
            for (Tile y : t) {
                System.out.print(y.getValue() + "  ");
            }
            System.out.println();
        }

    }

    /**
     * display a score
     *
     * @param s score to show
     */
    public void displayScore(int s) {
        System.out.println("Votre score : " + s);
    }

    /**
     * Ask a direction
     *
     * @return a direction
     */
    public Direction askDirection() {
        //NRI: this variable could be a class variable (final, static, private) so as to reuse it in both askDirection and askPosition methods.
        Scanner clavier = new Scanner(System.in);
        System.out.println("Veuillez indiquer une direction :");

        String rep = clavier.next();
        rep = rep.toUpperCase();

        switch (rep) {
            case "UP":
            case "HAUT":
                return Direction.UP;
            case "DOWN":
            case "BAS":
                return Direction.DOWN;
            case "LEFT":
            case "GAUCHE":
                return Direction.LEFT;
            case "RIGHT":
            case "DROITE":
                return Direction.RIGHT;
            default:
                System.out.println("Erreur, réessayer !");
                return askDirection();
        }

    }

    /**
     * display Commands
     */
    public void displayCommands() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Les commandes disponibles pour bouger les cases :");
        System.out.println("déplacement vers la droite : right");
        System.out.println("déplacement vers la gauche : left");
        System.out.println("déplacement vers le haut : up");
        System.out.println("déplacement vers le bas : down");
        System.out.println("-----------------------------------------------------");
        System.out.println();
        System.out.println();
    }

    /**
     * display fail message with score
     *
     * @param score score to show
     */
    public void displayFail(int score) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("███████╗ █████╗ ██╗██╗\n██╔════╝██╔══██╗██║██║\n█████╗  ███████║██║██║\n" +
                "██╔══╝  ██╔══██║██║██║\n██║     ██║  ██║██║███████╗\n╚═╝     ╚═╝  ╚═╝╚═╝╚══════╝");
        System.out.println("Votre score : " + score);
    }

    public void displayWin(int score) {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("██╗    ██╗██╗███╗   ██╗\n██║    ██║██║████╗  ██║\n██║ █╗ ██║██║██╔██╗ ██║\n" +
                "██║███╗██║██║██║╚██╗██║\n╚███╔███╔╝██║██║ ╚████║\n╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝\n");
        System.out.println("Votre score : " + score);

    }
}
