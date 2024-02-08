package g54435.atl.MyJavaFx;

import g54435.atl.blackjack.utils.TerminalColor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PrintText extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private final BorderPane root = new BorderPane();
    private final HBox btnPanel = new HBox(10);
    private final Label lblTitle = new Label("Event Handling");
    private final TextArea txaMsg = new TextArea();
    private final Button btnInsert = new Button("Insert");
    private final TextField tfdCharacter = new TextField();
    private final Button btnQuit = new Button("Quit");


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Event HANDLEUR");
        root.setPadding(new Insets(10));

        lblTitle.setFont(Font.font("System", FontWeight.BOLD, 20));
        lblTitle.setTextFill(Color.DARKGREEN);
        BorderPane.setAlignment(lblTitle, Pos.CENTER);
        BorderPane.setMargin(lblTitle, new Insets(0,0,10,0));
        root.setTop(lblTitle);

        txaMsg.setWrapText(true);
        txaMsg.setPrefColumnCount(15);
        txaMsg.setPrefRowCount(10);
        root.setCenter(txaMsg);

        btnPanel.getChildren().add(btnInsert);
        btnPanel.getChildren().add(tfdCharacter);
        btnPanel.getChildren().add(btnQuit);
        btnPanel.setAlignment(Pos.CENTER_RIGHT);
        btnPanel.setPadding(new Insets(10,0,0,0));
        root.setBottom(btnPanel);

        InsertButtonHandler insertButtonHandler = new InsertButtonHandler(txaMsg,tfdCharacter);
        btnInsert.addEventHandler(ActionEvent.ACTION, insertButtonHandler);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
