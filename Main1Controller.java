package com.example.demo3;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Node;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.SplitMenuButton;
        import javafx.scene.layout.AnchorPane;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.Statement;

public class Main1Controller {

    @FXML
    Button homePageButton;
    @FXML
    Button bookTicketsButton;
    @FXML
    Button cancelTicketsButton;
    @FXML
    Button bookingInfoButton;
    @FXML
    SplitMenuButton loginSignUp;

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

    public void goToHome(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("Main.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
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
    public void bookingTickets(ActionEvent event) throws IOException{
//        root= FXMLLoader.load(getClass().getResource("Scenes1.fxml"));
//        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
//        scene=new Scene(root);
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("Scenes1.fxml"));
        root=loader.load();

        Scene1Controller scene1Controller=loader.getController();
        scene1Controller.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void cancelTickets(ActionEvent event){

    }
    public void bookingInfo(ActionEvent event) throws IOException {
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
}
