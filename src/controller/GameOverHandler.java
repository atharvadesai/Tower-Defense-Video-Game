package controller;

import model.GameModel;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.GameOverScreen;

public class GameOverHandler {
    private final GameOverScreen overScreen = MainController.getGameOverScreen();
    private final GameModel gameModel = MainController.getGameModel();

    private final Button restartBtn;
    private final Button endBtn;
    private final Label killedLabel;
    private final Label moneyLabel;
    private final Label damageLabel;

    public GameOverHandler() {
        restartBtn = overScreen.getRestartBtn();
        endBtn = overScreen.getEndBtn();

        killedLabel = overScreen.getKilledLabel();
        moneyLabel = overScreen.getMoneyLabel();
        damageLabel = overScreen.getDamageLabel();
    }

    public void initializeGameOverScreen() {
        restartBtn.setOnAction(e -> {
            MainController.initializeNewGame();
        });
        endBtn.setOnAction(e -> Platform.exit());

        killedLabel.setText("Total Enemies Killed: " + gameModel.getEnemiesKilled());
        damageLabel.setText("Total Damage Dealt: " + gameModel.getDamageDealt());
        moneyLabel.setText("Total Money Earned: " + gameModel.getMoneyMade());
    }

}
