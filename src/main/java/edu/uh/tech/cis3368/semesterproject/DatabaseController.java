package edu.uh.tech.cis3368.semesterproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.lang.module.Configuration;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class DatabaseController {


    private Scene returnScene;

    public void setReturnScene(Scene scene) {
        this.returnScene = scene;
    }

    @Autowired
    AccessoryRepository accessoryRepository;
    @Autowired
    CheckinRepository checkinRepository;
    @Autowired
    CheckoutRepository checkoutRepository;
    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    InventoryRepository inventoryRepository;

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
        accessList = Arrays.asList(accessModel,accessSerialNumber,accessDateAcquired);
    //    chkinList = Arrays.asList(chckinCount,chckinDate);
    //    chkoutList = Arrays.asList(chckoutCount,chckoutDate);
        deviceList= Arrays.asList(deviceMod,deviceSrllNumber,deviceDteAcquired);

        //initializeDis();
        clearFields();
    }

    //////////////ACCESSORY TAB///////////////
    @FXML
    private TextField accessModel;
    @FXML
    private TextField accessSerialNumber;
    @FXML
    private TextField accessDateAcquired;

    //////////////CHECKIN TAB///////////////
    @FXML
    private TextField chckinCount;
    @FXML
    private TextField chckinDate;

    //////////////CHECKOUT TAB///////////////
    @FXML
    private TextField chckoutCount;
    @FXML
    private TextField chckoutDate;

    //////////////INVENTORY TAB///////////////

    //////////////DEVICE TAB///////////////
    private ObservableList<Device> deviceData;
    Device device;
//    @Autowired
//    @Qualifier("addDevice")
//    ConfigControllers.View addDeviceView;


    @FXML
    private Button btnAddDev;
    @FXML
    private Button btnDelDev;
    @FXML
    private Button btnEditDev;
    @FXML
    private TextField deviceMod;
    @FXML
    private TextField deviceSrllNumber;
    @FXML
    private TextField deviceDteAcquired;
    @FXML
    private TableView<Device>  deviceTable;
    @FXML
    private TableColumn<Device, Integer> deviceIdPk;
    @FXML
    private TableColumn<Device, String> deviceModel;
    @FXML
    private TableColumn<Device, String> deviceSerialNumber;
    @FXML
    private TableColumn<Device, String> deviceDateAcquired;

    @FXML
    public void initializeDis(){ }

    @PostConstruct
    public void init(){
        btnEditDev.setDisable(true);
        btnDelDev.setDisable(true);
        deviceTable.setOnMouseClicked((javafx.scene.input.MouseEvent event)->{
            btnEditDev.setDisable(false);
            btnDelDev.setDisable(false);
        });
        loadDevices();
    }

    public void loadDevices(){
        Set<Device> views = deviceRepository.findEverything();
        deviceData = FXCollections.observableArrayList(views);
        deviceIdPk.setCellValueFactory(new PropertyValueFactory<Device, Integer>("deviceId"));
        deviceModel.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceModel"));
        deviceSerialNumber.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceSerialNumber"));
        deviceDateAcquired.setCellValueFactory(new PropertyValueFactory<Device, String>("deviceDateAcquired"));

        deviceTable.setItems(deviceData);


    }

    @FXML
    private void addNewDevice(){
        Device device = new Device();
        device.setDeviceModel(deviceMod.getText());
        device.setDeviceSerialNumber(deviceSrllNumber.getText());
        device.setDeviceDateAcquired(deviceDteAcquired.getText());
//       THIS SAVES AND FLUSHES BUT DO NOT UNBLOCK
//        try{
//            deviceRepository.saveAndFlush(device);
//            deviceTable.getItems().add(device);
//            clearFields();
//            deviceList.getSelectionModel().clearSelection;
//            deviceList.refresh();
//        }
//        catch(DataIntegrityViolationException e){
//            showFieldError(e);
//        }
    }

//    private void showFieldError(){
//        var message = e.getMessage();
//        String instructions = VALUES_MISSING_MESSAGE;
//        String headerText = VALUES_MISSING_HEADER;
//        if(message.contains("EMPLOYEE_EMAIL_UINDEX")){
//            instructions = DUP_EMAIL_MESSAGE;
//            headerText = DUP_EMAIL_HEADER;
//        }
//        Alert alert = new Alert(Alert.AlertType.INFORMATION, instructions);
//        alert.setHeaderText(headerText);
//        alert.show();
//
//    }




    @FXML
    private void delDevice(ActionEvent actionEvent){
        Device device = deviceTable.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void editDevice(ActionEvent actionEvent){

        Device deviceEdit = deviceTable.getSelectionModel().getSelectedItem();
        deviceMod.setText(deviceEdit.getDeviceModel());
        deviceSerialNumber.setText(deviceEdit.getDeviceSerialNumber());
        deviceDateAcquired.setText(deviceEdit.getDeviceDateAcquired());

        btnEditDev.setDisable(true);


    }









    //Exit
    @FXML
    private void closeAction (ActionEvent actionEvent) {
        System.exit(0);
    }




}
