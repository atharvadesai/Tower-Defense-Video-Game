import controller.MainController;

import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;

import static org.testfx.api.FxAssert.verifyThat;

public class WelcomeScreenTest extends ApplicationTest {

    @Override
    public void start(Stage primaryStage) {
        MainController controller = new MainController();
        controller.start(primaryStage);
    }

    @Test // M2
    public void testPlay() {
        clickOn("Play!");
        verifyThat("Enter Your Name: ", NodeMatchers.isNotNull());
        verifyThat("Choose Your Difficulty Level: ", NodeMatchers.isNotNull());
        verifyThat("Start Game", NodeMatchers.isNotNull());
    }

    // End M2 Tests
}
