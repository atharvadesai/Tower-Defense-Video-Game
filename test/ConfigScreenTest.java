import controller.MainController;

import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import javafx.scene.input.KeyCode;

import static org.testfx.api.FxAssert.verifyThat;

public class ConfigScreenTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController();
        controller.start(primaryStage);

        MainController.getConfigScreenHandler().initializeConfigScreen();
        MainController.setScreen("ConfigScreen");
    }

    @Test
    public void testNullName() {
        clickOn("Start Game");
        verifyThat("Please Enter a Valid Name", NodeMatchers.isNotNull());
    }

    @Test
    public void testWhitespaceName() {
        clickOn("e.g. John Doe").type(KeyCode.SPACE, 10);
        clickOn("Start Game");
        verifyThat("Please Enter a Valid Name", NodeMatchers.isNotNull());
    }

    @Test
    public void testComboBox() {
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
    public void testStartGameBtn() {
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

    // End M2 Tests
}

