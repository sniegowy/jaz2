package model;

import javax.management.relation.Role;

public class User {

    private String username;
    private String password;
    private String email;
    private RoleEnum role = RoleEnum.USER;
    private boolean isPremiumUser = false;

    /*public boolean isPremiumUser() {
        return premiumUser;
    }

    public void setPremiumUser(boolean premiumUser) {
        this.premiumUser = premiumUser;
    }*/

    public boolean isPremiumUser() {
        if (role.equals(RoleEnum.ADMIN) || role.equals(RoleEnum.PREMIUM)) {
            isPremiumUser = true;
        } else {
            isPremiumUser = false;
        }
        return isPremiumUser;
    }

    public void setPremiumUser(boolean premiumUser) {
        isPremiumUser = premiumUser;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
