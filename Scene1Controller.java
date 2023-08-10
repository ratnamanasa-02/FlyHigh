package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.ResourceBundle;


public class Scene1Controller implements Initializable {
    @FXML
    RadioButton myOne;
    @FXML
    RadioButton myRound;
    @FXML
    RadioButton myMulti;
    @FXML
    WebView myWebView;
    @FXML
    TextField dispatchPlace;
    @FXML
    TextField destinationPlace;
    @FXML
    Label myDateLabel;
    @FXML
    Label myDateLabel1;
    @FXML
    DatePicker oneWayDate;
    @FXML
    DatePicker oneWayDate1;
    @FXML
    Button myBookTickets;
    @FXML
    Button adult;
    @FXML
    Button children;
    @FXML
    Button infant;
    @FXML
    AnchorPane scenePane;
    @FXML
    Button homePageButton;
    @FXML
    Button bookTicketsButton;
    @FXML
    Button cancelTicketsButton;
    @FXML
    Button bookingInfoButton;
    @FXML
    SplitMenuButton childrenSplitButton;
    @FXML
    SplitMenuButton adultSplitButton;
    @FXML
    SplitMenuButton infantSplitButton;
    @FXML
    Button goHome;
    @FXML
    RadioButton bussiness;
    @FXML
    RadioButton economy;
    @FXML
    RadioButton premiumEconomy;
    @FXML
    TextField adultTextField;
    @FXML
    TextField childrenTextField;
    @FXML
    TextField infantTextField;
    @FXML
    Label travellerInfoLabel;
    @FXML
    SplitMenuButton loginSignUp;
    @FXML
    Button printTicket;
    @FXML
    VBox vBoxPane;

//    @FXML
//    Button loginLink;
//    @FXML
//    Button signUpLink;
//    @FXML
//    Button loginButton;
//    @FXML
//    Button signUpButton;
//    @FXML
//    TextField userNameTextField;
//    @FXML
//    PasswordField passTextField;
//    @FXML
//    Label signUpLabel;
//    @FXML
//    Label loginLabel;
//    @FXML
//    TextField lastNameTextField;
//    @FXML
//    TextField firstNameTextField;
//    @FXML
//    PasswordField confirmPasswordField;


    private Stage stage;
    private Scene scene;
    private Parent root;
    String destPlace;
    String disPlace;
    int adults;
    int childrens;
    int infants;
    int ways=1;
    String dispatchDate;
    String returnDate;
    String travellerClass;
    String userName;

