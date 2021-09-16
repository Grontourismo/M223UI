package ch.M223UI.vincent;

public class Data {
    public static String jwt;

    public static void logout(){
        jwt = "";
        UIManager.secondaryStage.close();
        UIManager.primaryStage.close();
    }
}
