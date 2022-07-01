package view;

import javafx.scene.Scene;

import javafx.scene.control.Label;
import javafx.scene.control.Button;

import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class ShopScreen {

    private final int width;
    private final int height;

    private final Button tower1Btn;
    private final Button tower2Btn;
    private final Button tower3Btn;
    private final Label tower1Label;
    private final Label tower2Label;
    private final Label tower3Label;
    private final Button returnBtn;
    private final Label moneyLabel;
    private final Label issueLabel;
    private final Label descLabel;

    public ShopScreen(int width, int height) {
        this.width = width;
        this.height = height;

        tower1Btn = new Button();
        tower2Btn = new Button();
        tower3Btn = new Button();
        tower1Label = new Label("This tower deals medium damage");
        tower2Label = new Label("This tower deals more damage");
        tower3Label = new Label("This tower attacks from a longer range");
        returnBtn = new Button("Back");
        moneyLabel = new Label();
        issueLabel = new Label("");
        descLabel = new Label("Click a button to purchase a tower!");
    }

    public Scene getScene() {
        Label shopLabel = new Label("Tower Shop");
        shopLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));
        shopLabel.setFocusTraversable(true);

        moneyLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));

        descLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));

        tower1Label.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        tower2Label.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        tower3Label.setFont(Font.font("Impact", FontWeight.BOLD, 20));

        tower1Label.setWrapText(true);
        tower2Label.setWrapText(true);
        tower3Label.setWrapText(true);

        tower1Label.setTextAlignment(TextAlignment.CENTER);
        tower2Label.setTextAlignment(TextAlignment.CENTER);
        tower3Label.setTextAlignment(TextAlignment.CENTER);

        tower1Label.setPrefSize(200, 100);
        tower2Label.setPrefSize(200, 100);
        tower3Label.setPrefSize(200, 100);

        issueLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));
        issueLabel.setTextFill(Color.color(1, 0, 0));

        tower1Btn.setPrefSize(200, 100);
        tower1Btn.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        tower2Btn.setPrefSize(200, 100);
        tower2Btn.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        tower3Btn.setPrefSize(200, 100);
        tower3Btn.setFont(Font.font("Impact", FontWeight.BOLD, 20));


        tower1Btn.setAlignment(Pos.CENTER);
        tower2Btn.setAlignment(Pos.CENTER);
        tower3Btn.setAlignment(Pos.CENTER);

        returnBtn.setPrefSize(320, 100);
        returnBtn.setFont(Font.font("Impact", FontWeight.BOLD, 30));

        HBox labelBox = new HBox(500, shopLabel, moneyLabel);
        labelBox.setAlignment(Pos.CENTER);

        HBox descBox = new HBox(500, descLabel);
        descBox.setAlignment(Pos.CENTER);

        HBox issueBox = new HBox(500, issueLabel);
        issueBox.setAlignment(Pos.CENTER);

        VBox combo = new VBox(50, labelBox, descBox, issueBox);

        GridPane buttonPane = new GridPane();
        buttonPane.addRow(0, tower1Btn, tower2Btn, tower3Btn);
        buttonPane.addRow(1, tower1Label, tower2Label, tower3Label);

        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setVgap(20);
        buttonPane.setHgap(80);

        BorderPane layout = new BorderPane();
        BorderPane.setAlignment(combo, Pos.CENTER);
        BorderPane.setAlignment(buttonPane, Pos.CENTER);
        BorderPane.setAlignment(returnBtn, Pos.CENTER);
        BorderPane.setMargin(combo, new Insets(30, 0, 0, 0));
        BorderPane.setMargin(returnBtn, new Insets(0, 0, 30, 0));
        layout.setTop(combo);
        layout.setCenter(buttonPane);
        layout.setBottom(returnBtn);

        return new Scene(layout, width, height);
    }

    public Button getTower1Btn() {
        return tower1Btn;
    }

    public Button getTower2Btn() {
        return tower2Btn;
    }

    public Button getTower3Btn() {
        return tower3Btn;
    }

    public Button getReturnBtn() {
        return returnBtn;
    }

    public Label getIssueLabel() {
        return issueLabel;
    }

    public Label getMoneyLabel() {
        return moneyLabel;
    }
}
