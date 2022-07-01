package model;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public interface Tower {

    Rectangle getTowerUI();

    Circle getTowerRange();

    int getAttack();

    void setAttack(int inputAttack);
}
