import controller.MainController;
import model.*;

import javafx.application.Platform;
import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;

public class GameScreenTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController();
        controller.start(primaryStage);

        MainController.getGameModel().setDifficulty("Easy");
        MainController.getGameModel().setName("Test Name");
        MainController.getGameModel().initializeGame();

        MainController.getGameScreenHandler().initializeInitialGameScreen();
        MainController.getShopScreenHandler().initializeShopScreen();
        MainController.setScreen("GameScreen");
    }

    /*
    @Test
    public void testShopButton() {
        clickOn("SHOP");
        verifyThat("Tower Shop", NodeMatchers.isNotNull());
        verifyThat("Money: 900", NodeMatchers.isNotNull());
        verifyThat("Click a button to purchase a tower!", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPlacementOnMonument() {
        Platform.runLater(() -> MainController.getGameScreenHandler().setGameScreenPlacingTower(0));

        clickOn(MainController.getGameScreen().getMonument());

        assertTrue(MainController.getGameModel().getTowerList().isEmpty());
        verifyThat("Click to Place Tower, Right Click to Cancel", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPlacementOnPath() {
        Platform.runLater(() -> MainController.getGameScreenHandler().setGameScreenPlacingTower(0));

        clickOn(MainController.getGameScreen().getPath());

        assertTrue(MainController.getGameModel().getTowerList().isEmpty());
        verifyThat("Click to Place Tower, Right Click to Cancel", NodeMatchers.isNotNull());
    }

    @Test
    public void testCancelTowerPlacement() {
        Platform.runLater(() -> MainController.getGameScreenHandler().setGameScreenPlacingTower(0));

        moveTo(MainController.getGameScreen().getTowerArea());
        moveBy(0, 50);
        rightClickOn();

        assertTrue(MainController.getGameModel().getTowerList().isEmpty());
        verifyThat("Tower Shop", NodeMatchers.isNotNull());
        verifyThat("Money: 900", NodeMatchers.isNotNull());
        verifyThat("Click a button to purchase a tower!", NodeMatchers.isNotNull());
    }

    // End M3 Tests

    @Test(expected = org.testfx.service.query.EmptyNodeQueryException.class)
    public void testBeforeStartCombat() {
        verifyThat("#monster1", NodeMatchers.isNotNull());
    }

    @Test
    public void testCombatStart() {
        clickOn("Start Round");
        assertFalse(MainController.getGameModel().getMonsterList().isEmpty());
        verifyThat("#monster1", NodeMatchers.isNotNull());
    }

    @Test
    public void testMonumentHealthDecreases() {
        Platform.runLater(() -> {
            Monster testMonster = new BasicMonster();
            assertEquals(1000, MainController.getGameModel().getMonumentHP());
            MainController.getMonsterHandler().monsterAttack(testMonster);
            assertEquals(900, MainController.getGameModel().getMonumentHP());
        });
    }

    @Test
    public void testHealthLabelUpdateAfterDamage() {
        Platform.runLater(() -> {
            Monster testMonster = new BasicMonster();
            verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
            MainController.getMonsterHandler().monsterAttack(testMonster);
            verifyThat("Monument Health: 900", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testGameEnd() {
        Platform.runLater(() -> {
            MainController.getGameModel().reduceMonumentHP(900);
            Monster testMonster = new BasicMonster();
            MainController.getMonsterHandler().monsterAttack(testMonster);
            verifyThat("Game Over!", NodeMatchers.isNotNull());
            verifyThat("Better Luck Next Time!", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testShopDuringCombat() {
        clickOn("Start Round");
        sleep(5000);
        clickOn("SHOP");
        sleep(2000);
        clickOn("Back");
        verifyThat("#monster4", NodeMatchers.isNotNull());
    }

    @Test
    public void testPlaceTowerDuringCombat() {
        clickOn("Start Round");
        sleep(5000);
        clickOn("SHOP");
        sleep(2000);
        clickOn("Attacker\n     150");
        moveBy(0, 50);
        clickOn();
        verifyThat("#monster4", NodeMatchers.isNotNull());
        assertEquals(MainController.
                        getGameModel().
                        getTowerList().
                        get(0),
                new BasicTower(0.0, 0.0)
        );
    }

    // End M4 Tests

     */

    // Start M5 Tests
    /*
    @Test
    public void testRangeDisplay() {
        clickOn("SHOP");
        clickOn("Attacker\n     150");
        moveBy(0, 50);
        clickOn();
        moveBy(0, 100);
        moveBy(0, -100);
        verifyThat("#towerRange1", NodeMatchers.isNotNull());
    }

    @Test
    public void testZeroHPDamage() {
        Platform.runLater(() -> {
            Monster testMonster = new BasicMonster();
            MainController.getMonsterHandler().monsterTakeDamage(testMonster, 50);
            verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
            MainController.getMonsterHandler().monsterAttack(testMonster);
            verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testMoneyOnMonsterDefeat() {
        Platform.runLater(() -> {
            Monster testMonster = new BasicMonster();
            assertEquals(900, MainController.getGameModel().getMoney());
            MainController.getMonsterHandler().monsterTakeDamage(testMonster, 50);
            assertEquals(950, MainController.getGameModel().getMoney());
        });
    }

    @Test
    public void testMoneyLabelUpdateInCombat() {
        Platform.runLater(() -> {
            Monster monster1 = new BasicMonster();
            Monster monster2 = new BasicMonster();
            MainController.getGameModel().getMonsterList().add(monster1);
            MainController.getGameModel().getMonsterList().add(monster2);
            MainController.getMonsterHandler().startRound();

            sleep(1000);
            MainController.getMonsterHandler().monsterTakeDamage(monster1, 50);
            verifyThat("Money: 950", NodeMatchers.isNotNull());
            sleep(1000);
            MainController.getMonsterHandler().monsterTakeDamage(monster2, 50);
            verifyThat("Money: 1000", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testMonsterDeath() {
        Platform.runLater(() -> {
            Monster monster1 = new BasicMonster();
            monster1.getMonsterUI().setId("testMonster");
            MainController.getGameModel().getMonsterList().add(monster1);
            MainController.getMonsterHandler().startRound();

            sleep(1000);
            MainController.getMonsterHandler().monsterTakeDamage(monster1, 50);
            assertFalse(MainController
                    .getGameScreen()
                    .getTowerArea()
                    .getChildren()
                    .contains(monster1.getMonsterUI())
            );
        });
    }

    @Test
    public void testBasicMonsterDamage() {
        Platform.runLater(() -> {
            Monster testBasicMonster = new BasicMonster();
            assertEquals(1000, MainController.getGameModel().getMonumentHP());
            verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
            MainController.getMonsterHandler().monsterAttack(testBasicMonster);
            assertEquals(900, MainController.getGameModel().getMonumentHP());
            verifyThat("Monument Health: 900", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testStrongMonsterDamage() {
        Platform.runLater(() -> {
            Monster testBasicMonster = new StrongMonster();
            assertEquals(1000, MainController.getGameModel().getMonumentHP());
            verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
            MainController.getMonsterHandler().monsterAttack(testBasicMonster);
            assertEquals(850, MainController.getGameModel().getMonumentHP());
            verifyThat("Monument Health: 850", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testFastMonsterDamage() {
        Platform.runLater(() -> {
            Monster testBasicMonster = new FastMonster();
            assertEquals(1000, MainController.getGameModel().getMonumentHP());
            verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
            MainController.getMonsterHandler().monsterAttack(testBasicMonster);
            assertEquals(925, MainController.getGameModel().getMonumentHP());
            verifyThat("Monument Health: 925", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testBasicTowerDealsCorrectDamage() {
        Platform.runLater(() -> {
            Tower testBasicTower = new BasicTower(50, 50);
            Monster testMonster = new BasicMonster();
            assertEquals(50, testMonster.getHealth());
            MainController.getTowerHandler().towerAttack(testBasicTower, testMonster);
            assertEquals(40, testMonster.getHealth());
        });
    }

    @Test
    public void testSniperTowerDealsCorrectDamage() {
        Platform.runLater(() -> {
            Tower testSniperTower = new SniperTower(50, 50);
            Monster testMonster = new BasicMonster();
            assertEquals(50, testMonster.getHealth());
            MainController.getTowerHandler().towerAttack(testSniperTower, testMonster);
            assertEquals(35, testMonster.getHealth());
        });
    }

    @Test
    public void testStrongTowerDealsCorrectDamage() {
        Platform.runLater(() -> {
            Tower testStrongTower = new StrongTower(50, 50);
            Monster testMonster = new BasicMonster();
            assertEquals(50, testMonster.getHealth());
            MainController.getTowerHandler().towerAttack(testStrongTower, testMonster);
            assertEquals(30, testMonster.getHealth());
        });
    }

    @Test
    public void testMonsterHealthLabelUpdate() {
        Platform.runLater(() -> {
            Monster testMonster = new BasicMonster();
            MainController.getGameModel().getMonsterList().add(testMonster);
            MainController.getMonsterHandler().startRound();

            sleep(1000);
            Tower testBasicTower = new BasicTower(50, 50);
            assertEquals(50, testMonster.getHealth());
            verifyThat("" + 50, NodeMatchers.isNotNull());
            MainController.getTowerHandler().towerAttack(testBasicTower, testMonster);
            assertEquals(40, testMonster.getHealth());
            verifyThat("" + 40, NodeMatchers.isNotNull());
        });
    }
    // End M5 Tests
    */

    // Start M6 Tests
    @Test
    public void testTowersCorrectlyUpgraded() {
        Tower testStrongTower = new StrongTower(50, 50);
        Tower testBasicTower = new BasicTower(20, 20);
        Tower testSniperTower = new SniperTower(10, 50);
        MainController.getGameModel().getTowerList().add(testStrongTower);
        MainController.getGameModel().getTowerList().add(testBasicTower);
        MainController.getGameModel().getTowerList().add(testSniperTower);
        clickOn("Upgrade Towers: 500");
        assertEquals(30, testStrongTower.getAttack());
        assertEquals(20, testBasicTower.getAttack());
        assertEquals(25, testSniperTower.getAttack());
    }
    @Test
    public void testUpgradeTowerErrorMessage() {
        MainController.getGameModel().setMoney(300);
        clickOn("Upgrade Towers: 500");
        verifyThat("Not Enough Money to Upgrade", NodeMatchers.isNotNull());
    }

    @Test
    public void testFinalBossAppears() {
        Platform.runLater(() -> {
            MainController.getMonsterHandler().initializeWave();
            assertTrue(MainController
                    .getGameModel()
                    .getMonsterList()
                    .get(MainController.getGameModel().getMonsterList().size() - 1) instanceof BossMonster);
        });
    }
    @Test
    public void testEnemiesKilledStatisticsUpdates() {
        Platform.runLater(() -> {
            Monster testBasicMonster = new BasicMonster();
            Monster testFastMonster = new FastMonster();
            Monster testStrongMonster = new StrongMonster();
            MainController.getMonsterHandler().monsterTakeDamage(testBasicMonster, 50);
            MainController.getMonsterHandler().monsterTakeDamage(testFastMonster, 30);
            MainController.getMonsterHandler().monsterTakeDamage(testStrongMonster, 80);
            assertEquals(3, MainController.getGameModel().getEnemiesKilled());
        });
    }

    @Test
    public void testMoneyEarnedStatisticsUpdates() {
        Platform.runLater(() -> {
            Monster testBasicMonster = new BasicMonster();
            Monster testFastMonster = new FastMonster();
            Monster testStrongMonster = new StrongMonster();
            MainController.getMonsterHandler().monsterTakeDamage(testBasicMonster, 50);
            MainController.getMonsterHandler().monsterTakeDamage(testFastMonster, 30);
            MainController.getMonsterHandler().monsterTakeDamage(testStrongMonster, 80);
            assertEquals(150, MainController.getGameModel().getMoneyMade());
        });
    }

    @Test
    public void testDamageDealtStatisticsUpdates() {
        Platform.runLater(() -> {
            Monster testBasicMonster = new BasicMonster();
            Monster testFastMonster = new FastMonster();
            Monster testStrongMonster = new StrongMonster();
            MainController.getMonsterHandler().monsterTakeDamage(testBasicMonster, 50);
            MainController.getMonsterHandler().monsterTakeDamage(testFastMonster, 30);
            MainController.getMonsterHandler().monsterTakeDamage(testStrongMonster, 80);
            assertEquals(160, MainController.getGameModel().getDamageDealt());
        });
    }

    @Test
    public void testWinGame() {
        Platform.runLater(() -> {
            Monster testBoss = new BossMonster();
            MainController.getMonsterHandler().monsterTakeDamage(testBoss, 400);

            verifyThat("You Won!", NodeMatchers.isNotNull());
            verifyThat("Great Job! Look at your stats below", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testWinScreenStats() {
        Platform.runLater(() -> {
            Monster testBasicMonster = new BasicMonster();
            Monster testFastMonster = new FastMonster();
            Monster testStrongMonster = new StrongMonster();

            MainController.getMonsterHandler().monsterTakeDamage(testBasicMonster, 100);
            MainController.getMonsterHandler().monsterTakeDamage(testFastMonster, 30);
            MainController.getMonsterHandler().monsterTakeDamage(testStrongMonster, 40);

            MainController.getWinScreenHandler().initializeWinScreen();
            MainController.getGameScreenHandler().winGame();


            verifyThat("Total Enemies Killed: " + MainController.getGameModel().getEnemiesKilled(), NodeMatchers.isNotNull());
            verifyThat("Total Damage Dealt: " + MainController.getGameModel().getDamageDealt(), NodeMatchers.isNotNull());
            verifyThat("Total Money Earned: " + MainController.getGameModel().getMoneyMade(), NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testGameOverScreenStats() {
        Platform.runLater(() -> {
            Monster testBasicMonster = new BasicMonster();
            Monster testFastMonster = new FastMonster();
            Monster testStrongMonster = new StrongMonster();

            MainController.getMonsterHandler().monsterTakeDamage(testBasicMonster, 100);
            MainController.getMonsterHandler().monsterTakeDamage(testFastMonster, 30);
            MainController.getMonsterHandler().monsterTakeDamage(testStrongMonster, 40);

            MainController.getGameOverHandler().initializeGameOverScreen();
            MainController.getGameScreenHandler().endGame();

            verifyThat("Total Enemies Killed: " + MainController.getGameModel().getEnemiesKilled(), NodeMatchers.isNotNull());
            verifyThat("Total Damage Dealt: " + MainController.getGameModel().getDamageDealt(), NodeMatchers.isNotNull());
            verifyThat("Total Money Earned: " + MainController.getGameModel().getMoneyMade(), NodeMatchers.isNotNull());
        });
    }

}