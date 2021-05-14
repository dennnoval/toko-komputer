package com.dennnoval.entity;

import java.io.Serializable;

/**
 *
 * @author dennnoval
 */
public class Barang implements Serializable {
  private final String kode;
  private final String nama;
  private final int harga;
  private final int stok;

  public Barang(String kode, String nama, int harga, int stok) {
    this.kode = kode;
    this.nama = nama;
    this.harga = harga;
    this.stok = stok;
  }

  public String getKode() {
    return kode;
  }

  public String getNama() {
    return nama;
  }

  public int getHarga() {
    return harga;
  }
  
  public int getStok() {
    return stok;
  }
}
