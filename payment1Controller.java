package com.example.demo3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class payment1Controller implements Initializable{

    @FXML
    private Label myLabel;
    @FXML
    private TextField myTextField;
    @FXML
    private TextField myTextField2;
    @FXML
    private Label myLabel3;
    @FXML
    private PasswordField myTextField3;
    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private ChoiceBox<String> myChoiceBox1;

    private Stage stage;
    private Scene scene;
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
    public void switchToPayment(ActionEvent event) throws IOException {
    	if(myTextField.getText().trim().equals("")|| myTextField2.getText().trim().equals("")|| myTextField3.getText().trim().equals("")) {
            myLabel.setText("Plese fill the details");
        }
    	else{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Payment.fxml"));
            Parent root=loader.load();

            Scene1Controller scene1Controller=loader.getController();
            scene1Controller.setUserName(userName);
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
    	}
    }
   
    private String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    private String[] years = {"2023","2024","2025","2026","2027","2028","2029","2030"};
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	myChoiceBox.getItems().addAll(months);
        myChoiceBox1.getItems().addAll(years);
    }
}
