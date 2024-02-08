package g54435.atl.MyJavaFx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;


public class HelloWorld extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Appli");
        BorderPane root = new BorderPane();
        Label helloText = new Label();
        helloText.setText("ok");
        helloText.setTextFill(Color.RED);
        helloText.setFont(Font.font("Verdana", 20));
        helloText.setUnderline(true);

        System.out.println("Le message du Libellé est " + helloText.getText());
        System.out.println("la couleur du Libellé est " + helloText.getTextFill());
        System.out.println("La police du lib est " + helloText.getFont());

        root.setCenter(helloText);
        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    */

    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Appli");
        BorderPane root = new BorderPane();

        CheckBox cb1 = new CheckBox();
        cb1.setText("First");
        cb1.setSelected(true);

        CheckBox cb2 = new CheckBox("Second");
        cb2.setIndeterminate(true);

        CheckBox cb3 = new CheckBox("Thrid");
        cb3.setAllowIndeterminate(true);

        root.setLeft(cb1);
        //BorderPane.setAlignment(cb1, Pos.CENTER);
        root.setCenter(cb2);
        root.setRight(cb3);
        //BorderPane.setAlignment(cb3, Pos.CENTER);

        Scene sc = new Scene(root, 250, 100);
        primaryStage.setScene(sc);
        primaryStage.show();
    }
     */


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Appli");
        BorderPane root = new BorderPane();
        Label username = new Label("Username");

        TextField tfdUserName = new TextField();
        tfdUserName.setPrefColumnCount(20);
        tfdUserName.setAlignment(Pos.CENTER_LEFT);

        root.setTop(username);
        BorderPane.setAlignment(username,Pos.CENTER);
        root.setCenter(tfdUserName);

        Scene scene = new Scene(root, 250, 100);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



