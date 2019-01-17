/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giorgoskozindividualv2.model;

import giorgoskozindividualv2.MessengerException;

/**
 *
 * @author giorgoskoz
 */
public class User {
    
    private int userId;
    private String username;
    private String password;
    private RoleEnum role;
    private BannedEnum banStatus;

    public User() {
    }

    public User(int userId, String username, String password, RoleEnum role, BannedEnum banStatus) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.banStatus = banStatus;
    }

    public User(int id, String username, String password, int roleId, int banStatusId) throws MessengerException {
        this.userId = id;
        this.username = username;
        this.password = password;
        setRoleById(roleId);
        setBanStatusByBanStatusId(banStatusId);
    }
    
    @Override
    public String toString() {
        return "id: " + userId + "  |  username: " + username + "  |  password: " + password + "  | role: " + role + "  | banned: " + banStatus + "\n";
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
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

    public void setRoleById(int roleId) throws MessengerException {
        this.role = getRoleEnumByRoleEnumId(roleId);
    }

    public BannedEnum getBanStatus() {
        return banStatus;
    }

    public void setBanStatusByBanStatusId(int banStatusId) throws MessengerException {
            this.banStatus = getBannedEnumByBannedEnumId(banStatusId);
    }
    
    public BannedEnum getBannedEnumByBannedEnumId(int banStatusId) throws MessengerException {
        switch(banStatusId){
            case 0:
                return BannedEnum.NOT_BANNED;
            case 1:
                return BannedEnum.BANNED;
            default:
                throw new MessengerException("No such ban status id");
        }
    }
        
    public RoleEnum getRoleEnumByRoleEnumId(int roleId) throws MessengerException {
        switch(roleId){
            case 1:
                return RoleEnum.RESTRICTED_USER;
            case 2:
                return RoleEnum.REGULAR_USER;
            case 3:
                return RoleEnum.VIEWER;
            case 4:
                return RoleEnum.EDITOR;
            case 5:
                return RoleEnum.DELETER;
            case 6:
                return RoleEnum.SUPER_ADMIN;
            default:
                throw new MessengerException("No such role id");
        }    
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }
        
}
