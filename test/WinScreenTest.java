import controller.MainController;
import model.Tower;
import model.Monster;

import java.util.LinkedList;

import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.testfx.api.FxAssert.verifyThat;

public class WinScreenTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController();
        controller.start(primaryStage);

        MainController.getWinScreenHandler().initializeWinScreen();
        MainController.getGameScreenHandler().winGame();
    }

    // Start M6 Tests

    @Test
    public void testWinGameRestart() {
        clickOn("Play Again!");

        verifyThat("Welcome to PHAAB TD", NodeMatchers.isNotNull());

        assertNull(MainController.getGameModel().getName());
        assertNull(MainController.getGameModel().getDifficulty());
        assertEquals(0, MainController.getGameModel().getMoney());
        assertEquals(0, MainController.getGameModel().getMonumentHP());
        assertEquals(new LinkedList<Tower>(), MainController.getGameModel().getTowerList());
        assertEquals(new LinkedList<Monster>(), MainController.getGameModel().getMonsterList());
    }

}
