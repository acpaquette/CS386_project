package com.example.chandler.hack;

/**
 * Created by adampaquette on 4/12/17.
 */

public class User {

    private int userId;
    private String username;
    private String password;
    private String fileDir;
    private String androidFileDir;
    private static final User instance = new User();

    private User(){
    }

    public static User getInstance() {
        return instance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        setFileDir();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        setFileDir();
    }

    public String getAndroidFileDir() {
        return androidFileDir;
    }

    public void setAndroidFileDir(String androidFileDir) {
        this.androidFileDir = androidFileDir;
        setFileDir();
    }

    public String getFileDir() {
        return this.fileDir;
    }

    private void setFileDir() {
        this.fileDir = this.androidFileDir + this.username + this.password + "DrinkList.json";
    }
}
