package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class loginSignUpController {
    Button loginLink;
    @FXML
    Button signUpLink;
    @FXML
    Button loginButton;
    @FXML
    Button signUpButton;
    @FXML
    TextField userNameTextField;
    @FXML
    PasswordField passTextField;
    @FXML
    Label signUpLabel;
    @FXML
    Label loginLabel;
    @FXML
    TextField lastNameTextField;
    @FXML
    TextField firstNameTextField;
    @FXML
    PasswordField confirmPasswordField;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void goToLogin(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Scenes3.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void goToSignUp(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("Scenes2.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void login(ActionEvent event) throws IOException {
        if(userNameTextField.getText().isBlank()==false && passTextField.getText().isBlank()==false){
            //pass

            //Connecting to database
            DatabaseConnection connectNow=new DatabaseConnection();
            Connection connectDB=connectNow.getConnection();

            String connectQuery="Select count(1) from USER_ACCOUNTS where USER_name='"+userNameTextField.getText()+"' And PASSWORD='"+passTextField.getText()+"'";
            try{
                Statement statement=connectDB.createStatement();
                ResultSet queryResult=statement.executeQuery(connectQuery);
                while(queryResult.next()){
                    if(queryResult.getInt(1)==1){

                        //Passing variables
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
                        root=loader.load();

                        MainController mainController=loader.getController();
                        String userName=userNameTextField.getText();
                        mainController.setUserName(userName);
                        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
                        scene=new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                    else{
                        loginLabel.setText("login invalid");
                    }
                }
//                root= FXMLLoader.load(getClass().getResource("logged.fxml"));
//                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//                scene=new Scene(root);
//                stage.setScene(scene);
//                stage.show();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            loginLabel.setText("Enter the fields");
        }

    }

    public void signUp(ActionEvent event) throws IOException {
        if(userNameTextField.getText().isBlank()==false && passTextField.getText().isBlank()==false){
            if(passTextField.getText().equals(confirmPasswordField.getText())) {
                //Connecting to database
                DatabaseConnection connectNow = new DatabaseConnection();
                Connection connectDB = connectNow.getConnection();

                String connectQuery = "Insert into user_accounts(First_Name,Last_Name,User_Name,Password) values('" + firstNameTextField.getText() + "','" + lastNameTextField.getText() + "','" + userNameTextField.getText() + "','" + passTextField.getText() + "');";
                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(connectQuery);

                    FXMLLoader loader=new FXMLLoader(getClass().getResource("signedUp.fxml"));
                    root=loader.load();

                    Scene1Controller Scene1Controller=loader.getController();
                    String userName=userNameTextField.getText();
                    Scene1Controller.setUserName(userName);
                    stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();

//                    root = FXMLLoader.load(getClass().getResource("signedUp.fxml"));
//                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                    scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                signUpLabel.setText("Password does not match");
            }
        }
        else{
            signUpLabel.setText("Enter the fields");
        }
    }
}
