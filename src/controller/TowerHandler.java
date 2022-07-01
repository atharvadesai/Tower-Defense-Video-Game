package controller;

import model.*;
import view.InitialGameScreen;

import javafx.scene.layout.Pane;

public class TowerHandler {

    private final InitialGameScreen gameScreen = MainController.getGameScreen();
    private final GameModel gameModel = MainController.getGameModel();

    private final Pane towerArea;

    // for tagging tower nodes with an ID
    private int numTowerID = 1;

    public TowerHandler() {
        towerArea = gameScreen.getTowerArea();
    }

    public void addNewTower(double xPos, double yPos, int towerType) {
        Tower newTower;

        if (towerType == 0) {
            newTower = new BasicTower(xPos, yPos);
        } else if (towerType == 1) {
            newTower = new StrongTower(xPos, yPos);
        } else {
            newTower = new SniperTower(xPos, yPos);
        }

        // tagging tower range node w/ ID for testing
        newTower.getTowerRange().setId("towerRange" + numTowerID);
        numTowerID++;

        newTower.getTowerUI().setOnMouseEntered(e -> {
            towerArea.getChildren().add(newTower.getTowerRange());
            newTower.getTowerUI().toFront();
        });

        newTower.getTowerUI().setOnMouseExited(e -> {
            towerArea.getChildren().remove(newTower.getTowerRange());
        });

        gameModel.addTower(newTower);
        towerArea.getChildren().add(newTower.getTowerUI());
    }

    public void towerAttack(Tower tower, Monster monster) {
        MainController.getMonsterHandler().monsterTakeDamage(monster, tower.getAttack());
    }

}