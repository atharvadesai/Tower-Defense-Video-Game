package controller;

import javafx.scene.control.Button;

import view.WelcomeScreen;

public class WelcomeScreenHandler {

    private final WelcomeScreen welcomeScreen = MainController.getWelcomeScreen();

    private final Button playBtn;

    public WelcomeScreenHandler() {
        playBtn = welcomeScreen.getPlayBtn();
    }

    public void initializeWelcomeScreen() {
        playBtn.setOnAction(e -> {
            MainController.getConfigScreenHandler().initializeConfigScreen();
            MainController.setScreen("ConfigScreen");
        });
    }
}
