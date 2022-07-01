package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class WinScreen {
    private final int width;
    private final int height;

    private final Button restartBtn;
    private final Button endBtn;
    private Label killedLabel;
    private Label damageLabel;
    private Label moneyLabel;

    public WinScreen(int width, int height) {
        this.width = width;
        this.height = height;

        restartBtn = new Button("Play Again!");
        endBtn = new Button("Exit");
        killedLabel = new Label();
        damageLabel = new Label();
        moneyLabel = new Label();
    }

    public Scene getScene() {
        Label overLabel = new Label("You Won!");
        overLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));
        overLabel.setFocusTraversable(true);

        Label msgLabel = new Label("Great Job! Look at your stats below");
        msgLabel.setFont(Font.font("Impact", FontWeight.BOLD, 40));

        killedLabel.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        moneyLabel.setFont(Font.font("Impact", FontWeight.BOLD, 20));
        damageLabel.setFont(Font.font("Impact", FontWeight.BOLD, 20));

        HBox statsBox = new HBox(30, killedLabel, damageLabel, moneyLabel);
        statsBox.setAlignment(Pos.CENTER);

        restartBtn.setPrefSize(162, 100);
        restartBtn.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC, 25));

        endBtn.setPrefSize(162, 100);
        endBtn.setFont(Font.font("Impact", FontWeight.BOLD, FontPosture.ITALIC, 25));

        HBox hbox = new HBox(30, restartBtn, endBtn);
        hbox.setAlignment(Pos.CENTER);
        VBox vbox = new VBox(75, overLabel, msgLabel, statsBox, hbox);
        vbox.setAlignment(Pos.CENTER);

        return new Scene(vbox, width, height);
    }

    public Button getRestartBtn() {
        return restartBtn;
    }

    public Button getEndBtn() {
        return endBtn;
    }

    public Label getMoneyLabel() {
        return moneyLabel;
    }

    public Label getKilledLabel() {
        return killedLabel;
    }

    public Label getDamageLabel() {
        return damageLabel;
    }
}
