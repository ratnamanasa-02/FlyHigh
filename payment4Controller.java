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
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class payment4Controller implements Initializable {

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
        root=loader.load();

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
        helloPaymentController.init();
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private ChoiceBox<String> myChoiceBox;
    private String[] Wallets = {"FREECHARGE","MOBIKWIK","PAYTM","PHONEPE","ICASH","Airtel Money","PayZapp"};
    @Override
    public void initialize(URL arg2, ResourceBundle arg3) {
    	myChoiceBox.getItems().addAll(Wallets);
    }
    @FXML
    private ImageView myImageView;
    @FXML
    private ImageView myImageView2;
    @FXML
    private ImageView myImageView3;
    @FXML
    private ImageView myImageView4;
    @FXML
    private ImageView myImageView5;


}