package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.BorderWidths;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class InitialGameScreen {

    private final Label moneyLabel;
    private final Label nameLabel;
    private final Label monumentHealthLabel;
    private final Label infoLabel;
    private final Button towerShopBtn;
    private final Button startCombatButton;
    private final Button upgradeTowersBtn;

    private final Rectangle path;
    private final Rectangle monument;
    private final Rectangle monumentBase;

    private final Rectangle pathTowerLayer;
    private final Rectangle monumentTowerLayer;
    private final Rectangle monumentBaseTowerLayer;

    private final Pane towerArea;

    private final Scene scene;

    public InitialGameScreen(int width, int height) {

        moneyLabel = new Label();
        moneyLabel.setFont(new Font("Impact", 30));

        nameLabel = new Label();
        nameLabel.setFont(new Font("Impact", 30));

        monumentHealthLabel = new Label();
        monumentHealthLabel.setFont(new Font("Impact", 30));

        infoLabel = new Label();
        infoLabel.setFont(new Font("Impact", 30));
        infoLabel.setTextFill(Color.RED);

        towerShopBtn = new Button("SHOP");
        towerShopBtn.setPrefSize(100, 100);
        towerShopBtn.setShape(new Circle(100));
        towerShopBtn.setFont(new Font("Impact", 25));

        upgradeTowersBtn = new Button("Upgrade Towers: 500");
        upgradeTowersBtn.setPrefSize(250, 75);
        upgradeTowersBtn.setFont(new Font("Impact", 25));

        path = new Rectangle(950, 50);
        path.setFill(Color.web("#ffcc00", 1.0));

        pathTowerLayer = new Rectangle(950, 50);
        pathTowerLayer.setFill(Color.web("#ffcc00", 1.0));

        monument = new Rectangle(50, 100);
        monument.setFill(Color.web("#e699ff", 1.0));

        monumentTowerLayer = new Rectangle(50, 100);
        monumentTowerLayer.setFill(Color.web("#e699ff", 1.0));

        monumentBase = new Rectangle(80, 20);
        monumentBase.setFill(Color.web("#e699ff", 1.0));

        monumentBaseTowerLayer = new Rectangle(80, 20);
        monumentBaseTowerLayer.setFill(Color.web("#e699ff", 1.0));

        startCombatButton = new Button("Start Round");
        startCombatButton.setFont(new Font("Impact", 30));

        VBox ui = new VBox(10, infoLabel, upgradeTowersBtn);
        ui.setAlignment(Pos.CENTER);

        BorderPane bottom = new BorderPane();
        BorderPane.setMargin(towerShopBtn, new Insets(15, 0, 0, 0));;
        BorderPane.setMargin(ui, new Insets(15, 0, 0, 0));
        BorderPane.setMargin(startCombatButton, new Insets(15, 0, 0, 0));
        BorderPane.setAlignment(startCombatButton, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(towerShopBtn, Pos.CENTER_LEFT);
        bottom.setLeft(towerShopBtn);
        bottom.setCenter(ui);
        bottom.setRight(startCombatButton);

        HBox gameLabels = new HBox(300, moneyLabel, monumentHealthLabel);

        VBox infoLabels = new VBox(20, nameLabel, gameLabels);

        towerArea = new Pane();
        towerArea.getChildren().addAll(pathTowerLayer, monumentTowerLayer, monumentBaseTowerLayer);
        pathTowerLayer.setLayoutX(0);
        pathTowerLayer.setLayoutY(200);
        monumentTowerLayer.setLayoutX(950);
        monumentTowerLayer.setLayoutY(160);
        monumentBaseTowerLayer.setLayoutX(935);
        monumentBaseTowerLayer.setLayoutY(260);

        Pane mapArea = new Pane();
        mapArea.getChildren().addAll(path, monument, monumentBase);
        path.setLayoutX(0);
        path.setLayoutY(200);
        monument.setLayoutX(950);
        monument.setLayoutY(160);
        monumentBase.setLayoutX(935);
        monumentBase.setLayoutY(260);

        StackPane mapTowers = new StackPane(mapArea, towerArea);

        BorderPane layout = new BorderPane();
        BorderPane.setMargin(infoLabels, new Insets(10, 20, 0, 20));
        BorderPane.setMargin(bottom, new Insets(0, 20, 10, 20));
        layout.setTop(infoLabels);
        layout.setBottom(bottom);
        layout.setCenter(mapTowers);

        layout.setStyle("-fx-background-color: #a29259");

        mapTowers.setBorder(new Border(new BorderStroke(
                Color.BLACK,
                BorderStrokeStyle.SOLID,
                CornerRadii.EMPTY,
                BorderWidths.DEFAULT
        )));

        scene = new Scene(layout, width, height);
    }


    public Scene getScene() {
        return scene;
    }

    public Label getMoneyLabel() {
        return moneyLabel;
    }

    public Label getMonumentHealthLabel() {
        return monumentHealthLabel;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public Label getInfoLabel() {
        return infoLabel;
    }

    public Pane getTowerArea() {
        return towerArea;
    }

    public Button getTowerShopBtn() {
        return towerShopBtn;
    }

    public Button getStartCombatButton() {
        return startCombatButton;
    }

    public Button getUpgradeTowersBtn() { return upgradeTowersBtn; }

    public Rectangle getMonument() {
        return monument;
    }

    public Rectangle getMonumentTowerLayer() {
        return monumentTowerLayer;
    }

    public Rectangle getMonumentBase() {
        return monumentBase;
    }

    public Rectangle getMonumentBaseTowerLayer() {
        return monumentBaseTowerLayer;
    }

    public Rectangle getPath() {
        return path;
    }

    public Rectangle getPathTowerLayer() {
        return pathTowerLayer;
    }

}
