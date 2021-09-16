package ch.M223UI.vincent.connection;
import ch.M223UI.vincent.Data;
import ch.M223UI.vincent.domain.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class UserConnector extends Connector{
    public static String delete(){
        String msg = "";
        try {
            URL obj = new URL(url+"/user");
            HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("DELETE");
            postConnection.setRequestProperty("Content-Type", "application/json");
            postConnection.setRequestProperty("Authorization", Data.jwt);

            postConnection.setDoOutput(true);
            OutputStream os = postConnection.getOutputStream();
            os.flush();
            os.close();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            postConnection.getInputStream()));
            String inputLine;

            String userJson = null;
            while ((inputLine = in.readLine()) != null) {
                userJson = inputLine;
            }
            System.out.println(userJson);

            if (userJson != null){
                msg = "Success!!!";
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }

    public static User register(String username, String password){
        final String POST_PARAMS = "{\"username\": \""+ username +"\", \"password\": \""+ password +"\"}";
        User user = null;
        try {
            URL obj = new URL(url+"/user/sign-up");
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

            String userJson = null;
            while ((inputLine = in.readLine()) != null) {
                userJson = inputLine;
            }
            System.out.println(userJson);

            Gson gson = new Gson();
            user = gson.fromJson(userJson, User.class);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static String login(String username, String password){
        final String POST_PARAMS = "{\"username\": \""+ username +"\", \"password\": \""+ password +"\"}";
        String msg = "";
        try {
            URL obj = new URL(url+"/auth/login");
            HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
            postConnection.setRequestMethod("POST");
            postConnection.setRequestProperty("Content-Type", "application/json");

            postConnection.setDoOutput(true);
            OutputStream os1 = postConnection.getOutputStream();
            os1.write(POST_PARAMS.getBytes());
            os1.flush();
            os1.close();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            postConnection.getInputStream()));
            String inputLine;


            String tokenJSON="";
            while ((inputLine = in.readLine()) != null){
                tokenJSON = inputLine;
            }
            in.close();

            System.out.println(tokenJSON);

            String token = getToken(tokenJSON);
            Data.jwt = token;
            msg = token;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return msg;
    }

    private static String getToken(String token) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(token);
        return (String) object.get("token");
    }
}
