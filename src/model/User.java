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

    public User(int id, String username, String password, int roleId, int banStatusId) {
        this.id = id;
        this.username = username;
        this.password = password;
        switch(roleId){
            case 1:
                role = RoleEnum.RESTRICTED_USER;
                break;
            case 2:
                role = RoleEnum.REGULAR_USER;
                break;
            case 3:
                role = RoleEnum.VIEWER;
                break;
            case 4:
                role = RoleEnum.EDITOR;
                break;
            case 5:
                role = RoleEnum.DELETER;
                break;
            case 6:
                role = RoleEnum.ADMIN;
                break;
            case 7:
                role = RoleEnum.EDITOR;
                break;
        }
        switch(banStatusId){
            case 0:
                banStatus = BannedEnum.NOT_BANNED;
                break;
            case 1:
                banStatus = BannedEnum.NOT_BANNED;
                break;
        }
    }
    
    @Override
    public String toString() {
        return "id: " + id + "  |  username: " + username + "  |  password: " + password + "  | role: " + role + "  | banned: " + banStatus + "\n";
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
