package com.example.demo3;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class payment2Controller {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField myTextField;
    @FXML
    private Label myLabel;
    @FXML
    Button upi;

    String userName;

    public void setUserName(String name){
        this.userName=name;
    }
    public String getUserName(){
        return userName;
    }

    public void switchToMain(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Main2.fxml"));
        Parent root=loader.load();

        HelloPaymentController helloPaymentController=loader.getController();
        helloPaymentController.setUserName(userName);
        helloPaymentController.init();
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToRedirect(ActionEvent event) throws IOException {
        if (myTextField.getText().trim().equals("")) {
            myLabel.setText("Please fill the details");
        } else {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Redirect.fxml"));
            root=loader.load();

            HelloPaymentController helloPaymentController=loader.getController();
            helloPaymentController.setUserName(userName);
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}