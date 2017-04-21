package com.example.chandler.hack;

import android.app.Activity;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Connor F. Schwirian on 4/20/2017.
 */

public class SignUpDialogTests {

    @Test
    public void initTests() {

    }

    @Test
    public void testFileCreation() {
        Activity activity = new LoginActivity();
        SignUpDialog dialog = SignUpDialog.newInstance();
        dialog.createDrinkFile("username", "password");
        boolean passed = true;
        try {
            File drinkFile = new File(activity.getFilesDir() + "usernamepasswordDrinkList.json");
        }
        catch (NullPointerException e) {
            passed = false;
        }
        assertTrue(passed);
    }
}
