package com.dennnoval.entity;

import java.io.Serializable;

/**
 *
 * @author dennnoval
 */
public class User implements Serializable {
  private final String username;
  private final String password;
  private String type;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type;
  }
}
