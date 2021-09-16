package ch.M223UI.vincent.controller;

import ch.M223UI.vincent.UIManager;
import ch.M223UI.vincent.connection.UserConnector;
import ch.M223UI.vincent.domain.User;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController extends ControllerBase{
    public TextField usernameTb;
    public PasswordField pwdTb;
    public Label errorMSG;

    public void haveAccountClicked() {
        UIManager.login();
    }

    public void registerClicked() {
        String username = usernameTb.getText();
        String pwd = pwdTb.getText();
        User user = UserConnector.register(username, pwd);
        if (user==null){
            errorMSG.setText("Couldnt create User");
        }else{
            UIManager.login();
        }
    }
}
