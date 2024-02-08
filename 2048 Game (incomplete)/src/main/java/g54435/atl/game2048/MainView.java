package g54435.atl.game2048;

import g54435.atl.game2048.controller.Controller;
import g54435.atl.game2048.model.Game;
import g54435.atl.game2048.view.javafx.View;
import javafx.application.Application;

import javafx.stage.Stage;

/**
 * Main Class
 */
public class MainView extends Application {
    private View v;
    private Game game;
    private Controller c;
    private Stage stage;

    /**
     * Main Method
     * @param args args
     */
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.game = new Game();
        this.c = new Controller(this.game);
        this.v = new View(this.stage, this.c);
        this.c.addView(this.v);
        c.startGame();

    }


}
