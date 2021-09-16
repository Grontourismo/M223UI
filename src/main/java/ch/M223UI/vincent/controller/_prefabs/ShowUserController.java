package ch.M223UI.vincent.controller._prefabs;

import ch.M223UI.vincent.Data;
import ch.M223UI.vincent.connection.UserConnector;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ShowUserController {
    public TextField idTF;
    public TextField usernameTF;
    public PasswordField passwordField;
    public Label errorMsg;

    public void changePressed(ActionEvent actionEvent) {
    }

    public void deletePressed(ActionEvent actionEvent) {
        if (!UserConnector.delete().equals("")){
            Data.logout();
        }else{
            errorMsg.setText("Couldn't delete User");
        }
    }
}
