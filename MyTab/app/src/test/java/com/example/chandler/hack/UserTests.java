package com.example.chandler.hack;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by Connor F. Schwirian on 4/20/2017.
 */

public class UserTests {

    private User user;

    @Before
    public void initTests() {
        user = User.getInstance();
    }

    @Test
    public void testUserID() {
        user.setUserId(7);
        assertEquals(user.getUserId(), 7);
    }

    @Test
    public void testUserUsername() {
        user.setUsername("user");
        assertEquals(user.getUsername(), "user");
    }

    @Test
    public void testUserPassword() {
        user.setPassword("password");
        assertEquals(user.getPassword(), "password");
    }

    @Test
    public void testUserAndroidDirectory() {
        user.setAndroidFileDir("/data/user/0/com.example.chandler/files/");
        assertEquals(user.getAndroidFileDir(), "/data/user/0/com.example.chandler/files/");
    }

    @Test
    public void testUserDirectory() {
        user.setUsername("user");
        user.setPassword("password");
        user.setAndroidFileDir("/data/user/0/com.example.chandler/files/");
        assertEquals(user.getFileDir(), "/data/user/0/com.example.chandler/files/userpasswordDrinkList.json");
    }
}
