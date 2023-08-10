package com.example.demo3;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.fxml.Initializable;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Label;
        import javafx.scene.control.RadioButton;
        import javafx.scene.control.Button;
        import javafx.event.Event;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.net.URL;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.Statement;
        import java.util.ResourceBundle;

public class flightTimingsController implements Initializable {
    @FXML
    Label lb1, lb7, lb3, lb4, lb5, lb6,lb8;
    @FXML
    RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8;
    @FXML
    Button b1;
    Parent root;
    Scene scene;
    Stage stage;

    String time;
    String flights;
    String userName;

    public void setUserName(String name){
        this.userName=name;
    }
    public String getUserName(){
        return userName;
    }


    public void getTime(ActionEvent event) {
        if (rb1.isSelected()) {
            time=rb1.getText();
        } else if (rb2.isSelected()) {
            time=rb2.getText();
        } else if (rb3.isSelected()) {
            time=rb3.getText();
        } else if (rb4.isSelected()) {
            time=rb4.getText();
        } else if (rb5.isSelected()) {
            time=rb5.getText();
        }
    }
    public void getWebsite(ActionEvent event){
        if (rb6.isSelected()){
            flights=rb6.getText();
        }
        else if(rb7.isSelected()){
            flights=rb7.getText();
        } else if (rb8.isSelected()){
            flights=rb8.getText();
        }
    }

    public void done(ActionEvent event){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "Update user_accounts Set FLIGHT='" + flights+ "' Where User_Name='" + userName + "';";
        String connectQuery1 = "Update user_accounts Set TIME='" + time+ "' Where User_Name='" + userName + "';";
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(connectQuery);
            statement.executeUpdate(connectQuery1);
            FXMLLoader loader=new FXMLLoader(getClass().getResource("seats.fxml"));
            root=loader.load();

            SeatsController SeatsController=loader.getController();
            SeatsController.setUserName(userName);
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToHome(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
        root=loader.load();

        MainController mainController=loader.getController();
        mainController.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
     void init(){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String connectQuery="select * from user_accounts where user_name='"+userName+"';";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(connectQuery);
            while(queryResult.next()){
                lb8.setText(queryResult.getString("dispatch_place"));
                lb7.setText(queryResult.getString("return_place"));
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