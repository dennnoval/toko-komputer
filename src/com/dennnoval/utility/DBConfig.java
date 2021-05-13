package com.dennnoval.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dennnoval
 */
public class DBConfig {
  private static final String DB_NAME = "Toko_Komputer";
  private static final String URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
  private static final String USER = "root";
  private static final String PASS = "root123";
  
  public static Connection connect() {
    try {
      return DriverManager.getConnection(URL, USER, PASS);
    } catch (SQLException ex) {
      Logger.getLogger(DBConfig.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
}
