package com.example.chandler.hack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private User user = User.getInstance();


    //automatically created when a project is made & it creates this file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getIntent().getExtras();

        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<>();

        //this will extract the users data
        readItems();

        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);

        //the method sets up a listener to remove an item
        setupListViewListener();
    }

    //This adds an item to the list and will be displayed in the list view
    public void onAddItem(View v) {
        Intent intent = new Intent(ListActivity.this, AddDrinkActivity.class);
        startActivity(intent);
        finish();
    }

    // Attaches a long click listener to the ListView
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        writeItems(); //updates the new data to the file
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }

    //this writes data to a file
    private void readItems(){
        File userFile = new File(user.getAndroidFileDir() + "/", user.getUsername() + user.getPassword() + "DrinkList.json");
        try{
            items = new ArrayList<>(FileUtils.readLines(userFile));
        }
        catch(IOException e) {
            items = new ArrayList<>();
            Log.e("Read Fail", e.getMessage());
        }
    }


    //this writes data to a file
    private void writeItems() {
        File userFile = new File(user.getAndroidFileDir() + "/", user.getUsername() + user.getPassword() + "DrinkList.json");
        try{
            FileUtils.writeLines(userFile, items);
        }
        catch(IOException e) {
            Log.e("IOException in Write", e.getMessage());
        }
    }

}
