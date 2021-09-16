package ch.M223UI.vincent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
        UIManager.primaryStage = primaryStage;
        UIManager.secondaryStage = new Stage();
        UIManager.secondaryStage.initOwner(UIManager.primaryStage);
        UIManager.secondaryStage.initModality(Modality.APPLICATION_MODAL);
        UIManager.login();
    }

    public static void main(String[] args) {
        launch(args);
    }

        /*final String POST_PARAMS = "{\"username\": \"Grontourismo\", \"password\": \"pwd\"}";

        URL obj = new URL("http://localhost:8080/user/sign-up");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("Content-Type", "application/json");

        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        postConnection.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();


        URL obj1 = new URL("http://localhost:8080/auth/login");
        HttpURLConnection postConnection1 = (HttpURLConnection) obj1.openConnection();
        postConnection1.setRequestMethod("POST");
        postConnection1.setRequestProperty("Content-Type", "application/json");

        postConnection1.setDoOutput(true);
        OutputStream os1 = postConnection1.getOutputStream();
        os1.write(POST_PARAMS.getBytes());
        os1.flush();
        os1.close();
        BufferedReader in1 = new BufferedReader(
                new InputStreamReader(
                        postConnection1.getInputStream()));
        String inputLine1;


        String token="";
        while ((inputLine1 = in1.readLine()) != null){
            System.out.println(inputLine1);
            token = inputLine1;
        }
        in.close();
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(token);
        String t = (String) object.get("token");
        System.out.println(t);



        final String POST_PARAMS2 = "{\"name\": \"Ferien\", \"description\": \"Ist in den Ferien\", \"creator\": 1}";

        URL obj2 = new URL("http://localhost:8080/category");
        HttpURLConnection postConnection2 = (HttpURLConnection) obj2.openConnection();
        postConnection2.setRequestMethod("POST");
        postConnection2.setRequestProperty("Content-Type", "application/json");
        postConnection2.setRequestProperty("Authorization", t);

        postConnection2.setDoOutput(true);
        OutputStream os2 = postConnection2.getOutputStream();
        os2.write(POST_PARAMS2.getBytes());
        os2.flush();
        os2.close();
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(
                        postConnection2.getInputStream()));
        String inputLine2;

        while ((inputLine2 = in2.readLine()) != null)
            System.out.println(inputLine2);
        in.close();*/
}
