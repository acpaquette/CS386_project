package com.example.chandler.hack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AddDrinkActivity extends AppCompatActivity {

    private EditText name;
    private EditText description;
    private RatingBar rating;
    private Drink drink;
    private User user = User.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_drink);

        name = (EditText) findViewById(R.id.drinkName);
        description = (EditText) findViewById(R.id.drinkDescription);
        rating = (RatingBar) findViewById(R.id.drinkRating);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drink = new Drink();
                drink.setName(name.getText().toString());
                drink.setRating(rating.getRating());
                drink.setDescription(description.getText().toString());
                writeDrink();
                Toast.makeText(getBaseContext(),
                        "Adding Drink to List", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddDrinkActivity.this, ListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void writeDrink(){
        try{
            File userFile = new File(user.getAndroidFileDir() + "/", user.getUsername() + user.getPassword() + "DrinkList.json");
            JSONObject obj = new JSONObject();
            try {
                obj.put("Type", drink.getClass().getCanonicalName().substring(26));
                obj.put("Name", drink.getName());
                obj.put("Description", drink.getDescription());
                obj.put("Rating", drink.getRating());
            }
            catch (JSONException e) {
                Log.e("JSON Failure", e.getMessage());
            }
            BufferedReader br = new BufferedReader(new FileReader(userFile));
            FileWriter fw = new FileWriter(userFile, true);
            if (br.readLine() == null) {
                fw.write(obj.toString() + "\n");
            }
            else {
                fw.write(obj.toString() + "\n");
            }
            fw.flush();
            fw.close();
        }
        catch(IOException e) {
            Log.e("IOException in Write", e.getMessage());
        }
    }

}
