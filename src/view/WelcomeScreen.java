package view;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;

public class WelcomeScreen {

    private final int width;
    private final int height;

    private final Button playBtn;

    public WelcomeScreen(int width, int height) {
        this.width = width;
        this.height = height;
        playBtn = new Button("Play!");
    }

    public Scene getScene() {
        Label welcomeLabel = new Label("Welcome to PHAAB TD");
        welcomeLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));
        welcomeLabel.setFocusTraversable(true);

        playBtn.setPrefSize(162, 100);
        playBtn.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC, 25));

        VBox vbox = new VBox(75, welcomeLabel, playBtn);
        vbox.setAlignment(Pos.CENTER);

        return new Scene(vbox, width, height);
    }

    public Button getPlayBtn() {
        return playBtn;
    }
}