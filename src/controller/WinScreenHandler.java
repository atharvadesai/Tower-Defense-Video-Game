package controller;

import model.GameModel;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.WinScreen;

public class WinScreenHandler {
    private final WinScreen winScreen = MainController.getWinScreen();
    private final GameModel gameModel = MainController.getGameModel();

    private final Button restartBtn;
    private final Button endBtn;
    private final Label killedLabel;
    private final Label moneyLabel;
    private final Label damageLabel;

    public WinScreenHandler() {
        restartBtn = winScreen.getRestartBtn();
        endBtn = winScreen.getEndBtn();
        killedLabel = winScreen.getKilledLabel();
        moneyLabel = winScreen.getMoneyLabel();
        damageLabel = winScreen.getDamageLabel();
    }

    public void initializeWinScreen() {
        killedLabel.setText("Total Enemies Killed: " + gameModel.getEnemiesKilled());
        damageLabel.setText("Total Damage Dealt: " + gameModel.getDamageDealt());
        moneyLabel.setText("Total Money Earned: " + gameModel.getMoneyMade());

        restartBtn.setOnAction(e -> {
            MainController.initializeNewGame();
        });
        endBtn.setOnAction(e -> Platform.exit());
    }
}
