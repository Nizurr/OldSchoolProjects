package g54435.humbug.controller;

import g54435.humbug.model.*;
import g54435.humbug.view.text.InterfaceView;

/**
 * Project projet-humbug
 * The controller is responsible for the dynamics of the game,
 * updating it and the view as the game progresses
 *
 * @author Adnane Azaoum / G54435 / 54435@etu.he2b.be
 */
public class Controller {

    /**
     * Represent the model
     */

    private Model game;
    /**
     * Represent the view
     */
    private InterfaceView view;

    /**
     * Constructor of Controller
     *
     * @param game the model
     * @param view the view.
     */
    public Controller(Model game, InterfaceView view) {
        this.game = game;
        this.view = view;
    }

    /**
     * the start method takes care of playing
     */
    public void startGame(int nLevel) {
        if (nLevel == 41) {
            startGame(100);
        }
        if (nLevel == 101) {
            view.displayWin();
        }
        if (nLevel <= 100) {
            game.startLevel(nLevel);
            while (game.getLevelStatus() != LevelStatus.FAIL && game.getLevelStatus() != LevelStatus.WIN) {
                int moves = game.getRemainingMoves();
                view.displayBoard(game.getBoard(), nLevel, moves, game.getAnimals());
                Position pos = view.askPosition();
                Direction dir = view.askDirection();

                try {
                    game.move(pos, dir);
                    if (game.getLevelStatus() == LevelStatus.WIN) {
                        startGame(nLevel + 1);

                    } else if (game.getLevelStatus() == LevelStatus.FAIL) {
                        System.out.println("Perdu !");
                        startGame(nLevel);
                    }
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae);
                }

            }
        }


    }
}
