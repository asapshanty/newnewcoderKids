package edu.uh.tech.cis3368.semesterproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SemesterProjectApplication extends Application {


    private ConfigurableApplicationContext springContext;
    private Parent root;

//    @Autowired
//    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(SemesterProjectApplication.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("database.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();
        super.init();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
