package com.rizal.app;

import com.rizal.MongoUtil;
import com.rizal.cafe.Cafe;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Main extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception, SQLException {

        MainMenu mainMenu = new MainMenu();
        mainMenu.showMain();

    }
}
