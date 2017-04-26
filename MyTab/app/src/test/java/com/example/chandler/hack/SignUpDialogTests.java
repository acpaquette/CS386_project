package com.example.chandler.hack;

import android.app.Activity;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Connor F. Schwirian on 4/20/2017.
 */

public class SignUpDialogTests {

    @Test
    public void testFileCreation() {
        Activity newActivity = mock(LoginActivity.class);
        SignUpDialog dialog = SignUpDialog.newInstance();
        dialog.createDrinkFile("username", "password");
        boolean passed = true;
        // I'm going to upload something using someting that test UI that I think will also work for this
        try {
            File drinkFile = new File("/data/user/0/com.example.chandler/files/usernamepasswordDrinkList.json");
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            passed = false;
        }
        assertTrue(passed);
    }
}
