package com.rizal.app;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LaciUang {
    private TableView tabelAtas, tabelBawah;
    private TableColumn colNominalBawah, colJumlahBawah, colNominalAtas, colJumlahAtas;

    public VBox showLaciAtas() {
        VBox laciAtas = new VBox(10);
        laciAtas.setAlignment(Pos.CENTER);
//        laciAtas.setMaxSize(400, 400);
        Label labelAtas = new Label("Laci Uang Atas");
        labelAtas.setTextFill(Color.DIMGREY);
        labelAtas.setFont(new Font("Arial", 18));
        tabelAtas = new TableView();
        colNominalAtas = new TableColumn("Nominal");
        colNominalAtas.setPrefWidth(150.0);
        colJumlahAtas = new TableColumn("Jumlah");
        colJumlahAtas.setPrefWidth(150.0);
        tabelAtas.getColumns().addAll(colNominalAtas,colJumlahAtas);
        laciAtas.getChildren().addAll(labelAtas,tabelAtas);
        return laciAtas;
    }

    public VBox showLaciBawah() {
        VBox laciBawah = new VBox(10);
        laciBawah.setAlignment(Pos.CENTER);
        Label labelBawah = new Label("Laci Uang Bawah");
        labelBawah.setTextFill(Color.DIMGREY);
        labelBawah.setFont(new Font("Arial", 18));
//        laciBawah.setMaxSize(400, 400);
        tabelBawah = new TableView();
        colNominalBawah = new TableColumn("Nominal");
        colNominalBawah.setPrefWidth(150.0);
        colJumlahBawah = new TableColumn("Jumlah");
        colJumlahBawah.setPrefWidth(150.0);
        tabelBawah.getColumns().addAll(colNominalBawah,colJumlahBawah);
        laciBawah.getChildren().addAll(labelBawah,tabelBawah);
        return laciBawah;
    }



}
