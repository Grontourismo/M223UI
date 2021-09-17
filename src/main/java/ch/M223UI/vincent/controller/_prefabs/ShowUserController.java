package ch.M223UI.vincent.controller._prefabs;

import ch.M223UI.vincent.Data;
import ch.M223UI.vincent.UIManager;
import ch.M223UI.vincent.connection.UserConnector;
import ch.M223UI.vincent.domain.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ShowUserController {
    public TextField idTF;
    public TextField usernameTF;
    public PasswordField passwordField;
    public Label errorMsg;

    public void init(){
        User user = UserConnector.getUserData();
        idTF.setText(user.getId() + "");
        usernameTF.setText(user.getUsername());
        passwordField.setText(user.getPassword());
    }

    public void changePressed(ActionEvent actionEvent) {
        UIManager.changePW(this);
    }

    public void deletePressed(ActionEvent actionEvent) {
        if (!UserConnector.delete().equals("")){
            Data.logout();
        }else{
            errorMsg.setText("Couldn't delete User");
        }
    }
}
