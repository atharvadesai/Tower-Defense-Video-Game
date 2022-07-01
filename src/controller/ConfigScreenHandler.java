package controller;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import model.GameModel;
import view.ConfigScreen;

public class ConfigScreenHandler {

    private final ConfigScreen configScreen = MainController.getConfigScreen();
    private final GameModel gameModel = MainController.getGameModel();

    private final Button startBtn;
    private final TextField nameField;
    private final ComboBox<String> diffBox;
    private final Label infoLabel;

    public ConfigScreenHandler() {
        startBtn = configScreen.getStartButton();
        nameField = configScreen.getNameField();
        diffBox = configScreen.getDifBox();
        infoLabel = configScreen.getInfoLabel();
    }

    public void initializeConfigScreen() {
        nameField.setOnAction(e -> {
            if (nameField.getText() == null || nameField.getText().isEmpty()
                    || nameField.getText().trim().isEmpty()) {

                infoLabel.setText("Please Enter a Valid Name");
                nameField.clear();
            } else {
                gameModel.setName(nameField.getText());
            }
        });

        startBtn.setOnAction(e -> {
            if (nameField.getText() == null || nameField.getText().isEmpty()
                    || nameField.getText().trim().isEmpty()) {

                infoLabel.setText("Please Enter a Valid Name");
                nameField.clear();
            } else if (diffBox.getValue() == null) {
                infoLabel.setText("Please Select a Difficulty");
            } else {
                gameModel.setName(nameField.getText());
                gameModel.setDifficulty(diffBox.getValue());

                gameModel.initializeGame();

                MainController.getGameScreenHandler().initializeInitialGameScreen();
                MainController.getShopScreenHandler().initializeShopScreen();

                MainController.setScreen("GameScreen");
            }
        });
    }

}