    public void setUserName(String name){
        this.userName=name;
    }
    public String getUserName(){
        return userName;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void goToHome(ActionEvent event) throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
        root=loader.load();

        MainController mainController=loader.getController();
        mainController.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void goToLogin(ActionEvent event) throws IOException {
//        root= FXMLLoader.load(getClass().getResource("Scenes3.fxml"));
//        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
    public void goToSignUp(ActionEvent event) throws IOException{
        root= FXMLLoader.load(getClass().getResource("Scenes2.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void bookingTickets(ActionEvent event) throws IOException{
//        root= FXMLLoader.load(getClass().getResource("Scenes1.fxml"));
//        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    public void cancelTickets(ActionEvent event){
//
//    }
//    public void bookingInfo(ActionEvent event){
//
//    }

    public void disPlace(ActionEvent event){
        disPlace=dispatchPlace.getText();
    }
    public void destPlace(ActionEvent event){
        destPlace=destinationPlace.getText();
    }
    public void switchWay(ActionEvent event){
        disPlace=disPlace + destPlace;
        destPlace = disPlace.substring(0, (disPlace.length() - destPlace.length()));
        disPlace = disPlace.substring(destPlace.length());
        dispatchPlace.setText(disPlace);
        destinationPlace.setText(destPlace);
    }
    public void bookTickets(ActionEvent event) throws IOException {
//        Parent root= FXMLLoader.load(getClass().getResource("Scenes2.fxml"));
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();


        int sum=adults+infants+childrens;
        System.out.println(returnDate);
        System.out.println(dispatchDate);
        System.out.println(disPlace);
        if(userName!=null){
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.getConnection();

            String connectQuery = "Update user_accounts Set number=" + sum + " Where User_Name='" + userName + "';";
            String connectQuery1;
            String connectQuery2;
            String connectQuery3= "Update user_accounts Set Ways=" + ways+ " Where User_Name='" + userName + "';";
            String connectQuery4= "Update user_accounts Set class='" + travellerClass+ "' Where User_Name='" + userName + "';";
            if(returnDate!=null){
                connectQuery1 = "Update user_accounts Set Dispatch_Date='" + dispatchDate+ "' , Return_date='"+returnDate+ "' Where User_Name='" + userName + "';";
                connectQuery2 = "Update user_accounts Set Dispatch_Place='" + disPlace+"' , Return_Place='"+destPlace+ "' Where User_Name='" + userName + "';";
            }
            else{
                connectQuery1 = "Update user_accounts Set Dispatch_Date='" + dispatchDate+  "' Where User_Name='" + userName + "';";
                connectQuery2 = "Update user_accounts Set Dispatch_Place='" + disPlace+ "' Where User_Name='" + userName + "';";
            }
            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(connectQuery);
                statement.executeUpdate(connectQuery1);
                statement.executeUpdate(connectQuery2);
                statement.executeUpdate(connectQuery3);
                statement.executeUpdate(connectQuery4);
            } catch (Exception e) {
                e.printStackTrace();
            }

            FXMLLoader loader=new FXMLLoader(getClass().getResource("flightTimings.fxml"));
            root=loader.load();

            flightTimingsController flightTimingsController=loader.getController();
            flightTimingsController.setUserName(userName);
            flightTimingsController.init();
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login the page");
            alert.setHeaderText("Login or SignUp the Page");
            alert.setContentText("Do you want to login/signUp");
            if(alert.showAndWait().get()==ButtonType.OK){
                root= FXMLLoader.load(getClass().getResource("Scenes3.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }


    }
    public void getOneWayDate(ActionEvent event){
        LocalDate oneWayDateValue=oneWayDate.getValue();
        dispatchDate=oneWayDateValue.toString();
        String myformattedOneWayDate=oneWayDateValue.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
        myDateLabel.setText(myformattedOneWayDate);
    }
    public void getOneWayDate1(ActionEvent event){
        myRound.setSelected(true);
        LocalDate oneWayDateValue=oneWayDate1.getValue();
        returnDate=oneWayDateValue.toString();
        ways=2;
        String myformattedOneWayDate=oneWayDateValue.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
        myDateLabel1.setText(myformattedOneWayDate);
        System.out.println(ways);
    }
    //travellerClass
    public void bussiness(ActionEvent event){
        if(bussiness.isSelected()){
            travellerClass="bussiness";
            int sum=adults+infants+childrens;
            travellerInfoLabel.setText(sum+" number of Travellers\n"+travellerClass.toUpperCase()+" CLASS");
        }
    }
    public void economy(ActionEvent event){
        if(economy.isSelected()){
            travellerClass="economy";
            int sum=adults+infants+childrens;
            travellerInfoLabel.setText(sum+" number of Travellers\n"+travellerClass.toUpperCase()+" CLASS");
        }
    }
    public void premiumEconomy(ActionEvent event){
        if(premiumEconomy.isSelected()){
            travellerClass="premiumEconomy";
            int sum=adults+infants+childrens;
            travellerInfoLabel.setText(sum+" number of Travellers\n"+"PREMIUM ECONOMY");
        }
    }
    public void adultNumber(ActionEvent event) throws IOException {
        adults = Integer.valueOf(adultTextField.getText());
        int sum = adults + infants + childrens;
        if (travellerClass != null) {
            travellerInfoLabel.setText(sum + " number of Travellers\n" + travellerClass.toUpperCase() + " CLASS");
        }

    }
    public void childrenNumber(ActionEvent event){
        childrens=Integer.valueOf(childrenTextField.getText());
        int sum=adults+infants+childrens;
        if(travellerClass!=null){
            travellerInfoLabel.setText(sum+" number of Travellers\n"+travellerClass.toUpperCase()+" CLASS");
        }
    }
    public void infantNumber(ActionEvent event){
        infants=Integer.valueOf(infantTextField.getText());
        int sum=adults+infants+childrens;
        if(travellerClass!=null){
            travellerInfoLabel.setText(sum+" number of Travellers\n"+travellerClass.toUpperCase()+" CLASS");
        }
    }
    public void printTicket(ActionEvent event){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String connectQuery="select ways from user_accounts where user_name='"+userName+"';";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(connectQuery);
            while(queryResult.next()){
                int ways=queryResult.getInt("ways");
                System.out.println(ways);
                if(ways==1){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("ticketPrint.fxml"));
                    root=loader.load();

                    ticketPrintController ticketPrintController=loader.getController();
                    ticketPrintController.setUserName(userName);
                    stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                if(ways==2){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("ticketPrint1.fxml"));
                    root=loader.load();

                    ticketPrintController1 ticketPrintController1=loader.getController();
                    ticketPrintController1.setUserName(userName);
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

//    public void signUp(ActionEvent event) throws IOException {
//        if(userNameTextField.getText().isBlank()==false && passTextField.getText().isBlank()==false){
//            if(passTextField.getText().equals(confirmPasswordField.getText())) {
//                //Connecting to database
//                DatabaseConnection connectNow = new DatabaseConnection();
//                Connection connectDB = connectNow.getConnection();
//
//                String connectQuery = "Insert into user_accounts(First_Name,Last_Name,User_Name,Password) values('" + firstNameTextField.getText() + "','" + lastNameTextField.getText() + "','" + userNameTextField.getText() + "','" + passTextField.getText() + "');";
//                try {
//                    Statement statement = connectDB.createStatement();
//                    statement.executeUpdate(connectQuery);
//
//                    root = FXMLLoader.load(getClass().getResource("logged.fxml"));
//                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                    scene = new Scene(root);
//                    stage.setScene(scene);
//                    stage.show();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            else{
//                signUpLabel.setText("Password does not match");
//            }
//        }
//        else{
//            signUpLabel.setText("Enter the fields");
//        }
//    }
//    public void login(ActionEvent event) throws IOException {
//        if(userNameTextField.getText().isBlank()==false && passTextField.getText().isBlank()==false){
//            //Passing variables
//            FXMLLoader loader=new FXMLLoader(getClass().getResource("Scenes1.fxml"));
//            Parent root1=(Parent) loader.load();
//
//            Scene1Controller scene1Controller=loader.getController();
//            scene1Controller.setUserName(userNameTextField.getText());
//
//
//            //Connecting to database
//            DatabaseConnection connectNow=new DatabaseConnection();
//            Connection connectDB=connectNow.getConnection();
//
//            String connectQuery="Select count(1) from USER_ACCOUNTS where USER_name='"+userNameTextField.getText()+"' And PASSWORD='"+passTextField.getText()+"'";
//            try{
//                Statement statement=connectDB.createStatement();
//                ResultSet queryResult=statement.executeQuery(connectQuery);
//                while(queryResult.next()){
//                    if(queryResult.getInt(1)==1){
//                        userName=userNameTextField.getText();
//                        root= FXMLLoader.load(getClass().getResource("logged.fxml"));
//                        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//                        scene=new Scene(root);
//                        stage.setScene(scene);
//                        stage.show();
//                    }
//                    else{
//                        loginLabel.setText("login invalid");
//                    }
//                }
//            }
//            catch(Exception e){
//                e.printStackTrace();
//            }
//        }
//        else{
//            loginLabel.setText("Enter the fields");
//        }
//    }

}