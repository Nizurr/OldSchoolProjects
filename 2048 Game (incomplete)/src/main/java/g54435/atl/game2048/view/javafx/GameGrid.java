package g54435.atl.game2048.view.javafx;


import g54435.atl.game2048.model.Board;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GameGrid extends GridPane {

    /**
     * GameGrid is the 4x4 grid visual of the game.
     */
    private GridPane gameGrid = new GridPane();

    /**
     * Constructor of the gameGrid
     */
    public GameGrid() {
    }


    /**
     * This method update the visual with the grid of the game.
     * @param board board of the game to set on the visual. (faut vraiment que je developpe mon anglais)
     */
    public void refreshBoard(Board board) {
        GridPane.setMargin(this.gameGrid, new Insets(55,50,50,50));
        int l = board.getHeigth();
        this.gameGrid.getChildren().clear();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                Rectangle r = new Rectangle(50, 50, 50, 50);
                r.setStroke(Color.web("#BBADA0"));

                switch (board.getValue(i, j)) {
                    case 0:
                        r.setFill(Color.web("#CDAA8B"));
                        break;
                    case 2:
                        r.setFill(Color.web("#EEE4DA"));
                        break;
                    case 4:
                        r.setFill(Color.web("#7A6D60"));
                        break;
                    case 8:
                        r.setFill(Color.web("#F65E3B"));
                        break;
                    case 16:
                        r.setFill(Color.web("#E79A76"));
                        break;
                    case 32:
                        r.setFill(Color.web("#F57C5F"));
                        break;
                    case 64:
                        r.setFill(Color.web("#F15B31"));
                        break;
                    case 128:
                        r.setFill(Color.web("#EDCF73"));
                        break;
                    case 256:
                        r.setFill(Color.web("#EDCC62"));
                        break;
                    case 512:
                        r.setFill(Color.web("#EDC850"));
                        break;
                    case 1024:
                    case 2048:
                        r.setFill(Color.web("#EDC53F"));
                        break;
                    default:
                        r.setFill(Color.web("#FFFFFF"));
                        break;
                }
                Text t = new Text(String.valueOf(board.getValue(i, j)));
                t.setFont(Font.font("Arial", FontWeight.BOLD,20));
                StackPane stackPane = new StackPane();
                stackPane.getChildren().addAll(r, t);
                this.gameGrid.add(stackPane, j, i);

            }
        }
    }


    /**
     * @return the GridPane
     */
    public GridPane getGameGrid() {
        return gameGrid;
    }
}
