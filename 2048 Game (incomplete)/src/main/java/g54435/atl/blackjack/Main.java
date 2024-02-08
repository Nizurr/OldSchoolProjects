package g54435.atl.blackjack;

import g54435.atl.blackjack.controller.Controller;
import g54435.atl.blackjack.model.Game;
import g54435.atl.blackjack.view.text.View;

/**
 * Main Class
 */
public class Main {

    public static void main(String[] args) {
        Controller ctrl = new Controller(new Game(), new View());
        ctrl.newGame();
    }


}
