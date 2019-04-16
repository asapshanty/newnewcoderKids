package edu.uh.tech.cis3368.semesterproject;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import java.io.IOException;

@Component
public class MainController {


    @FXML
    private Button btnLogin;
    @FXML
    private TextField txtUserName;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Label statusMessage;
    @FXML
    private ImageView login;
    @FXML
    private BorderPane frame;
    @Autowired
    private ConfigurableApplicationContext applicationContext;





    public void initialize(){
        try
        {

            btnLogin.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    toggleLogin();
                    attemptLogin(txtUserName.getText(), txtPassword.getText());
                    toggleLogin();
                }
            });
        }

        catch (Exception e ){
            if(!e.getMessage().isEmpty()||e.getMessage()!=null){
                System.out.println("Loading Error: " + e.getMessage());
            }
            else{
                String s = "Loading Error!";
                System.out.println(s);
                updateStatus(s);
            }

        }
    }


    public void doLogin (ActionEvent click) throws IOException{
        Stage parent  = (Stage) ((Node)click.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("database.fxml"));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene(fxmlLoader.load());
        DatabaseController databaseController = fxmlLoader.getController();
        databaseController.setReturnScene(btnLogin.getScene());
        parent.setScene(scene);


    }
    private void attemptLogin(String userName, String password) {
        if((userName.isEmpty()||(password.isEmpty())||password ==null)){
            updateStatus("The username or password field is empty -_-");
        }
        else{
            updateStatus(" ");
            //if(DBConnection.GetConnection(userName, password)!=null){
            if(userName.equals(Information.Username) && password.equals(Information.Password)){
                System.out.println("Welcome!");
                //switchToViewScreen();
                // doLogin();

            }
            else{
                String s = "Wrong Username or Password!";
                updateStatus("Try Again");
                System.out.println(s);
            }
        }
    }

    private void toggleLogin() {
        if(!txtUserName.isDisabled()
                && !txtPassword.isDisabled()){
            txtUserName.setDisable(true);
            txtPassword.setDisable(true);
            btnLogin.setDisable(true);
        }
        else{
            txtUserName.setDisable(false);
            txtPassword.setDisable(false);
            btnLogin.setDisable(false);
        }
    }

    //FIX SOMETHING HERE TO SWITCH SCREENS basically set scene in database controller
//    private void switchToViewScreen() {
//
//        try{
//
//
//            Display display= new Display(frame.getScene());
//            display.addScreen("database", FXMLLoader.load(getClass().getResource("database.fxml")));
//            display.activate("database");
//        }
//        catch (Exception e){
//            return;
//        }
//    }

    private void showMessage(String s){
        try{
            System.out.println(s);
        }
        catch(Exception e){

        }
    }

    private void updateStatus(String s) {
        if(!s.isEmpty()|| s!=null)
        {
            statusMessage.setText(s);
        }

        else{
            statusMessage.setText(" ");
        }

    }



}




