package g54435.humbug;

import g54435.humbug.controller.Controller;
import g54435.humbug.model.Game;
import g54435.humbug.view.text.View;

/**
 * Project projet-humbug
 * Main Class
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new Game() , new View());
        controller.startGame(1);


    }
}
