package ch.M223UI.vincent.controller;

import ch.M223UI.vincent.Data;
import ch.M223UI.vincent.controller._prefabs.ShowEntriesController;
import ch.M223UI.vincent.controller._prefabs.ShowUserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeController extends ControllerBase{
    public AnchorPane pane;

    public void init(){
        pane.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(ShowEntriesController.class.getClassLoader().getResource("views/_prefabs/showEntries.fxml"));
            Parent root = loader.load();
            ShowEntriesController controller = loader.getController();
            controller.init();
            pane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void entries() {
        pane.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(ShowEntriesController.class.getClassLoader().getResource("fxml/_prefabs/showEntries.fxml"));
            Parent root = loader.load();
            ShowEntriesController controller = loader.getController();
            controller.init();
            pane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void user() {
        pane.getChildren().clear();
        try {
            FXMLLoader loader = new FXMLLoader(ShowUserController.class.getClassLoader().getResource("fxml/_prefabs/showUser.fxml"));
            Parent root = loader.load();
            ShowUserController controller = loader.getController();
            controller.init();
            pane.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void categories(ActionEvent actionEvent) {
    }

    public void tags(ActionEvent actionEvent) {
    }

    public void logout(ActionEvent actionEvent) {
        Data.logout();
    }
}
