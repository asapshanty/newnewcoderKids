package edu.uh.tech.cis3368.semesterproject;

import edu.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Controller
public class DatabaseController {


    private Scene returnScene;

    public void setReturnScene(Scene scene) {
        this.returnScene = scene;
    }

    //////////////EMPLOYEE TAB///////////////
    @FXML
    private TextField empId;
    @FXML
    private TextField empFirstName;
    @FXML
    private TextField empLastName;
    @FXML
    private TextField empStatus;
    @FXML
    private TextField empType;
    @FXML
    private TextField empPhone;
    @FXML
    private TextField empHireDate;
    @FXML
    private TextField empTerminationDate;

    private List<TextField> fieldList;
    private List<TextField> accessList;
    private List<TextField> chkinList;
    private List<TextField> chkoutList;
    private List<TextField> deviceList;

    @FXML
    private Button btnAddEmp;
    @FXML
    private Button btnDelEmp;
    @FXML
    private Button btnUpdEmp;
    @FXML
    private Button btnExitEmp;


//    LinkedList<Accessory> accessList;
//    LinkedList<Checkin> chkinList;
//    LinkedList<Checkout> chkoutList;
//    LinkedList<Device> deviceList;

    private ObservableList<Employee> data;

    //clear buttons
    private void clearFields(){
        fieldList.forEach(textField -> textField.setText(null));
        accessList.forEach(textField -> textField.setText(null));
//        chkinList.forEach(textField -> textField.setText(null));
//        chkoutList.forEach(textField -> textField.setText(null));
        deviceList.forEach(textField -> textField.setText(null));
    }
    public void handleClearSelection (ActionEvent actionEvent){
        clearFields();
    }

    // to populate fieldList
    public void initialize(){
        fieldList = Arrays.asList(empFirstName, empLastName, empStatus, empType, empPhone, empHireDate, empTerminationDate);
        accessList = Arrays.asList(accessoryModel,accessorySerialNumber,accessoryDateAcquired);
    //    chkinList = Arrays.asList(checkinCount,checkinDate);
    //    chkoutList = Arrays.asList(checkoutCount,checkoutDate);
        deviceList= Arrays.asList(deviceModel,deviceSerialNumber,deviceDateAcquired);

        //initializeDis();
        clearFields();
    }

    //////////////ACCESSORY TAB///////////////
    @FXML
    private TextField accessoryModel;
    @FXML
    private TextField accessorySerialNumber;
    @FXML
    private TextField accessoryDateAcquired;

    //////////////CHECKIN TAB///////////////
    @FXML
    private TextField checkinCount;
    @FXML
    private TextField checkinDate;

    //////////////CHECKOUT TAB///////////////
    @FXML
    private TextField checkoutCount;
    @FXML
    private TextField checkoutDate;

    //////////////INVENTORY TAB///////////////

    //////////////DEVICE TAB///////////////
    @FXML
    private TextField deviceModel;
    @FXML
    private TextField deviceSerialNumber;
    @FXML
    private TextField deviceDateAcquired;


    //Exit
    @FXML
    private void closeAction (ActionEvent actionEvent) {
        System.exit(0);
    }




}
