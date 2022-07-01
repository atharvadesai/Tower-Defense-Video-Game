import controller.MainController;

import model.Tower;
import model.BasicTower;
import model.Monster;

import java.util.LinkedList;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.testfx.api.FxAssert.verifyThat;

public class ControllerTest extends ApplicationTest {

    // Old Test File
    // keep for reference to old tests.
    
    private MainController controller;

    @Override
    public void start(Stage primaryStage) {
        controller = new MainController();
        controller.start(primaryStage);
    }

    /*
    @Test
    public void testPlay() {
        clickOn("Play!");
        verifyThat("Enter Your Name: ", NodeMatchers.isNotNull());
        verifyThat("Choose Your Difficulty Level: ", NodeMatchers.isNotNull());
        verifyThat("Start Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testNullName() {
        clickOn("Play!");
        clickOn("Start Game");
        verifyThat("Please Enter a Valid Name", NodeMatchers.isNotNull());
    }

    @Test
    public void testWhitespaceName() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(KeyCode.SPACE, 10);
        clickOn("Start Game");
        verifyThat("Please Enter a Valid Name", NodeMatchers.isNotNull());
    }

    @Test
    public void testComboBox() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );
        clickOn("Start Game");
        verifyThat("Please Select a Difficulty", NodeMatchers.isNotNull());
    }

    @Test
    public void testGameScreen() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );
        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        verifyThat("SHOP", NodeMatchers.isNotNull());
        verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
        verifyThat("Player: test name", NodeMatchers.isNotNull());
        verifyThat("Money: 900", NodeMatchers.isNotNull());
    }

    // end M2 tests


    @Test
    public void testPurchaseMoneyAmt() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );
        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        clickOn("Attacker\n     150");
        moveBy(0, 50);
        clickOn();
        verifyThat("Money: 750", NodeMatchers.isNotNull());
        assertEquals(MainController.getGameModel().getMoney(), 750);
    }

    @Test
    public void testLackOfFunds() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );
        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("SHOP");
        clickOn("Strong Attacker\n             500");
        verifyThat("You do not have enough money to buy Strong Attacker", NodeMatchers.isNotNull());
    }

    @Test
    public void testShopButton() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        verifyThat("Tower Shop", NodeMatchers.isNotNull());
        verifyThat("Money: 900", NodeMatchers.isNotNull());
        verifyThat("Click a button to purchase a tower!", NodeMatchers.isNotNull());
    }

    @Test
    public void testShopBackButton() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );
        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        clickOn("Back");

        verifyThat("SHOP", NodeMatchers.isNotNull());
        verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
        verifyThat("Player: test name", NodeMatchers.isNotNull());
        verifyThat("Money: 900", NodeMatchers.isNotNull());
    }

    @Test
    public void testShopPurchaseButtons() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );
        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        clickOn("Attacker\n     150");
        verifyThat("Click to Place Tower, Right Click to Cancel", NodeMatchers.isNotNull());
        moveBy(0, 50);
        rightClickOn();
        clickOn("Fast Attacker\n          175");
        verifyThat("Click to Place Tower, Right Click to Cancel", NodeMatchers.isNotNull());
        moveBy(0, 50);
        rightClickOn();
        clickOn("Strong Attacker\n             200");
        verifyThat("Click to Place Tower, Right Click to Cancel", NodeMatchers.isNotNull());
    }

    @Test
    public void testCorrectTowerPlacement() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );
        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        clickOn("Attacker\n     150");
        verifyThat("Click to Place Tower, Right Click to Cancel", NodeMatchers.isNotNull());
        moveBy(0, 50);
        clickOn();
        assertEquals(MainController.
                getGameModel().
                getTowerList().
                get(0),
                new BasicTower(0.0, 0.0)
        );
    }

    @Test
    public void testTowerPlacementOnPath() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        clickOn("Attacker\n     150");
        clickOn(MainController.getGameScreen().getPath());

        verifyThat("Click to Place Tower, Right Click to Cancel", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPlacementOnMonument() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        clickOn("Attacker\n     150");
        clickOn(MainController.getGameScreen().getMonument());

        verifyThat("Click to Place Tower, Right Click to Cancel", NodeMatchers.isNotNull());
    }

    @Test
    public void testCancelTowerPlacement() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        clickOn("Attacker\n     150");
        moveBy(0, 50);
        rightClickOn();

        verifyThat("Tower Shop", NodeMatchers.isNotNull());
        verifyThat("Money: 900", NodeMatchers.isNotNull());
        verifyThat("Click a button to purchase a tower!", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPriceByDifficultyEasy() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("SHOP");
        verifyThat("Attacker\n     150", NodeMatchers.isNotNull());
        verifyThat("Fast Attacker\n          175", NodeMatchers.isNotNull());
        verifyThat("Strong Attacker\n             200", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPriceByDifficultyMedium() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Medium");
        clickOn("Start Game");
        clickOn("SHOP");
        verifyThat("Attacker\n     200", NodeMatchers.isNotNull());
        verifyThat("Fast Attacker\n          250", NodeMatchers.isNotNull());
        verifyThat("Strong Attacker\n             300", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPriceByDifficultyHard() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Hard");
        clickOn("Start Game");
        clickOn("SHOP");
        verifyThat("Attacker\n     250", NodeMatchers.isNotNull());
        verifyThat("Fast Attacker\n          325", NodeMatchers.isNotNull());
        verifyThat("Strong Attacker\n             400", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPriceByDifficultyExpert() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("SHOP");
        verifyThat("Attacker\n     300", NodeMatchers.isNotNull());
        verifyThat("Fast Attacker\n          400", NodeMatchers.isNotNull());
        verifyThat("Strong Attacker\n             500", NodeMatchers.isNotNull());
    }

    //end M3 tests

    */

