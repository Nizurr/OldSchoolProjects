package g54435.atl.MyJavaFx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class InsertButtonHandler implements EventHandler<ActionEvent> {
    private final TextArea textArea;
    private final TextField textField;

    public InsertButtonHandler(TextArea textArea, TextField textField) {
        this.textArea = textArea;
        this.textField = textField;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        textArea.appendText(textField.getText());
    }
}
