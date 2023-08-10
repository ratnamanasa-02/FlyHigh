package com.example.demo3;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotResult;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        try{
            Scene scene1=new Scene(FXMLLoader.load(getClass().getResource("Main.fxml")));
            String css=this.getClass().getResource("application.css").toExternalForm();
            scene1.getStylesheets().add(css);

//            Image icon = new Image("aero.png");
//            stage.getIcons().add(icon);
            stage.setTitle("Mini Airlines");
            stage.setScene(scene1);
            stage.show();

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        launch();
    }
}