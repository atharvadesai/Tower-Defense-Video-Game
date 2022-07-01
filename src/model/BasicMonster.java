package model;

import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

public class BasicMonster implements Monster {

    private final StackPane monsterUI;
    private final Label monsterHPLabel;
    private final int damage;
    private int health;
    private final double travelDuration;

    public BasicMonster() {
        damage = 100;
        health = 50;
        travelDuration = 10000; //10 Sec to Travel to End

        monsterUI = new StackPane();
        monsterHPLabel = new Label("" + health);
        monsterHPLabel.setTextFill(Color.WHITE);
        Circle monsterBody = new Circle(15);
        monsterBody.setFill(Color.GREEN);

        monsterUI.getChildren().addAll(monsterBody, monsterHPLabel);
        monsterUI.setLayoutX(-35);
        monsterUI.setLayoutY(210);
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
