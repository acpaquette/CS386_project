package com.example.chandler.hack;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewDrinkActivity extends AppCompatActivity {

    private TextView name;
    private TextView description;
    private RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_drink);

        name = (TextView) findViewById(R.id.drinkName);
        description = (TextView) findViewById(R.id.drinkDescription);
        rating = (RatingBar) findViewById(R.id.drinkRating);

        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString("name"));
        description.setText(bundle.getString("description"));
        rating.setRating(bundle.getFloat("rating"));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
