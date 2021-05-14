package com.dennnoval.entity;

import java.io.Serializable;

/**
 *
 * @author dennnoval
 */
public class User implements Serializable {
  private final String username;
  private final String password;
  private final String type;

  public User(String username, String password, String type) {
    this.username = username;
    this.password = password;
    this.type = type;
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
}
