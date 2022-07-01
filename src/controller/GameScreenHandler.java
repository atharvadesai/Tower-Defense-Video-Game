package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import model.*;
import view.InitialGameScreen;

import java.util.List;

public class GameScreenHandler {

    private final InitialGameScreen gameScreen = MainController.getGameScreen();
    private final GameModel gameModel = MainController.getGameModel();

    private final Label moneyLabel;
    private final Label nameLabel;
    private final Label healthLabel;
    private final Button shopBtn;
    private final Label infoLabel;
    private final Pane towerArea;
    private final Button startBtn;
    private final Button upgradeTowersBtn;

    private boolean roundStarted = false;

    public GameScreenHandler() {
        moneyLabel = gameScreen.getMoneyLabel();
        nameLabel = gameScreen.getNameLabel();
        healthLabel = gameScreen.getMonumentHealthLabel();
        shopBtn = gameScreen.getTowerShopBtn();
        infoLabel = gameScreen.getInfoLabel();
        towerArea = gameScreen.getTowerArea();
        startBtn = gameScreen.getStartCombatButton();
        upgradeTowersBtn = gameScreen.getUpgradeTowersBtn();
    }

    public void initializeInitialGameScreen() {
        moneyLabel.setText("Money: " + gameModel.getMoney());
        nameLabel.setText("Player: " + gameModel.getName());
        healthLabel.setText("Monument Health: " + gameModel.getMonumentHP());

        shopBtn.setOnAction(e -> MainController.setScreen("ShopScreen"));

        startBtn.setOnAction(e -> {
            MainController.getMonsterHandler().initializeWave();
            MainController.getMonsterHandler().startRound();

            startBtn.setDisable(true);
            roundStarted = true;
        });


        upgradeTowersBtn.setOnAction(e -> {
            if (gameModel.getMoney() < 500) {
                infoLabel.setText("Not Enough Money to Upgrade");

            } else {
                infoLabel.setText("");
                gameModel.setMoney(gameModel.getMoney() - 500);
                for (int i = 0; i < gameModel.getTowerList().size(); i++) {
                    List<Tower> temp = gameModel.getTowerList();

                    temp.get(i).setAttack(temp.get(i).getAttack() + 10);

                    temp.get(i).getTowerUI().setStroke(Color.YELLOWGREEN);
                    temp.get(i).getTowerUI().setStrokeWidth(3.0);

                }
                MainController.updateAllLabels();

            }

        });
    }

    public void setGameScreenPlacingTower(int towerType) {
        updateMoneyLabel();

        infoLabel.setText("Click to Place Tower, Right Click to Cancel");
        shopBtn.setDisable(true);
        startBtn.setDisable(true);
        upgradeTowersBtn.setDisable(true);

        enablePathDetection();

        MainController.setScreen("GameScreen");

        towerArea.setOnMouseClicked(e -> {
            MainController.getShopScreenHandler().updateIssueLabel("");
            if (e.getButton() == MouseButton.PRIMARY) {
                gameModel.addMoney(-gameModel.getTowerPrices()[towerType]);
                updateMoneyLabel();

                double xPos = e.getX();
                double yPos = e.getY();

                MainController.getTowerHandler().addNewTower(xPos, yPos, towerType);

                disablePathDetection();
                shopBtn.setDisable(false);
                upgradeTowersBtn.setDisable(false);

                if (!roundStarted) {
                    startBtn.setDisable(false);
                }

                infoLabel.setText("");
                towerArea.setOnMouseClicked(null);
            } else if (e.getButton() == MouseButton.SECONDARY) {
                MainController.setScreen("ShopScreen");

                disablePathDetection();
                shopBtn.setDisable(false);
                startBtn.setDisable(false);
                upgradeTowersBtn.setDisable(false);
                infoLabel.setText("");
                towerArea.setOnMouseClicked(null);
            }
        });
    }

    private void enablePathDetection() {
        Pane towerArea = gameScreen.getTowerArea();

        Rectangle path = gameScreen.getPath();
        Rectangle monument = gameScreen.getMonument();
        Rectangle monumentBase = gameScreen.getMonumentBase();

        Rectangle pathTowerLayer = gameScreen.getPathTowerLayer();
        Rectangle monumentTowerLayer = gameScreen.getMonumentTowerLayer();
        Rectangle monumentBaseTowerLayer = gameScreen.getMonumentBaseTowerLayer();

        pathEntryHelper(towerArea, path, monument, monumentBase);

        pathEntryHelper(towerArea, pathTowerLayer, monumentTowerLayer, monumentBaseTowerLayer);

        pathExitHelper(towerArea, path, monument, monumentBase);

        pathExitHelper(towerArea, pathTowerLayer, monumentTowerLayer, monumentBaseTowerLayer);
    }

    private void pathExitHelper(
            Pane towerArea,
            Rectangle path,
            Rectangle monument,
            Rectangle monumentBase
    ) {
        path.setOnMouseExited(e -> {
            //System.out.println("Exited Path");
            towerArea.setDisable(false);
        });

        monument.setOnMouseExited(e -> {
            //System.out.println("Exited Monument");
            towerArea.setDisable(false);
        });

        monumentBase.setOnMouseExited(e -> {
            //System.out.println("Exited Base");
            towerArea.setDisable(false);
        });
    }

    private void pathEntryHelper(
            Pane towerArea,
            Rectangle path,
            Rectangle monument,
            Rectangle monumentBase
    ) {
        path.setOnMouseEntered(e -> {
            //System.out.println("Entered Path");
            towerArea.setDisable(true);
        });

        monument.setOnMouseEntered(e -> {
            //System.out.println("Entered Monument");
            towerArea.setDisable(true);
        });

        monumentBase.setOnMouseEntered(e -> {
            //System.out.println("Entered Base");
            towerArea.setDisable(true);
        });
    }

    private void disablePathDetection() {
        Rectangle path = gameScreen.getPath();
        Rectangle monument = gameScreen.getMonument();
        Rectangle monumentBase = gameScreen.getMonumentBase();

        Rectangle pathTowerLayer = gameScreen.getPathTowerLayer();
        Rectangle monumentTowerLayer = gameScreen.getMonumentTowerLayer();
        Rectangle monumentBaseTowerLayer = gameScreen.getMonumentBaseTowerLayer();


        path.setOnMouseEntered(null);
        monument.setOnMouseEntered(null);
        monumentBase.setOnMouseEntered(null);
        pathTowerLayer.setOnMouseEntered(null);
        monumentTowerLayer.setOnMouseEntered(null);
        monumentBaseTowerLayer.setOnMouseEntered(null);
        path.setOnMouseExited(null);
        monument.setOnMouseExited(null);
        monumentBase.setOnMouseExited(null);
        pathTowerLayer.setOnMouseExited(null);
        monumentTowerLayer.setOnMouseExited(null);
        monumentBaseTowerLayer.setOnMouseExited(null);
    }


    public void updateMoneyLabel() {
        moneyLabel.setText("Money: " + gameModel.getMoney());
    }

    public void updateMonumentLabel() {
        healthLabel.setText("Monument Health: " + gameModel.getMonumentHP());
    }

    public void endGame() {
        MainController.setScreen("GameOverScreen");
    }

    public void winGame() {
        MainController.setScreen("WinScreen");
    }

}
