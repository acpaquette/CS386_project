package com.example.chandler.hack;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by adampaquette on 4/15/17.
 */

public class SignUpDialog extends DialogFragment {

    private EditText username;
    private EditText pass;
    private EditText passConfirm;
    private Button b1;
    private Button b2;
    private User user = User.getInstance();

    static SignUpDialog newInstance() {
        return new SignUpDialog();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sign_up, container, false);
        b1 = (Button) v.findViewById(R.id.Confirm);
        b2 = (Button) v.findViewById(R.id.Cancel);

        username = (EditText) v.findViewById(R.id.usernameText);
        pass = (EditText) v.findViewById(R.id.passText);
        passConfirm = (EditText) v.findViewById(R.id.passTextConfirm);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().equals(passConfirm.getText().toString())) {
                    createDrinkFile(username.getText().toString(), pass.getText().toString());
                    dismiss();
                }
                else {
                    Toast.makeText(v.getContext(),
                            "Password does not match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return v;
    }

    public void createDrinkFile(String username, String password) {
        try {
            FileWriter file = new FileWriter(user.getAndroidFileDir() + "/" + username + password + "DrinkList.json");
            file.flush();
            file.close();

        } catch (IOException e) {
            Log.e("IOException SignUp", e.getMessage());
        }
    }
}