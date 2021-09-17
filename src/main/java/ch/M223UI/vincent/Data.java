package ch.M223UI.vincent;

import ch.M223UI.vincent.domain.Entry;

import java.util.ArrayList;

public class Data {
    public static String jwt;
    public static Entry[] entries;

    public static void logout(){
        jwt = "";
        UIManager.secondaryStage.close();
        UIManager.login();
    }
}
