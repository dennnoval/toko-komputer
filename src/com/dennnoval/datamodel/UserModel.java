package com.dennnoval.datamodel;

import com.dennnoval.entity.User;
import com.dennnoval.utility.DBConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dennnoval
 */
public class UserModel {
  private final Connection c = DBConfig.connect();
  private PreparedStatement ps;
  private final String TABLE_NAME = "User";
  private User usr;
  
  public boolean validateLogin(User usr) {
    try {
      ps = c.prepareStatement("SELECT * FROM "+TABLE_NAME+" WHERE BINARY username=? AND BINARY password=?");
      ps.setString(1, usr.getUsername());
      ps.setString(2, usr.getPassword());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        this.usr = new User(rs.getString("username"), rs.getString("username"));
        this.usr.setType(rs.getString("type"));
        return true;
      }
    } catch (SQLException ex) {
      Logger.getLogger(UserModel.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }
  
  public User getUser() {
    return usr;
  }
}
