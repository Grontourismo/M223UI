package ch.M223UI.vincent;

import ch.M223UI.vincent.controller.ControllerBase;
import ch.M223UI.vincent.controller._prefabs.ShowEntriesController;
import ch.M223UI.vincent.controller._prefabs.ShowUserController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UIManager {
    public static Stage primaryStage;
    public static Stage secondaryStage;

    private static ControllerBase loadScene(Stage stage, String path, String title) {
        FXMLLoader loader = new FXMLLoader(Main.class.getClassLoader().getResource(path));
        try {
            Parent root = loader.load();
            stage.setTitle(title);
            Scene scene = new Scene(root);
            scene.getStylesheets().add("darkmode.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException ignored) {
        }
        return loader.getController();
    }

    public static void login() {
        loadScene(primaryStage, "fxml/login.fxml", "Login");
    }

    public static void register() {
        loadScene(primaryStage, "fxml/register.fxml", "Register");
    }

    public static void home() {
        loadScene(primaryStage, "fxml/home.fxml", "Home");
    }

    public static void showUser() {
        loadScene(primaryStage, "fxml/home.fxml", "Home").user();
    }

    public static void changePW(ShowUserController controller) {
        loadScene(secondaryStage, "fxml/changePW.fxml", "Change Password").init(controller);
    }
}
