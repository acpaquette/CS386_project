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

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by adampaquette on 4/15/17.
 */

public class signUpDialog extends DialogFragment {

    EditText username, pass, passConfirm;
    Button b1, b2;
    String fileDir;

    static signUpDialog newInstance() {
        return new signUpDialog();
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

        fileDir = getArguments().getString("fileDir");
        Log.i("fileDir", fileDir);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().equals(passConfirm.getText().toString())) {
                    ((LoginActivity)getActivity()).setUser(
                            new User(username.getText().toString(), pass.getText().toString()));
                    createDrinkFile(username.getText().toString(), pass.getText().toString());
                    dismiss();
                }
                else {
                    dismiss();
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
        JSONObject obj = new JSONObject();

        JSONArray list = new JSONArray();
        try {
            obj.put("Wine", list);
            obj.put("Beer", list);
            obj.put("Mixed", list);
        }
        catch (org.json.JSONException e) {
            Log.d("JSON ERROR", e.getMessage());
        }

        try {
            FileWriter file = new FileWriter(fileDir + username + password + "DrinkList.json");

            file.write(obj.toString());
            file.flush();

        } catch (IOException e) {
            Log.i("IOException", e.getMessage());
        }
        Log.d("Drink JSON", obj.toString());
    }
}