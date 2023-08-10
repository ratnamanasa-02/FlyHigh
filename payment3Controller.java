package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class payment3Controller implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;
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
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Redirect.fxml"));
        root=loader.load();

        HelloPaymentController helloPaymentController=loader.getController();
        helloPaymentController.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private ChoiceBox<String> myChoiceBox5;
    private String[] Banks = {"Andhra Bank","Axis Bank","Bank of Baroda","Bank of India","Canara Bank","HDFC Bank","ICICI Netbanking","IDFC Bank","Indian Bank","State Bank of India","Union Bank of India"};
    @Override
    public void initialize(URL arg2, ResourceBundle arg3) {
    	myChoiceBox5.getItems().addAll(Banks);
    }
    @FXML
    private RadioButton rButton1, rButton2, rButton3, rButton4;
    	 
    public void getBank(ActionEvent event) {
    	  
    	if(rButton1.isSelected()) {}
    	else if(rButton1.isSelected()) {}
    	else if(rButton2.isSelected()) {}
    	else if(rButton3.isSelected()) {}
    	else if(rButton4.isSelected()) {}
    }
}
