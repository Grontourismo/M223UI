package ch.M223UI.vincent.controller._prefabs;

import ch.M223UI.vincent.Data;
import ch.M223UI.vincent.connection.EntryConnector;
import ch.M223UI.vincent.domain.Entry;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import org.json.simple.parser.ParseException;
import tornadofx.control.DateTimePicker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowEntriesController {
    public DateTimePicker checkIn;
    public DateTimePicker checkOut;
    public ChoiceBox category;
    public ChoiceBox tag;
    public VBox vbox;

    public void init(){
        EntryConnector.getEntries();
        for(int i = 0; i < Data.entries.length; i++){
            Entry entry = Data.entries[i];

        }
    }

    public void send(ActionEvent actionEvent) {
    }
}
