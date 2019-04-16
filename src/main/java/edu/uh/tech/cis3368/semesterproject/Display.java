package edu.uh.tech.cis3368.semesterproject;


import javafx.scene.layout.Pane;
import javafx.scene.*;


import java.util.HashMap;

public class Display {
    private HashMap<String, Pane> screenMap = new HashMap<>();
    private Scene main;

    public Display(Scene main){this.main = main;}

    protected void addScreen(String name, Pane pane){
        if(!screenMap.containsKey(name))
            screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        if(screenMap.containsKey(name))
            screenMap.remove(name);
    }

    protected void activate(String name){
        main.setRoot(screenMap.get(name));
        main.getWindow().sizeToScene();
    }

}
