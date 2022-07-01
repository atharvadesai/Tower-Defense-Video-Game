package controller;

import javafx.animation.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import model.*;
import view.InitialGameScreen;

import java.util.List;
import java.util.LinkedList;

import javafx.util.Duration;

public class MonsterHandler {

    private final InitialGameScreen gameScreen = MainController.getGameScreen();
    private final GameModel gameModel = MainController.getGameModel();
    private final TowerHandler towerHandler = MainController.getTowerHandler();

    private final List<TranslateTransition> monsterAnimations = new LinkedList<>();

    private AnimationTimer collisionTimer = new AnimationTimer() {
        private long prevTime = 0;
        private double delay = 1;  // in seconds

        @Override
        public void handle(long now) {
            if (now - prevTime < delay * 1000000000) {
                return;
            }
            prevTime = now;
            checkMonsterInRange();
        }
    };

    public void startRound() {
        collisionTimer.start();

        // creating and adding all animations to a list for each monster.
        int queueCount = 0;
        int delayDuration = 1500;
        for (Monster monster : gameModel.getMonsterList()) {
            TranslateTransition monsterMove = new TranslateTransition();
            monsterMove.setInterpolator(Interpolator.LINEAR);

            gameScreen.getTowerArea().getChildren().add(monster.getMonsterUI());

            monsterMove.setNode(monster.getMonsterUI());
            monsterMove.setDuration(Duration.millis(monster.getTravelDuration()));
            monsterMove.setByX(970);

            monsterMove.setDelay(Duration.millis(delayDuration * queueCount));
            queueCount++;

            monsterMove.setOnFinished(e -> {
                gameScreen.getTowerArea().getChildren().remove(monster.getMonsterUI());
                if (monster.getHealth() > 0) {
                    monsterAttack(monster);

                    if (monster instanceof BossMonster && gameModel.getMonumentHP() > 0) {
                        cancelAnimations();
                        MainController.getWinScreenHandler().initializeWinScreen();
                        MainController.getGameScreenHandler().winGame();
                    }
                }
            });

            monsterAnimations.add(monsterMove);
        }

        // playing all animations
        for (TranslateTransition monsterMove : monsterAnimations) {
            monsterMove.play();
        }
    }

    // helper method to cancel the rest of the running animations after game ends
    private void cancelAnimations() {
        for (TranslateTransition animation : monsterAnimations) {
            if (animation.getStatus() == Animation.Status.RUNNING) {
                animation.stop();
            }
        }
        collisionTimer.stop();
    }

    public void initializeWave() {
        Monster newMonster;
        for (int i = 1; i <= 3; i++) {
            newMonster = new FastMonster();
            newMonster.getMonsterUI().setId("monster" + i);
            gameModel.getMonsterList().add(newMonster);
        }
        for (int i = 4; i <= 6; i++) {
            newMonster = new BasicMonster();
            newMonster.getMonsterUI().setId("monster" + i);
            gameModel.getMonsterList().add(newMonster);
        }
        for (int i = 7; i <= 10; i++) {
            newMonster = new StrongMonster();
            newMonster.getMonsterUI().setId("monster" + i);
            gameModel.getMonsterList().add(newMonster);
        }
        for (int i = 11; i <= 15; i++) {
            newMonster = new BasicMonster();
            newMonster.getMonsterUI().setId("monster" + i);
            gameModel.getMonsterList().add(newMonster);
        }
        for (int i = 15; i <= 20; i++) {
            newMonster = new StrongMonster();
            newMonster.getMonsterUI().setId("monster" + i);
            gameModel.getMonsterList().add(newMonster);
        }
        for (int i = 20; i <= 25; i++) {
            newMonster = new FastMonster();
            newMonster.getMonsterUI().setId("monster" + i);
            gameModel.getMonsterList().add(newMonster);
        }
        newMonster = new BossMonster();
        newMonster.getMonsterUI().setId("monsterBoss");
        gameModel.getMonsterList().add(newMonster);
    }

    public void checkMonsterInRange() {
        boolean attacked;

        for (Tower tower : gameModel.getTowerList()) {
            attacked = false;
            for (Monster monster : gameModel.getMonsterList()) {
                if (monster.
                        getMonsterUI().
                        getBoundsInParent().
                        intersects(tower.getTowerRange().getBoundsInParent())) {
                    if (monster.getHealth() > 0) {
                        towerHandler.towerAttack(tower, monster);
                        attacked = true;
                    }
                }
            }
            if (attacked) {
                Paint temp = tower.getTowerUI().getFill();

                tower.getTowerUI().setFill(Color.YELLOWGREEN);

                PauseTransition pause = new PauseTransition(Duration.millis(200));
                pause.setOnFinished(e -> {
                    tower.getTowerUI().setFill(temp);
                });

                pause.play();
            }
        }
    }

    public void monsterAttack(Monster monster) {
        if (monster.getHealth() > 0) {
            gameModel.reduceMonumentHP(monster.getDamage());
            MainController.updateAllLabels();
        }
        if (gameModel.getMonumentHP() <= 0) {
            cancelAnimations();
            MainController.getGameOverHandler().initializeGameOverScreen();
            MainController.getGameScreenHandler().endGame();
        }
    }

    public void monsterTakeDamage(Monster monster, int damage) {
        gameModel.addDamageDealt(Math.min(damage, monster.getHealth()));
        monster.loseHealth(damage);

        if (monster.getHealth() == 0) {
            gameScreen.getTowerArea().getChildren().remove(monster.getMonsterUI());

            gameModel.addMoney(50);
            gameModel.addEnemyKilled();
            MainController.updateAllLabels();

            if (monster instanceof BossMonster) {
                cancelAnimations();
                MainController.getWinScreenHandler().initializeWinScreen();
                MainController.getGameScreenHandler().winGame();
            }
        }
    }

}
