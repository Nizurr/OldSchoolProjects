package g54435.atl.game2048.controller;

import g54435.atl.game2048.model.*;
import g54435.atl.game2048.view.javafx.View;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * The class Controller
 */
public class Controller {
    // The Model Interface Game
    private ModelInterface game;
    // The view
    private View view;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");


    /**
     * Constructor.
     *
     * @param game the game
     *             //* @param view the view
     */
    public Controller(Game game) {
        if (game == null) throw new IllegalArgumentException("Arguments excepted");
        this.game = game;
        game.setLevelStatus(LevelStatus.NOT_STARTED);
    }

    public void addView(View view) {
        //TODO check view args
        this.view = view;
    }

    /**
     * Start the game
     */
    public void startGame() {
        game.setLevelStatus(LevelStatus.IN_PROGRESS);
        game.getBoard().newTile();
        view.displayBoard(game.getBoard());
        this.view.addMsgToList(this.dtf.format(LocalDateTime.now()) + " Bienvenue sur le jeu 2048");


    }

    public void move(Direction dir) {
        boolean sameGrid = game.move(dir);
        view.displayBoard(game.getBoard());
        if (game.getLevelStatus() == LevelStatus.IN_PROGRESS) {
            view.displayBoard(game.getBoard());
            game.checkStatusAndEnd(sameGrid);
        }
        if (game.getLevelStatus() == LevelStatus.IN_PROGRESS && sameGrid) {
            this.view.addMsgToList(this.dtf.format(LocalDateTime.now()) + " Déplacement impossible");
        }
        else if (game.getLevelStatus() == LevelStatus.FAIL)
            this.view.addMsgToList(this.dtf.format(LocalDateTime.now()) + " PERDU ! Votre score : " + game.getScore());
        else if (game.getLevelStatus() == LevelStatus.WIN)
            this.view.addMsgToList(this.dtf.format(LocalDateTime.now()) + " WOW GG BOGOSS" + game.getScore());
        else {
            this.view.addMsgToList(this.dtf.format(LocalDateTime.now()) + " " + dir.toString() + " score : " + game.getScore());

        }

    }

    public void restart() {
        this.game.cleanGrid();
        startGame();

    }


}
