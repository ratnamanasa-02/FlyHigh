package com.example.demo3;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
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
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.ResourceBundle;

public class SeatsController{
    ArrayList<Integer> SeatNo = new ArrayList<>();
    private int clock1 = 0;
    private int clock2 = 0;
    private int clock3 = 0;
    private int clock4 = 0;
    private int clock5 = 0;
    private int clock6 = 0;
    private int clock7 = 0;
    private int clock8 = 0;
    private int clock9 = 0;
    private int clock10 = 0;
    private int clock11 = 0;
    private int clock12= 0;
    private int clock13= 0;
    private int clock14= 0;
    private int clock15= 0;
    private int clock16 = 0;
    private int clock17 = 0;
    private int clock18 = 0;
    private int clock19= 0;
    private int clock20 = 0;
    private int clock21= 0;
    private int clock22= 0;
    private int clock23= 0;
    private int clock24= 0;
    private int clock25= 0;
    private int clock26= 0;
    private int clock27= 0;
    private int clock28= 0;
    private int clock29= 0;
    private int clock30= 0;
    private int clock31= 0;
    private int clock32= 0;
    private int clock33= 0;
    private int clock34= 0;
    private int clock35= 0;
    private int clock36= 0;
    private int clock37= 0;
    private int clock38= 0;
    private int clock39= 0;
    private int clock40= 0;
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


    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button ten;
    @FXML
    private Button eleven;
    @FXML
    private Button twelve;
    @FXML
    private Button thirteen;
    @FXML
    private Button fourteen;
    @FXML
    private Button fiveteen;
    @FXML
    private Button sixteen;
    @FXML
    private Button seventeen;
    @FXML
    private Button eighteen;
    @FXML
    private Button ninteen;
    @FXML
    private Button twenty;
    @FXML
    private Button twentyone;
    @FXML
    private Button twentytwo;
    @FXML
    private Button twentythree;
    @FXML
    private Button twentyfour;
    @FXML
    private Button twentyfive;
    @FXML
    private Button twentysix;
    @FXML
    private Button twentyseven;
    @FXML
    private Button twentyeight;
    @FXML
    private Button twentynine;
    @FXML
    private Button thirty;
    @FXML
    private Button thirtyone;
    @FXML
    private Button thirtytwo;
    @FXML
    private Button thirtythree;
    @FXML
    private Button thirtyfour;
    @FXML
    private Button thirtyfive;
    @FXML
    private Button thirtysix;
    @FXML
    private Button thirtyseven;
    @FXML
    private Button thirtyeight;
    @FXML
    private Button thirtynine;
    @FXML
    private Button fourty;
    @FXML
    Button goToSeats;
    @FXML
    Button seatsBooking;

    int travellerNumber;
    String seats="";

