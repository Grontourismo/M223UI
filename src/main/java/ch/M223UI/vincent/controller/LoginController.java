package ch.M223UI.vincent.controller;


import ch.M223UI.vincent.UIManager;
import ch.M223UI.vincent.connection.UserConnector;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends ControllerBase {
    public TextField emailTb;
    public PasswordField pwdTb;
    public Label label;

    public void registerClicked() {
        UIManager.register();
    }

    public void clicked() {
        String username = emailTb.getText();
        String pwd = pwdTb.getText();
        String msg = UserConnector.login(username, pwd);
        if (msg.equals("")){
            this.label.setText("Couldn't login");
        }else{
            UIManager.home();
        }
    }
}
