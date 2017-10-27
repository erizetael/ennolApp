package com.rizal.collection;

import org.bson.types.ObjectId;

public class Barang {
    private ObjectId id;
    private String nama;
    private Double harga;
    private Integer qty;

    public Barang() {
    }

    public Barang(final String nama, final Double harga, final Integer qty) {
//        this.id = new ObjectId();
        this.nama = nama;
        this.harga = harga;
        this.qty = qty;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(final ObjectId id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(final String nama) {
        this.nama = nama;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(final Double harga) {
        this.harga = harga;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id +
                ", nama='" + nama + '\'' +
                ", harga=" + harga +
                ", qty=" + qty +
                '}';
    }
}
