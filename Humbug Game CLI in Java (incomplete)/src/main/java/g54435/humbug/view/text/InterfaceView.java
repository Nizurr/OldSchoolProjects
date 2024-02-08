package g54435.humbug.view.text;

import g54435.humbug.model.*;


/**
 * Project projet-humbug
 * What method is in the view.
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public interface InterfaceView {

    /**
     * Display  the board in console
     *
     * @param board board to show
     */
    void displayBoard(Board board,int nLevel, int moves, Animal... animals);

    /**
     * Method asking the user to encode a position
     *
     * @return a position
     */
    Position askPosition();

    /**
     * Ask a direction
     *
     * @return a direction
     */
    Direction askDirection();

    /**
     * Show a error message.
     *
     * @param s String message to show
     */
    void displayError(String s);

    /**
     * Display a win message if the level 101 is reached
     */
    void displayWin();
}
