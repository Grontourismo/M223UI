package ch.M223UI.vincent.controller;

import ch.M223UI.vincent.connection.UserConnector;
import javafx.event.ActionEvent;
import javafx.scene.control.PasswordField;

public class ChangePWController extends ControllerBase{
    public PasswordField oldPwF;
    public PasswordField newPwF;

    public void send(ActionEvent actionEvent) {
        UserConnector.update(oldPwF.getText(), newPwF.getText());
    }
}
