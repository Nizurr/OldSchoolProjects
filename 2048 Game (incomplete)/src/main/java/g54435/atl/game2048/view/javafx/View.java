package g54435.atl.game2048.view.javafx;

import g54435.atl.game2048.controller.Controller;
import g54435.atl.game2048.model.Board;
import g54435.atl.game2048.model.Direction;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * View of the game
 */
public class View implements EventHandler<KeyEvent> {
    private Stage stage;
    private Scene scene;
    private GameGrid gameGrid = new GameGrid();
    private Controller controller;
    private BorderPane borderPane = new BorderPane();
    private ListView<String> listView = new ListView<>();
    private Button button = new Button();

    /**
     * Constructor of the view
     * @param stage need the stage given by launch method in MainView
     * @param c need the controller (to give directions)
     */
    public View(Stage stage, Controller c) {
        this.controller = c;
        this.stage = stage;
        initButtonRestart();
        initScene();
        initListView();
        this.scene = new Scene(this.borderPane);
        this.stage.setScene(this.scene);
        this.stage.show();
        this.scene.setOnKeyPressed(this); //Capture du clavier

    }

    /**
     * refreshing the board
     * @param board board of the game to set on the visual.
     */
    public void displayBoard(Board board) {
        gameGrid.refreshBoard(board);
    }

    /**
     * Add a message given by the controller to set in the messageList
     * @param s message to set
     */
    public void addMsgToList(String s) {
        if (this.listView.getItems().size() == 9) {
            this.listView.getItems().remove(0);
        }
        this.listView.getItems().add(s);
    }

    /**
     * Initialize the listView
     */
    private void initListView() {
        this.borderPane.setRight(this.listView);
        this.listView.setMaxHeight(205);
        this.listView.setPrefWidth(205);
        this.listView.setMouseTransparent(true);
        this.listView.setFocusTraversable(false);
        this.listView.setFixedCellSize(22.5);
    }

    /**
     * Initialize the scene
     */
    private void initScene() {
        this.borderPane.setLeft(this.gameGrid.getGameGrid());
        this.borderPane.setPadding(new Insets(20, 5, 0, 15));
        this.borderPane.setStyle("-fx-background-color: #BBADA0;");
        this.stage.setTitle("HE2B ESI - 2048 - G54435");
        this.stage.setHeight(315);
        this.stage.setWidth(450);
        this.stage.setResizable(false);

    }

    /**
     * Initialize the restart Button
     */
    private void initButtonRestart() {
        this.borderPane.setBottom(this.button);
        this.button.setPrefWidth(150);
        this.button.setTranslateX(125);
        this.button.setTranslateY(-13);
        this.button.setOnKeyPressed(this);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                listView.getItems().clear();
                controller.restart();
            }
        };
        this.button.setOnAction(event);

        this.button.setText("Rédémarrer le jeu");


    }

    /**
     * Handler of the keyboard to making move
     * @param event event given by EventHandler
     */
    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP:
                this.controller.move(Direction.UP);
                break;
            case DOWN:
                this.controller.move(Direction.DOWN);
                break;
            case LEFT:
                this.controller.move(Direction.LEFT);
                break;
            case RIGHT:
                this.controller.move(Direction.RIGHT);
                break;
            default:
                System.out.println("bad key");
                break;
        }
    }

}
