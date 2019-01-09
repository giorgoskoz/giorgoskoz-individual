/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author giorgoskoz
 */
public class User {
    
    private int id;
    private String username;
    private String password;
    private RoleEnum role;
    private BannedEnum banStatus;

    public User() {
    }

    public User(int id, String username, String password, RoleEnum role, BannedEnum banStatus) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.banStatus = banStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public BannedEnum getBanStatus() {
        return banStatus;
    }

    public void setBanStatus(BannedEnum banStatus) {
        this.banStatus = banStatus;
    }
    
    
    
}
