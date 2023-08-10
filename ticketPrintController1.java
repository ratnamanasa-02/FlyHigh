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

        import static javax.swing.UIManager.getString;

public class ticketPrintController1 implements Initializable {
    @FXML
    private Label name;
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
    Button getTicket;
    @FXML
    Label TravellerClass;


    private Parent root;
    private Scene scene;
    private Stage stage;
    String userName;

    public void setUserName(String name){
        this.userName=name;
    }
    public String getUserName(){
        return userName;
    }

//    public void init(){
//        userName=getUserName();
//        System.out.println(userName);
//        DatabaseConnection connectNow=new DatabaseConnection();
//        Connection connectDB=connectNow.getConnection();
//
//        String connectQuery="select dispatch_date from user_accounts where user_name='"+userName+"';";
//        try{
//            Statement statement=connectDB.createStatement();
//            ResultSet queryResult=statement.executeQuery(connectQuery);
//            while(queryResult.next()){
//                rdate.setText(String.valueOf(queryResult));
//                System.out.println(queryResult);
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//        name.setText("hiii");
//        total.setText(String.valueOf(6));
//        dplace.setText("hello");
//
//        stime.setText(String.valueOf(6));
//        rdate.setText(String.valueOf(6));
//        rplace.setText("place");
//        seat.setText("seating");
//    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //init();
    }
    public void getTicket(ActionEvent event){
        System.out.println(userName);
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();

        String connectQuery="select * from user_accounts where user_name='"+userName+"';";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(connectQuery);
            while(queryResult.next()){
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
        catch (Exception e){
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
}