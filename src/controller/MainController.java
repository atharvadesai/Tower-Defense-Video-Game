package controller;

import java.util.HashMap;

import model.*;
import view.*;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController extends Application {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 666;

    private static Stage mainWindow;

    private static GameModel gameModel;

    private static WelcomeScreen welcomeScreen;
    private static ConfigScreen configScreen;
    private static InitialGameScreen gameScreen;
    private static ShopScreen shopScreen;
    private static GameOverScreen gameOverScreen;
    private static WinScreen winScreen;

    private static final HashMap<String, Scene> SCREENMAP = new HashMap<>();

    private static GameScreenHandler gameScreenHandler;
    private static WelcomeScreenHandler welcomeScreenHandler;
    private static ShopScreenHandler shopScreenHandler;
    private static ConfigScreenHandler configScreenHandler;
    private static TowerHandler towerHandler;
    private static MonsterHandler monsterHandler;
    private static GameOverHandler gameOverHandler;
    private static WinScreenHandler winScreenHandler;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;
        mainWindow.setTitle("PHAAB TD");
        mainWindow.setResizable(false);

        initializeNewGame();
    }

    public static void setScreen(String screen) {
        Scene scene = SCREENMAP.get(screen);
        updateAllLabels();
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    public static void updateAllLabels() {
        gameScreenHandler.updateMoneyLabel();
        gameScreenHandler.updateMonumentLabel();
        shopScreenHandler.updateMoneyLabel();
    }

    public static void initializeNewGame() {
        gameModel = new GameModel();

        welcomeScreen = new WelcomeScreen(WIDTH, HEIGHT);
        configScreen = new ConfigScreen(WIDTH, HEIGHT);
        gameScreen = new InitialGameScreen(WIDTH, HEIGHT);
        shopScreen = new ShopScreen(WIDTH, HEIGHT);
        gameOverScreen = new GameOverScreen(WIDTH, HEIGHT);
        winScreen = new WinScreen(WIDTH, HEIGHT);

        gameScreenHandler = new GameScreenHandler();
        welcomeScreenHandler = new WelcomeScreenHandler();
        shopScreenHandler = new ShopScreenHandler();
        configScreenHandler = new ConfigScreenHandler();
        towerHandler = new TowerHandler();
        monsterHandler = new MonsterHandler();
        gameOverHandler = new GameOverHandler();
        winScreenHandler = new WinScreenHandler();

        SCREENMAP.put("WelcomeScreen", welcomeScreen.getScene());
        SCREENMAP.put("ConfigScreen", configScreen.getScene());
        SCREENMAP.put("GameScreen", gameScreen.getScene());
        SCREENMAP.put("ShopScreen", shopScreen.getScene());
        SCREENMAP.put("GameOverScreen", gameOverScreen.getScene());
        SCREENMAP.put("WinScreen", winScreen.getScene());

        welcomeScreenHandler.initializeWelcomeScreen();
        setScreen("WelcomeScreen");
    }

    public static WelcomeScreen getWelcomeScreen() {
        return welcomeScreen;
    }

    public static ConfigScreen getConfigScreen() {
        return configScreen;
    }

    public static ShopScreen getShopScreen() {
        return shopScreen;
    }

    public static InitialGameScreen getGameScreen() {
        return gameScreen;
    }

    public static GameOverScreen getGameOverScreen() {
        return gameOverScreen;
    }

    public static WinScreen getWinScreen() {
        return winScreen;
    }

    public static GameModel getGameModel() {
        return gameModel;
    }

    public static ConfigScreenHandler getConfigScreenHandler() {
        return configScreenHandler;
    }

    public static GameScreenHandler getGameScreenHandler() {
        return gameScreenHandler;
    }

    public static TowerHandler getTowerHandler() {
        return towerHandler;
    }

    public static MonsterHandler getMonsterHandler() {
        return monsterHandler;
    }

    public static ShopScreenHandler getShopScreenHandler() {
        return shopScreenHandler;
    }

    public static GameOverHandler getGameOverHandler() {
        return gameOverHandler;
    }

    public static WinScreenHandler getWinScreenHandler() {
        return winScreenHandler;
    }
}
