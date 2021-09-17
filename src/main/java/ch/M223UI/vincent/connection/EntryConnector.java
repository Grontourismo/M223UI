package ch.M223UI.vincent.connection;

import ch.M223UI.vincent.Data;
import ch.M223UI.vincent.domain.Entry;
import ch.M223UI.vincent.domain.User;
import com.google.gson.Gson;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

public class EntryConnector extends Connector{
    public static void getEntries(){
        try {
            URL obj = new URL(url+"/entries");
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer "+Data.jwt);

            connection.setDoOutput(true);
            OutputStream os1 = connection.getOutputStream();
            os1.flush();
            os1.close();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));
            String inputLine;


            String entryJSON="";
            while ((inputLine = in.readLine()) != null){
                entryJSON = inputLine;
            }
            in.close();
            System.out.println(entryJSON);
            Gson gson = new Gson();
            Data.entries = gson.fromJson(entryJSON, Entry[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
