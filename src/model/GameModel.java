package model;

import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private int money;
    private int monumentHP;
    private String difficulty;
    private String name;
    private final int[] towerPrices = new int[3];
    private final List<Tower> towerList = new ArrayList<>();
    private final List<Monster> monsterList = new ArrayList<>();

    private int enemiesKilled = 0;
    private int damageDealt = 0;
    private int moneyMade = 0;

    public void initializeGame() {
        initializeMoney();
        initializeMonumentHP();
        initializeTowerPrices();
    }

    public void initializeMoney() {
        switch (difficulty) {
        case "Expert":
            money = 450;
            break;
        case "Hard":
            money = 600;
            break;
        case "Medium":
            money = 750;
            break;
        case "Easy":
            money = 900;
            break;
        default:
            throw new IllegalArgumentException("Invalid Difficulty");
        }
    }

    public void initializeMonumentHP() {
        switch (difficulty) {
        case "Expert":
            monumentHP = 250;
            break;
        case "Hard":
            monumentHP = 500;
            break;
        case "Medium":
            monumentHP = 750;
            break;
        case "Easy":
            monumentHP = 1000;
            break;
        default:
            throw new IllegalArgumentException("Invalid Difficulty");
        }
    }

    public void initializeTowerPrices() {
        switch (difficulty) {
        case "Expert":
            towerPrices[0] = 300;
            towerPrices[1] = 400;
            towerPrices[2] = 500;
            break;
        case "Hard":
            towerPrices[0] = 250;
            towerPrices[1] = 325;
            towerPrices[2] = 400;
            break;
        case "Medium":
            towerPrices[0] = 200;
            towerPrices[1] = 250;
            towerPrices[2] = 300;
            break;
        case "Easy":
            towerPrices[0] = 150;
            towerPrices[1] = 175;
            towerPrices[2] = 200;
            break;
        default:
            throw new IllegalArgumentException("Invalid Difficulty");
        }
    }

    public void addTower(Tower newTower) {
        towerList.add(newTower);
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String newDifficulty) {
        difficulty = newDifficulty;
    }

    public List<Tower> getTowerList() {
        return towerList;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void addMoney(int amount) {
        money += amount;

        if (amount > 0) {
            addMoneyMade(amount);
        }
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getMonumentHP() {
        return monumentHP;
    }

    public int[] getTowerPrices() {
        return towerPrices;
    }

    public void reduceMonumentHP(int damage) {
        if (monumentHP - damage < 0) {
            monumentHP = 0;
        } else {
            monumentHP -= damage;
        }
    }

    public void setMoney(int amt) {
        if (amt < 0) {
            money = 0;
        } else {
            money = amt;
        }
    }

    public void addEnemyKilled() {
        enemiesKilled++;
    }

    public void addMoneyMade(int amt) {
        moneyMade += amt;
    }

    public void addDamageDealt(int amt) {
        damageDealt += amt;
    }

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public int getMoneyMade() {
        return moneyMade;
    }
}
