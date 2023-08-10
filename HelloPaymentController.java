package com.example.demo3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class HelloPaymentController  {
    @FXML
    Label tax;
    @FXML
    Label price;
    @FXML
    Label number;
    @FXML
    Label total;
    String travellerClass;
    int numbers;

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

    public void init(){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String connectQuery="select * from user_accounts where user_name='"+userName+"';";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(connectQuery);
            while(queryResult.next()){
                numbers=queryResult.getInt("number");
                number.setText(String.valueOf(numbers)+" Travellers");
                tax.setText("₹"+String.valueOf(1034.34));
                travellerClass=queryResult.getString("class");

                double tot=20587*numbers+1034.34;
                price.setText("₹"+String.valueOf(20587));
                total.setText("₹"+String.valueOf(tot));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void switchToMain1(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Payment1.fxml"));
        root=loader.load();

        payment1Controller payment1Controller=loader.getController();
        payment1Controller.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToMain2(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Payment2.fxml"));
        root=loader.load();

        payment2Controller payment2Controller=loader.getController();
        payment2Controller.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMain3(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Payment3.fxml"));
        root=loader.load();

        payment3Controller payment3Controller=loader.getController();
        payment3Controller.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMain4(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Payment4.fxml"));
        root=loader.load();

        payment4Controller payment4Controller=loader.getController();
        payment4Controller.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPay(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Payment.fxml"));
        root=loader.load();

        Scene1Controller scene1Controller=loader.getController();
        scene1Controller.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}