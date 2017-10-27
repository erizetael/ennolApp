package com.rizal.cafe;


import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Cafe {


    private TableColumn colId, colNama, colMasuk, colKeluar, colHarga, colSisa;
    private VBox tableBox;
    TextField txtNama = new TextField();
    TextField txtAsal = new TextField();




    public VBox showTableCafe() {
        tableBox = new VBox();
        TableView tabel = new TableView();


        txtNama.setPromptText("Nama");
        txtAsal.setPromptText("Asal");
        Button buttonInsert = new Button("Insert");
//        buttonInsert.setOnAction(event -> inputCafe());

        HBox hBox = new HBox(10, txtNama, txtAsal, buttonInsert);
        hBox.setPadding(new Insets(5,5,5,0));
        tableBox.getChildren().addAll(tabel, hBox);
        return tableBox;
    }


}