    @Test(expected = org.testfx.service.query.EmptyNodeQueryException.class)
    public void testBeforeStartCombat() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        verifyThat("#monster1", NodeMatchers.isNotNull());
    }

    @Test
    public void testCombatStart() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("Start Round");
        verifyThat("#monster1", NodeMatchers.isNotNull());
    }

    @Test
    public void testMonumentHealthDecreases() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );
        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("Start Round");
        assertEquals(1000, MainController.getGameModel().getMonumentHP());
        sleep(10100);
        assertEquals(900, MainController.getGameModel().getMonumentHP());
    }

    @Test
    public void testHealthLabelUpdateAfterDamage() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Easy");
        clickOn("Start Game");
        clickOn("Start Round");
        verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
        sleep(10500);
        verifyThat("Monument Health: 900", NodeMatchers.isNotNull());
    }

    @Test
    public void testGameEnd() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("Start Round");
        sleep(16100);
        verifyThat("Game Over!", NodeMatchers.isNotNull());
        verifyThat("Better Luck Next Time!", NodeMatchers.isNotNull());
    }

    @Test
    public void testRestartWelcomeScreen() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("Start Round");
        sleep(16100);
        clickOn("Restart");
        verifyThat("Welcome to PHAAB TD", NodeMatchers.isNotNull());
    }

    @Test
    public void testRestartNewGame() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("Start Round");
        sleep(16100);
        clickOn("Restart");
        assertNull(MainController.getGameModel().getName());
        assertNull(MainController.getGameModel().getDifficulty());
        assertEquals(0, MainController.getGameModel().getMoney());
        assertEquals(0, MainController.getGameModel().getMonumentHP());
        assertEquals(new LinkedList<Tower>(), MainController.getGameModel().getTowerList());
        assertEquals(new LinkedList<Monster>(), MainController.getGameModel().getMonsterList());
    }

    @Test
    public void testEndGameButton() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("Start Round");
        sleep(16100);
        verifyThat("End Game", NodeMatchers.isNotNull());
    }

    @Test
    public void testShopDuringCombat() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("Start Round");
        sleep(5000);
        clickOn("SHOP");
        sleep(2000);
        clickOn("Back");
        verifyThat("#monster1", NodeMatchers.isNotNull());
    }

    @Test
    public void testPlaceTowerDuringCombat() {
        clickOn("Play!");
        clickOn("e.g. John Doe").type(
                KeyCode.T,
                KeyCode.E,
                KeyCode.S,
                KeyCode.T,
                KeyCode.SPACE,
                KeyCode.N,
                KeyCode.A,
                KeyCode.M,
                KeyCode.E
        );

        clickOn("Choose a Difficulty");
        clickOn("Expert");
        clickOn("Start Game");
        clickOn("Start Round");
        sleep(9000);
        clickOn("SHOP");
        sleep(4000);
        clickOn("Attacker\n     300");
        moveBy(0, 50);
        clickOn();
        verifyThat("#monster1", NodeMatchers.isNotNull());
        assertEquals(MainController.
                getGameModel().
                getTowerList().
                get(0),
                new BasicTower(0.0, 0.0)
        );
    }

    // End M4 Tests

}