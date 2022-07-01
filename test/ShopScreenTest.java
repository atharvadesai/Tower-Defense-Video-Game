import controller.MainController;
import model.BasicTower;

import javafx.application.Platform;
import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;

public class ShopScreenTest extends ApplicationTest {

    // I changed the tower names to reflect the new design (they all have same attack speed)
    // so a lot of our previous tests are broken, since the buttons and description labels now have
    // different text.

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController();
        controller.start(primaryStage);

        MainController.getGameModel().setDifficulty("Easy");
        MainController.getGameModel().setName("Test Name");
        MainController.getGameModel().initializeGame();

        MainController.getGameScreenHandler().initializeInitialGameScreen();
        MainController.getShopScreenHandler().initializeShopScreen();
        MainController.setScreen("ShopScreen");
    }

    @Test
    public void testPurchaseMoneyAmt() {
        clickOn("Attacker\n     150");
        moveBy(0, 50);
        clickOn();
        verifyThat("Money: 750", NodeMatchers.isNotNull());
        assertEquals(MainController.getGameModel().getMoney(), 750);
    }

    @Test
    public void testLackOfFunds() {
        MainController.getGameModel().setMoney(100);

        clickOn("Strong Attacker\n             200");
        assertTrue(MainController.getGameModel().getTowerList().isEmpty());
        verifyThat("You do not have enough money to buy Strong Attacker", NodeMatchers.isNotNull());
    }

    @Test
    public void testShopBackButton() {
        clickOn("Back");

        verifyThat("SHOP", NodeMatchers.isNotNull());
        verifyThat("Monument Health: 1000", NodeMatchers.isNotNull());
        verifyThat("Player: Test Name", NodeMatchers.isNotNull());
        verifyThat("Money: 900", NodeMatchers.isNotNull());
    }

    @Test
    public void testShopPurchaseButtons() {
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
    public void testTowerPriceByDifficultyEasy() {
        int[] expectedPrices = new int[3];
        expectedPrices[0] = 150;
        expectedPrices[1] = 175;
        expectedPrices[2] = 200;

        assertArrayEquals(expectedPrices, MainController.getGameModel().getTowerPrices());

        verifyThat("Attacker\n     150", NodeMatchers.isNotNull());
        verifyThat("Fast Attacker\n          175", NodeMatchers.isNotNull());
        verifyThat("Strong Attacker\n             200", NodeMatchers.isNotNull());
    }

    @Test
    public void testTowerPriceByDifficultyMedium() {
        Platform.runLater(() -> {
            MainController.getGameModel().setDifficulty("Medium");
            MainController.getGameModel().setName("Test Name");
            MainController.getGameModel().initializeGame();

            MainController.getGameScreenHandler().initializeInitialGameScreen();
            MainController.getShopScreenHandler().initializeShopScreen();
            MainController.setScreen("ShopScreen");

            int[] expectedPrices = new int[3];
            expectedPrices[0] = 200;
            expectedPrices[1] = 250;
            expectedPrices[2] = 300;

            assertArrayEquals(expectedPrices, MainController.getGameModel().getTowerPrices());

            verifyThat("Attacker\n     200", NodeMatchers.isNotNull());
            verifyThat("Fast Attacker\n          250", NodeMatchers.isNotNull());
            verifyThat("Strong Attacker\n             300", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testTowerPriceByDifficultyHard() {
        Platform.runLater(() -> {
            MainController.getGameModel().setDifficulty("Hard");
            MainController.getGameModel().setName("Test Name");
            MainController.getGameModel().initializeGame();

            MainController.getGameScreenHandler().initializeInitialGameScreen();
            MainController.getShopScreenHandler().initializeShopScreen();
            MainController.setScreen("ShopScreen");

            int[] expectedPrices = new int[3];
            expectedPrices[0] = 250;
            expectedPrices[1] = 325;
            expectedPrices[2] = 400;

            assertArrayEquals(expectedPrices, MainController.getGameModel().getTowerPrices());

            verifyThat("Attacker\n     250", NodeMatchers.isNotNull());
            verifyThat("Fast Attacker\n          325", NodeMatchers.isNotNull());
            verifyThat("Strong Attacker\n             400", NodeMatchers.isNotNull());
        });
    }

    @Test
    public void testTowerPriceByDifficultyExpert() {
        Platform.runLater(() -> {
            MainController.getGameModel().setDifficulty("Expert");
            MainController.getGameModel().setName("Test Name");
            MainController.getGameModel().initializeGame();

            MainController.getGameScreenHandler().initializeInitialGameScreen();
            MainController.getShopScreenHandler().initializeShopScreen();
            MainController.setScreen("ShopScreen");

            int[] expectedPrices = new int[3];
            expectedPrices[0] = 300;
            expectedPrices[1] = 400;
            expectedPrices[2] = 500;

            assertArrayEquals(expectedPrices, MainController.getGameModel().getTowerPrices());

            verifyThat("Attacker\n     300", NodeMatchers.isNotNull());
            verifyThat("Fast Attacker\n          400", NodeMatchers.isNotNull());
            verifyThat("Strong Attacker\n             500", NodeMatchers.isNotNull());
        });
    }

    // End M3 Tests

    // Note:
    // Some (Different From Last Time) test fail when everything is run together.
    // However, all tests run fine individually.
    // This is probably something to do w/ the Platform.runLater() that I added.

}