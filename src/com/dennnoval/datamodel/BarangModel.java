package com.dennnoval.datamodel;

import com.dennnoval.entity.Barang;
import com.dennnoval.utility.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dennnoval
 */
public class BarangModel implements CRUD<Barang> {
  private final Connection c = DBConfig.connect();
  private final String TABLE_NAME = "Barang";
  private PreparedStatement ps;
  
  @Override
  public List<Barang> read() {
    List<Barang> b = new ArrayList<>();
    try {
      ps = c.prepareStatement("SELECT * FROM "+TABLE_NAME);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        String kode = rs.getString("kode");
        String nama = rs.getString("nama");
        int harga = rs.getInt("harga");
        int stok = rs.getInt("stok");
        b.add(new Barang(kode, nama, harga, stok));
      }
    } catch (SQLException ex) {}
    return b;
  }

  @Override
  public Barang readById(Barang brg) {
    try {
      ps = c.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE kode=?");
      ps.setString(1, brg.getKode());
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        String kode = rs.getString("kode");
        String nama = rs.getString("nama");
        int harga = rs.getInt("harga");
        int stok = rs.getInt("stok");
        return new Barang(kode, nama, harga, stok);
      }
    } catch (SQLException ex) {}
    return null;
  }

  @Override
  public boolean create(Barang brg) {
    try {
      ps = c.prepareStatement("INSERT INTO "+TABLE_NAME+" VALUES (?, ?, ?, ?)");
      ps.setString(1, brg.getKode());
      ps.setString(2, brg.getNama());
      ps.setInt(3, brg.getHarga());
      ps.setInt(4, brg.getStok());
      return ps.executeUpdate() == 1;
    } catch (SQLException ex) {}
    return false;
  }

  @Override
  public boolean update(Barang brg) {
    try {
      ps = c.prepareStatement("UPDATE "+TABLE_NAME+" SET nama=?, harga=?, stok=? WHERE kode=?");
      ps.setString(1, brg.getNama());
      ps.setInt(2, brg.getHarga());
      ps.setInt(3, brg.getStok());
      ps.setString(4, brg.getKode());
      return ps.executeUpdate() == 1;
    } catch (SQLException ex) {}
    return false;
  }

  @Override
  public boolean delete(Barang brg) {
    try {
      ps = c.prepareStatement("DELETE FROM "+TABLE_NAME+" WHERE kode=?");
      ps.setString(1, brg.getKode());
      return ps.executeUpdate() == 1;
    } catch (SQLException ex) {}
    return false;
  }
  
}
