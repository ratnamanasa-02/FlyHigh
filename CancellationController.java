package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class CancellationController implements Initializable {
    @FXML
    Button yes;
    @FXML
    Button no;
    @FXML
    Button home;
    @FXML
    Label name;
    @FXML
    private Label total;
    @FXML
    private Label dplace;
    @FXML
    private Label date;
    @FXML
    private Label stime;
    @FXML
    private Label rdate;
    @FXML
    private Label rplace;
    @FXML
    private Label seat;
    @FXML
    private Button goHome;
    @FXML
    Label TravellerClass;
    @FXML
    Button cancelTicket;

    Parent root;
    Scene scene;
    Stage stage;
    String userName;

    public void setUserName(String name){
        this.userName=name;
    }
    public String getUserName(){
        return userName;
    }
    public void yes(ActionEvent event) throws IOException {

        //deleting the values in sql
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "Update user_accounts Set number=" + null + " Where User_Name='" + userName + "';";
        String connectQuery1="Update user_accounts Set Dispatch_Date=" + null+ " , Return_date="+null+ " Where User_Name='" + userName + "';";
        String connectQuery2= "Update user_accounts Set Dispatch_Place=" + null+" , Return_Place="+null+ " Where User_Name='" + userName + "';";
        String connectQuery3= "Update user_accounts Set Ways=" + null+ " Where User_Name='" + userName + "';";
        String connectQuery4= "Update user_accounts Set class=" + null+ " Where User_Name='" + userName + "';";
        String connectQuery5= "Update user_accounts Set Flight=" + null+ " Where User_Name='" + userName + "';";
        String connectQuery6= "Update user_accounts Set time=" + null+ " Where User_Name='" + userName + "';";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectQuery);
            statement.executeUpdate(connectQuery1);
            statement.executeUpdate(connectQuery2);
            statement.executeUpdate(connectQuery3);
            statement.executeUpdate(connectQuery4);
            statement.executeUpdate(connectQuery5);
            statement.executeUpdate(connectQuery6);
        } catch (Exception e) {
            e.printStackTrace();
        }


        FXMLLoader loader=new FXMLLoader(getClass().getResource("Cancellation2.fxml"));
        root=loader.load();

        CancellationController CancellationController=loader.getController();
        CancellationController.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void home(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
        root=loader.load();

        MainController mainController=loader.getController();
        mainController.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void no(ActionEvent event){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String connectQuery="select ways from user_accounts where user_name='"+userName+"';";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(connectQuery);
            while(queryResult.next()){
                int ways=queryResult.getInt("ways");
                if(ways==1){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("Cancellation.fxml"));
                    root=loader.load();

                    CancellationController CancellationController=loader.getController();
                    CancellationController.setUserName(userName);
                    CancellationController.init();
                    stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                if(ways==2){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("Cancellation3.fxml"));
                    root=loader.load();

                    CancellationController CancellationController=loader.getController();
                    CancellationController.setUserName(userName);
                    CancellationController.init();
                    stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void cancelTicket(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Cancellation1.fxml"));
        root=loader.load();

        CancellationController CancellationController=loader.getController();
        CancellationController.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void init(){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String connectQuery="select * from user_accounts where user_name='"+userName+"';";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(connectQuery);
            while(queryResult.next()){
                int ways=queryResult.getInt("ways");
                if(ways==1){
                    name.setText(queryResult.getString("first_name")+" "+queryResult.getString("last_Name"));
                    total.setText(String.valueOf(queryResult.getInt("number")));
                    dplace.setText(queryResult.getString("dispatch_place"));
                    stime.setText(queryResult.getString("time"));
                    date.setText((queryResult.getDate("dispatch_date")).toString());
                    seat.setText(queryResult.getString("seats"));
                    TravellerClass.setText(queryResult.getString("class"));
                }
                if(ways==2){
                    name.setText(queryResult.getString("first_name")+" "+queryResult.getString("last_Name"));
                    total.setText(String.valueOf(queryResult.getInt("number")));
                    dplace.setText(queryResult.getString("dispatch_place"));
                    rplace.setText(queryResult.getString("return_place"));
                    stime.setText(queryResult.getString("time"));
                    date.setText((queryResult.getDate("dispatch_date")).toString());
                    rdate.setText((queryResult.getDate("return_date")).toString());
                    seat.setText(queryResult.getString("seats"));
                    TravellerClass.setText(queryResult.getString("class"));
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }
}
