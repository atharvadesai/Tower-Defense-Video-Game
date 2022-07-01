package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import model.GameModel;
import view.ShopScreen;

public class ShopScreenHandler {

    private final ShopScreen shopScreen = MainController.getShopScreen();
    private final GameModel gameModel = MainController.getGameModel();

    private final Button tower1Btn;
    private final Button tower2Btn;
    private final Button tower3Btn;
    private final Button returnBtn;
    private final Label issueLabel;
    private final Label moneyLabel;

    public ShopScreenHandler() {
        tower1Btn = shopScreen.getTower1Btn();
        tower2Btn = shopScreen.getTower2Btn();
        tower3Btn = shopScreen.getTower3Btn();
        returnBtn = shopScreen.getReturnBtn();
        issueLabel = shopScreen.getIssueLabel();
        moneyLabel = shopScreen.getMoneyLabel();
    }

    public void initializeShopScreen() {
        tower1Btn.setText("Attacker\n     " + gameModel.getTowerPrices()[0]);
        tower2Btn.setText("Strong Attacker\n             " + gameModel.getTowerPrices()[1]);
        tower3Btn.setText("Sniper\n   " + gameModel.getTowerPrices()[2]);

        updateMoneyLabel();

        returnBtn.setOnAction(e -> MainController.setScreen("GameScreen"));

        tower1Btn.setOnAction(e -> {
            if (gameModel.getTowerPrices()[0] > gameModel.getMoney()) {
                issueLabel.setText("You do not have enough money to buy Attacker");
            } else {
                MainController.getGameScreenHandler().setGameScreenPlacingTower(0);
            }
        });

        tower2Btn.setOnAction(e -> {
            if (gameModel.getTowerPrices()[1] > gameModel.getMoney()) {
                issueLabel.setText("You do not have enough money to buy Strong Attacker");
            } else {
                MainController.getGameScreenHandler().setGameScreenPlacingTower(1);
            }
        });

        tower3Btn.setOnAction(e -> {
            if (gameModel.getTowerPrices()[2] > gameModel.getMoney()) {
                issueLabel.setText("You do not have enough money to buy Sniper");
            } else {
                MainController.getGameScreenHandler().setGameScreenPlacingTower(2);
            }
        });
    }

    public void updateMoneyLabel() {
        moneyLabel.setText("Money: " + gameModel.getMoney());
    }

    public void updateIssueLabel(String text) {
        issueLabel.setText(text);
    }
}
