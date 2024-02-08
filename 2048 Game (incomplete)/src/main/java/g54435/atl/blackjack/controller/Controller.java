package g54435.atl.blackjack.controller;

import g54435.atl.blackjack.model.Game;
import g54435.atl.blackjack.model.LevelStatus;
import g54435.atl.blackjack.view.text.View;

/**
 * Controller
 */
public class Controller {

    /**
     * Game of the Blackjack
     */
    private Game game;
    /**
     * View of the Blackjack
     */
    private View view;


    /**
     * Constroller Constructer
     * @param game Game of the Blackjack
     * @param view View of the Blackjack
     */
    public Controller(Game game, View view) {
        this.game = game;
        this.view = view;
    }


    /**
     * Start a new Game.
     */
    public void newGame() {
        this.view.welcome();
        this.game.startGame();

        while (this.game.getLevelStatus() == LevelStatus.IN_PROGRESS) {
            this.view.Table(this.game, this.game.getBank(),this.game.getPlayer());
            //String askOrHit = this.view.askHitOrStand();
            if (!this.view.wantToStop()) {
                this.game.giveCardToPlayer();
                //System.out.println(this.game.countPoints());
            } else {
                this.view.messageTourOfBank();
                this.game.setLevelStatus(LevelStatus.PLAYERSTOP);
                this.game.dealCardsToBank();
            }

        }
            this.view.Table(this.game, this.game.getBank(),this.game.getPlayer());
            if (this.game.getLevelStatus() == LevelStatus.WIN) this.view.winMessage();
            else if (this.game.getLevelStatus() == LevelStatus.EQUALITY) this.view.equalityMessage();
            else if (this.game.getLevelStatus() == LevelStatus.FAIL) this.view.failMessage();
    }
}
