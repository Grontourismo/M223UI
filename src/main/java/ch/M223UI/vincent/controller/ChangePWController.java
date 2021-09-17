package ch.M223UI.vincent.controller;

import ch.M223UI.vincent.UIManager;
import ch.M223UI.vincent.connection.UserConnector;
import ch.M223UI.vincent.controller._prefabs.ShowUserController;
import ch.M223UI.vincent.domain.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class ChangePWController extends ControllerBase {
    public PasswordField oldPwF;
    public PasswordField newPwF;
    public ShowUserController controller;
    public Label label;

    public void init(ShowUserController controller) {
        this.controller = controller;
    }

    public void send(ActionEvent actionEvent) {
        if (!oldPwF.getText().equals(newPwF.getText())) {
            User user = UserConnector.update(oldPwF.getText(), newPwF.getText());
            if (user.getUsername() != null){
                UIManager.secondaryStage.close();
                controller.init();
            }else{
                label.setText("Couldn't change PW");
            }
        } else {
            label.setText("New is same as old");
        }
    }
}
