package com.rizal.app;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Belanja {
    private TableColumn colNama, colJumlah;
    private TableView tableBelanja;

    public VBox showBelanja() {
        VBox belanjaBox = new VBox(10);
        belanjaBox.setPadding(new Insets(10));
        belanjaBox.setAlignment(Pos.CENTER);
        Label labelBelanja = new Label("Pengeluaran");
        labelBelanja.setTextFill(Color.DIMGREY);
        labelBelanja.setFont(new Font("Arial", 18));
//        belanjaBox.setMaxSize(400, 400);

        tableBelanja = new TableView();
        colNama = new TableColumn("Nama Transaksi");
        colNama.setPrefWidth(250.0);
        colJumlah = new TableColumn("Jumlah");
        colJumlah.setPrefWidth(150.0);
        tableBelanja.getColumns().addAll(colNama,colJumlah);
        belanjaBox.getChildren().addAll(labelBelanja,tableBelanja);
        return belanjaBox;
    }
}
