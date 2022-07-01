package model;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javafx.scene.paint.Color;

public class BasicTower implements Tower {
    private final Rectangle towerUI;
    private final Circle towerRange;
    private int attack;

    public BasicTower(double xPos, double yPos) {
        towerUI = new Rectangle(xPos - 8, yPos - 15, 16, 30);
        towerUI.setFill(Color.BLACK);

        towerRange = new Circle(xPos, yPos, 100.0, Color.gray(0.3, 0.3));

        attack = 10;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tower)) {
            return false;
        }
        Tower otherTower = (Tower) other;
        return this.getTowerUI().getFill() == otherTower.getTowerUI().getFill();
    }

    @Override
    public Rectangle getTowerUI() {
        return towerUI;
    }

    @Override
    public Circle getTowerRange() {
        return towerRange;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void setAttack(int inputAttack) { attack = inputAttack; }
}
