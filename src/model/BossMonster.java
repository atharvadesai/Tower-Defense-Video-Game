package model;

import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class BossMonster implements Monster {

    private final StackPane monsterUI;
    private final Label monsterHPLabel;
    private final int damage;
    private int health;
    private final double travelDuration;

    public BossMonster() {
        damage = 150;
        health = 400;
        travelDuration = 8000; //8 Sec to Travel to End

        monsterUI = new StackPane();
        monsterHPLabel = new Label("" + health);
        monsterHPLabel.setTextFill(Color.WHITE);
        Circle monsterBody = new Circle(20);
        monsterBody.setFill(Color.BLACK);

        monsterUI.getChildren().addAll(monsterBody, monsterHPLabel);
        monsterUI.setLayoutX(-40);
        monsterUI.setLayoutY(205);
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void loseHealth(int damage) {
        if (health - damage <= 0) {
            health = 0;
        } else {
            health -= damage;
        }
        updateHealthLabel();
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public StackPane getMonsterUI() {
        return monsterUI;
    }

    @Override
    public double getTravelDuration() {
        return travelDuration;
    }

    @Override
    public void updateHealthLabel() {
        monsterHPLabel.setText("" + health);
    }

}
