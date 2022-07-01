package model;

import javafx.scene.layout.StackPane;

public interface Monster {

    StackPane getMonsterUI();

    double getTravelDuration();

    int getHealth();

    int getDamage();

    void updateHealthLabel();

    void loseHealth(int damage);
}