    @FXML
    protected void click1() {
        if(clock1==0){
            one.setStyle("-fx-background-color:#6eee6a");
            clock1=1;
            SeatNo.add(1);
        }
        else{
            one.setStyle("-fx-background-color:#eb4e4e");
            clock1=0;
        }
    }
    @FXML
    protected void click2() {
        if(clock2==0){
            two.setStyle("-fx-background-color:#6eee6a");
            clock2=1;
            SeatNo.add(2);
        }
        else{
            two.setStyle("-fx-background-color:#eb4e4e");
            clock2=0;
        }
    }
    @FXML
    protected void click3(){
        if(clock3==0){
            three.setStyle("-fx-background-color:#6eee6a");
            clock3=1;
            SeatNo.add(3);
        }
        else{
            three.setStyle("-fx-background-color:#eb4e4e");
            clock3=0;
        }

    }
    @FXML
    protected void click4() {
        if(clock4==0){
            four.setStyle("-fx-background-color:#6eee6a");
            clock4=1;
            SeatNo.add(4);
        }
        else{
            four.setStyle("-fx-background-color:#eb4e4e");
            clock4=0;
        }
    }
    @FXML
    protected void click5() {
        if(clock5==0){
            five.setStyle("-fx-background-color:#6eee6a");
            clock5=1;
            SeatNo.add(5);
        }
        else{
            five.setStyle("-fx-background-color:#eb4e4e");
            clock5=0;
        }
    }
    @FXML
    protected void click6() {
        if(clock6==0){
            six.setStyle("-fx-background-color:#6eee6a");
            clock6=1;
            SeatNo.add(6);
        }
        else{
            six.setStyle("-fx-background-color:#eb4e4e");
            clock6=0;
        }
    }
    @FXML
    protected void click7() {
        if(clock7==0){
            seven.setStyle("-fx-background-color:#6eee6a");
            clock7=1;
            SeatNo.add(7);
        }
        else{
            seven.setStyle("-fx-background-color:#eb4e4e");
            clock7=0;
        }
    }
    @FXML
    protected void click8() {
        if(clock8==0){
            eight.setStyle("-fx-background-color:#6eee6a");
            clock8=1;
            SeatNo.add(8);
        }
        else{
            eight.setStyle("-fx-background-color:#eb4e4e");
            clock8=0;
        }
    }
    @FXML
    protected void click9() {
        if(clock9==0){
            nine.setStyle("-fx-background-color:#6eee6a");
            clock9=1;
            SeatNo.add(9);
        }
        else{
            nine.setStyle("-fx-background-color:#eb4e4e");
            clock9=0;
        }
    }
    @FXML
    protected void click10() {
        if(clock10==0){
            ten.setStyle("-fx-background-color:#6eee6a");
            clock10=1;
            SeatNo.add(10);
        }
        else{
            ten.setStyle("-fx-background-color:#eb4e4e");
            clock10=0;
        }
    }
    @FXML
    protected void click11() {
        if(clock11==0){
            eleven.setStyle("-fx-background-color:#6eee6a");
            clock11=1;
            SeatNo.add(11);
        }
        else{
            eleven.setStyle("-fx-background-color:#eb4e4e");
            clock11=0;
        }
    }
    @FXML
    protected void click12() {
        if(clock12==0){
            twelve.setStyle("-fx-background-color:#6eee6a");
            clock12=1;
            SeatNo.add(12);
        }
        else{
            twelve.setStyle("-fx-background-color:#eb4e4e");
            clock12=0;
        }
    }
    @FXML
    protected void click13() {
        if(clock13==0){
            thirteen.setStyle("-fx-background-color:#6eee6a");
            clock13=1;
            SeatNo.add(13);
        }
        else{
            thirteen.setStyle("-fx-background-color:#eb4e4e");
            clock13=0;
        }
    }
    @FXML
    protected void click14() {
        if(clock14==0){
            fourteen.setStyle("-fx-background-color:#6eee6a");
            clock14=1;
            SeatNo.add(14);
        }
        else{
            fourteen.setStyle("-fx-background-color:#eb4e4e");
            clock14=0;
        }
    }
    @FXML
    protected void click15() {
        if(clock15==0){
            fiveteen.setStyle("-fx-background-color:#6eee6a");
            clock15=1;
            SeatNo.add(15);
        }
        else{
            fiveteen.setStyle("-fx-background-color:#eb4e4e");
            clock15=0;
        }
    }
    @FXML
    protected void click16() {
        if(clock16==0){
            sixteen.setStyle("-fx-background-color:#6eee6a");
            clock16=1;
            SeatNo.add(16);
        }
        else{
            sixteen.setStyle("-fx-background-color:#eb4e4e");
            clock16=0;
        }
    }
    @FXML
    protected void click17() {
        if(clock17==0){
            seventeen.setStyle("-fx-background-color:#6eee6a");
            clock17=1;
            SeatNo.add(17);
        }
        else{
            seventeen.setStyle("-fx-background-color:#eb4e4e");
            clock17=0;
        }
    }
    @FXML
    protected void click18() {
        if(clock18==0){
            eighteen.setStyle("-fx-background-color:#6eee6a");
            clock18=1;
            SeatNo.add(18);
        }
        else{
            eighteen.setStyle("-fx-background-color:#eb4e4e");
            clock18=0;
        }
    }
    @FXML
    protected void click19() {
        if(clock19==0){
            ninteen.setStyle("-fx-background-color:#6eee6a");
            clock19=1;
            SeatNo.add(19);
        }
        else{
            ninteen.setStyle("-fx-background-color:#eb4e4e");
            clock19=0;
        }
    }
    @FXML
    protected void click20() {
        if(clock20==0){
            twenty.setStyle("-fx-background-color:#6eee6a");
            clock20=1;
            SeatNo.add(20);
        }
        else{
            twenty.setStyle("-fx-background-color:#eb4e4e");
            clock20=0;
        }
    }
    @FXML
    protected void click21() {
        if(clock21==0){
            twentyone.setStyle("-fx-background-color:#6eee6a");
            clock21=1;
            SeatNo.add(21);
        }
        else{
            twentyone.setStyle("-fx-background-color:#eb4e4e");
            clock21=0;
        }
    }
    @FXML
    protected void click22() {
        if(clock22==0){
            twentytwo.setStyle("-fx-background-color:#6eee6a");
            clock22=1;
            SeatNo.add(22);
        }
        else{
            twentytwo.setStyle("-fx-background-color:#eb4e4e");
            clock22=0;
        }
    }
    @FXML
    protected void click23() {
        if(clock23==0){
            twentythree.setStyle("-fx-background-color:#6eee6a");
            clock23=1;
            SeatNo.add(23);
        }
        else{
            twentythree.setStyle("-fx-background-color:#eb4e4e");
            clock23=0;
        }
    }
    @FXML
    protected void click24() {
        if(clock24==0){
            twentyfour.setStyle("-fx-background-color:#6eee6a");
            clock24=1;
            SeatNo.add(24);
        }
        else{
            twentyfour.setStyle("-fx-background-color:#eb4e4e");
            clock24=0;
        }
    }
    @FXML
    protected void click25() {
        if(clock25==0){
            twentyfive.setStyle("-fx-background-color:#6eee6a");
            clock25=1;
            SeatNo.add(25);
        }
        else{
            twentyfive.setStyle("-fx-background-color:#eb4e4e");
            clock25=0;
        }
    }
    @FXML
    protected void click26() {
        if(clock26==0){
            twentysix.setStyle("-fx-background-color:#6eee6a");
            clock26=1;
            SeatNo.add(26);
        }
        else{
            twentysix.setStyle("-fx-background-color:#eb4e4e");
            clock26=0;
        }
    }
    @FXML
    protected void click27() {
        if(clock27==0){
            twentyseven.setStyle("-fx-background-color:#6eee6a");
            clock27=1;
            SeatNo.add(27);
        }
        else{
            twentyseven.setStyle("-fx-background-color:#eb4e4e");
            clock27=0;
        }
    }
    @FXML
    protected void click28() {
        if(clock28==0){
            twentyeight.setStyle("-fx-background-color:#6eee6a");
            clock28=1;
            SeatNo.add(28);
        }
        else{
            twentyeight.setStyle("-fx-background-color:#eb4e4e");
            clock28=0;
        }
    }
    @FXML
    protected void click29() {
        if(clock29==0){
            twentynine.setStyle("-fx-background-color:#6eee6a");
            clock29=1;
            SeatNo.add(29);
        }
        else{
            twentynine.setStyle("-fx-background-color:#eb4e4e");
            clock29=0;
        }
    }
    @FXML
    protected void click30() {
        if(clock30==0){
            thirty.setStyle("-fx-background-color:#6eee6a");
            clock30=1;
            SeatNo.add(30);
        }
        else{
            thirty.setStyle("-fx-background-color:#eb4e4e");
            clock30=0;
        }
    }
    @FXML
    protected void click31() {
        if(clock31==0){
            thirtyone.setStyle("-fx-background-color:#6eee6a");
            clock31=1;
            SeatNo.add(31);
        }
        else{
            thirtyone.setStyle("-fx-background-color:#eb4e4e");
            clock31=0;
        }
    }
    @FXML
    protected void click32() {
        if(clock32==0){
            thirtytwo.setStyle("-fx-background-color:#6eee6a");
            clock32=1;
            SeatNo.add(32);
        }
        else{
            thirtytwo.setStyle("-fx-background-color:#eb4e4e");
            clock32=0;
        }
    }
    @FXML
    protected void click33() {
        if(clock33==0){
            thirtythree.setStyle("-fx-background-color:#6eee6a");
            clock33=1;
            SeatNo.add(33);
        }
        else{
            thirtythree.setStyle("-fx-background-color:#eb4e4e");
            clock33=0;
        }
    }
    @FXML
    protected void click34() {
        if(clock34==0){
            thirtyfour.setStyle("-fx-background-color:#6eee6a");
            clock34=1;
            SeatNo.add(34);
        }
        else{
            thirtyfour.setStyle("-fx-background-color:#eb4e4e");
            clock34=0;
        }
    }
    @FXML
    protected void click35() {
        if(clock35==0){
            thirtyfive.setStyle("-fx-background-color:#6eee6a");
            clock35=1;
            SeatNo.add(35);
        }
        else{
            thirtyfive.setStyle("-fx-background-color:#eb4e4e");
            clock35=0;
        }
    }
    @FXML
    protected void click36() {
        if(clock36==0){
            thirtysix.setStyle("-fx-background-color:#6eee6a");
            clock36=1;
            SeatNo.add(36);
        }
        else{
            thirtysix.setStyle("-fx-background-color:#eb4e4e");
            clock36=0;
        }
    }
    @FXML
    protected void click37() {
        if(clock37==0){
            thirtyseven.setStyle("-fx-background-color:#6eee6a");
            clock37=1;
            SeatNo.add(37);
        }
        else{
            thirtyseven.setStyle("-fx-background-color:#eb4e4e");
            clock37=0;
        }
    }
    @FXML
    protected void click38() {
        if(clock38==0){
            thirtyeight.setStyle("-fx-background-color:#6eee6a");
            clock38=1;
            SeatNo.add(38);
        }
        else{
            thirtyeight.setStyle("-fx-background-color:#eb4e4e");
            clock38=0;
        }
    }
    @FXML
    protected void click39() {
        if(clock39==0){
            thirtynine.setStyle("-fx-background-color:#6eee6a");
            clock39=1;
            SeatNo.add(39);
        }
        else{
            thirtynine.setStyle("-fx-background-color:#eb4e4e");
            clock39=0;
        }
    }
    @FXML
    protected void click40() {
        if(clock40==0){
            fourty.setStyle("-fx-background-color:#6eee6a");
            clock40=1;
            SeatNo.add(40);
        }
        else{
            fourty.setStyle("-fx-background-color:#eb4e4e");
            clock40=0;
        }
    }
    public void seatsBooking(ActionEvent event){
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        //Getting seat Numbers
        Collections.sort(SeatNo);
        seats=seats+(SeatNo.get(0)).toString();
        for(int i=1;i<SeatNo.size();i++){
            seats=seats+","+(SeatNo.get(i)).toString();
        }

        String connectQuery="select * from user_accounts where user_name='"+userName+"';";
        String connectQuery1="Update user_accounts Set seats='" + seats+ "' Where User_Name='" + userName + "';";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(connectQuery);
            while(queryResult.next()){
                travellerNumber=queryResult.getInt("number");
                if(travellerNumber!=SeatNo.size()){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("inappropriateSeats.fxml"));
                    root=loader.load();

                    SeatsController SeatsController=loader.getController();
                    SeatsController.setUserName(userName);
                    stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else{
                    statement.executeUpdate(connectQuery1);

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

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void goToSeats(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("seats.fxml"));
        root=loader.load();

        SeatsController SeatsController=loader.getController();
        SeatsController.setUserName(userName);
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}