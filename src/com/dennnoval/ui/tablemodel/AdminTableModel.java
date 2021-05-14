package com.dennnoval.ui.tablemodel;

import com.dennnoval.datamodel.BarangModel;
import com.dennnoval.entity.Barang;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dennnoval
 */

public class AdminTableModel {
  public static class TableBarang extends DefaultTableModel {
    public TableBarang() {
      super.setColumnIdentifiers(new Object[]{
        "Kode Barang", "Nama Barang", "Harga Barang", "Stok"
      });
      List<Barang> b = new BarangModel().read();
      b.forEach(d -> {
        addRow(new Object[]{
          d.getKode(), d.getNama(), d.getHarga(), d.getStok()
        });
      });
    }

    @Override
    public boolean isCellEditable(int row, int column) {
      return false;
    } 
  }
}
