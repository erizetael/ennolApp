package com.rizal.app;

import com.rizal.cafe.Cafe;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.Month;


public class MainMenu {
    private BorderPane layout;
    private Button buttonCafe, buttonPulsa, buttonLaciUang, buttonBelanja, buttonChange, buttonHome;
    private Cafe cafe;
    private LaciUang laciUang;
    private Belanja belanja;
    private int minute;
    private int hour;
    private int second;
    private int day, month, year;



    public void showMain() {
        Button button = new Button("Cafe");
        Stage stage = new Stage();
        stage.setOnCloseRequest(event -> close());
        stage.setTitle("ennol 1.0");
        layout = new BorderPane();
        layout.setTop(showMenuBar());
        layout.setBottom(showBottom());
        layout.setCenter(showHome());
        layout.setLeft(showLeftMenu());
        Scene scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    // show toolbar atas
    public VBox showMenuBar() {
        //Button home
        buttonHome = new Button("Home", setImageView("/com/rizal/picture/home.png"));
        buttonHome.setPrefSize(110, 30);
        buttonHome.setOnAction(event -> layout.setCenter(showHome()));
        //Button cafe
        buttonCafe = new Button("Cafe", setImageView("/com/rizal/picture/cappucino.png"));
        buttonCafe.setPrefSize(110, 30);
        buttonCafe.setOnAction(event -> layout.setCenter(showCafeVBox()));

        //Button Laci Uang
        buttonLaciUang = new Button("Laci Uang", setImageView("/com/rizal/picture/money.png"));
        buttonLaciUang.setPrefSize(110, 30);
        buttonLaciUang.setOnAction(event -> layout.setCenter(showLaciUangBox()));

        //Button Belanja
        buttonBelanja = new Button("Belanja", setImageView("/com/rizal/picture/trolley.png"));
        buttonBelanja.setPrefSize(110, 30);
        buttonBelanja.setOnAction(event -> layout.setCenter(showBelanja()));

        buttonChange = new Button("Change", setImageView("/com/rizal/picture/user.png"));
        buttonChange.setPrefSize(110, 30);
        buttonChange.setOnAction(event -> changeShift());

        StackPane stackPane = new StackPane();
        HBox.setHgrow(stackPane, Priority.ALWAYS);

        HBox menuBox = new HBox(10, buttonHome, buttonCafe, buttonLaciUang, buttonBelanja, stackPane, buttonChange);
        menuBox.setPadding(new Insets(10));
        menuBox.setStyle("-fx-background-color: dimgray");
        menuBox.getStylesheets().add("/com/rizal/css/menuStyle.css");
        VBox barMenu = new VBox();
        barMenu.getChildren().addAll(showMenuAtas(), menuBox);
        return barMenu;
    }

    private void changeShift() {
        System.out.println("Ini menu ganti shift");
    }

    private void close() {
        System.out.println("Aplikasi akan segera ditutup..");
        Platform.exit();
    }
    // menu bawah
    public HBox showBottom() {
        // Tampilkan Jam
        Label time = new Label();
        Label tanggal = new Label();
        time.setTextFill(Color.WHITESMOKE);
        tanggal.setTextFill(Color.WHITESMOKE);
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalDateTime currentTime = LocalDateTime.now();
            second = currentTime.getSecond();
            minute = currentTime.getMinute();
            hour = currentTime.getHour();
            day = currentTime.getDayOfMonth();
            Month month = currentTime.getMonth();
            year = currentTime.getYear();

//            LocalDate localDate = currentTime.toLocalDate();
            time.setText(hour + " : " + (minute) + " : " + second);
            tanggal.setText(day + "  " +month+"  "+year);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        Label operator = new Label("Operator :");
        operator.setTextFill(Color.WHITE);
        Label namaOP = new Label("Budi Romanto");
        namaOP.setTextFill(Color.ANTIQUEWHITE);
        StackPane stackPane = new StackPane();
        HBox.setHgrow(stackPane, Priority.ALWAYS);
        HBox bottomBox = new HBox(10);
        VBox timeBox = new VBox();
        timeBox.setAlignment(Pos.CENTER);
        timeBox.getChildren().addAll(time, tanggal);
        bottomBox.setPadding(new Insets(10));
        bottomBox.setStyle("-fx-background-color: dimgray");
        bottomBox.getChildren().addAll(operator, namaOP, stackPane, timeBox);
        return bottomBox;
    }

    // Methode untuk buat icon di button
    public ImageView setImageView(String imagePath) {
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        return imageView;
    }

    //Cafe
    public VBox showCafeVBox() {
        Label label = new Label("Cafe Merapi Online");
        label.setTextFill(Color.DIMGREY);
        label.setFont(new Font("Arial", 24));
        cafe = new Cafe();
        VBox cafeBox = new VBox(10, label, cafe.showTableCafe());
        cafeBox.setPadding(new Insets(10));
        cafeBox.setAlignment(Pos.CENTER);
        return cafeBox;
    }

    //Laci Uang
    public HBox showLaciUangBox() {
        laciUang = new LaciUang();
        HBox laciBox = new HBox(10, laciUang.showLaciAtas(), laciUang.showLaciBawah());
        laciBox.setAlignment(Pos.CENTER);
        laciBox.setPadding(new Insets(20));
        return laciBox;
    }

    // Belanja
    public VBox showBelanja() {
        VBox belanjaBox = new VBox(10);
        belanja = new Belanja();
        belanjaBox.setAlignment(Pos.CENTER);
        belanjaBox.getChildren().addAll(belanja.showBelanja());
        return belanjaBox;
    }

    // Show MenuBar
    public MenuBar showMenuAtas() {
        MenuItem itemNew = new MenuItem("New");
        MenuItem itemOpen = new MenuItem("Open");
        MenuItem itemExit = new MenuItem("Exit");
        itemExit.setOnAction(event -> close());
        Menu menuFile = new Menu("File");
        menuFile.getItems().addAll(itemNew, itemOpen, itemExit);
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        return menuBar;
    }

    // Show Home
    public StackPane showHome() {
        StackPane homePane = new StackPane();
        Label welcome = new Label("Sugeng Rawuh");
        welcome.setTextFill(Color.SANDYBROWN);
        welcome.setFont(new Font("Script MT Bold", 60));
        homePane.getChildren().addAll(welcome);
        return homePane;
    }

    // Left Menu
    public VBox showLeftMenu() {
        Button buttonDB = new Button("Database Cafe");
        buttonDB.getStylesheets().add("/com/rizal/css/styles1.css");

        Button noTelp = new Button("Nomer Telp");
        noTelp.getStylesheets().add("/com/rizal/css/styles1.css");

        VBox leftPane = new VBox();
        leftPane.setAlignment(Pos.TOP_LEFT);
        leftPane.setPadding(new Insets(0, 10, 0, 10));
        leftPane.setStyle("-fx-background-color: dimgray");
        leftPane.setPrefWidth(150);
        leftPane.getChildren().addAll(buttonDB, noTelp);
        return leftPane;
    }

}
