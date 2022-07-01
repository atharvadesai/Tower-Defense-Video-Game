package view;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ConfigScreen {

    private final Label nameLabel;
    private final TextField nameField;
    private final Label difficultyLabel;
    private final ComboBox<String> difBox;
    private final Button startButton;
    private final Label infoLabel;

    private final int width;
    private final int height;

    public ConfigScreen(int width, int height) {
        this.width = width;
        this.height = height;

        nameLabel = new Label("Enter Your Name: ");
        nameLabel.setFocusTraversable(true);
        nameField = new TextField();
        nameField.setPromptText("e.g. John Doe");

        difficultyLabel = new Label("Choose Your Difficulty Level: ");
        difBox = new ComboBox<>();
        difBox.setPromptText("Choose a Difficulty");
        difBox.getItems().addAll("Easy", "Medium", "Hard", "Expert");

        infoLabel = new Label();
        startButton = new Button("Start Game");
    }

    public Scene getScene() {
        nameLabel.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        difficultyLabel.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        infoLabel.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        infoLabel.setTextFill(Color.RED);

        startButton.setPrefSize(160, 100);
        startButton.setFont(Font.font("Impact", FontWeight.BOLD, 20));

        HBox nameBox = new HBox(20);
        nameBox.getChildren().addAll(nameLabel, nameField);
        nameBox.setAlignment(Pos.CENTER);

        HBox levelBox = new HBox(20);
        levelBox.getChildren().addAll(difficultyLabel, difBox);
        levelBox.setAlignment(Pos.CENTER);

        VBox elements = new VBox(100);
        elements.getChildren().addAll(nameBox, levelBox, infoLabel, startButton);
        elements.setAlignment(Pos.CENTER);

        return new Scene(elements, width, height, new LinearGradient(
                0, 0, 1, 1, true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.LIGHTBLUE),
                new Stop(1, Color.GOLD)));
    }

    public Button getStartButton() {
        return startButton;
    }

    public TextField getNameField() {
        return nameField;
    }

    public Label getInfoLabel() {
        return infoLabel;
    }

    public ComboBox<String> getDifBox() {
        return difBox;
    }
}
