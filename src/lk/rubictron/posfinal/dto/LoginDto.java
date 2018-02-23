/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dto;

/**
 *
 * @author rubictron
 */
public class LoginDto extends SuperDto{

    private String userName;
    private String password;
    private int accessLevel;

    public LoginDto(String userName, String password, int accessLevel) {
        this.userName = userName;
        this.password = password;
        this.accessLevel = accessLevel;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the accessLevel
     */
    public int getAccessLevel() {
        return accessLevel;
    }

    /**
     * @param accessLevel the accessLevel to set
     */
    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

}
