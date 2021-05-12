package com.dennnoval.ui.tablemodel;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dennnoval
 */

public class AdminTableModel {
  public static DefaultTableModel tableBarang() {
    DefaultTableModel dtm = new DefaultTableModel();
    dtm.setColumnIdentifiers(new Object[]{
      "Kode Barang", "Nama Barang", "Harga Barang", "Stok"
    });
    return dtm;
  }
}
