package com.example.blogapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {

    DatabaseHandler MyDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView = findViewById(R.id.listview);
        MyDB = new DatabaseHandler(this);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = MyDB.getListContents();
        if (data.getCount()==0){
            Toast.makeText(this, "There are no blogs.", Toast.LENGTH_SHORT).show();
        }
        else{
            while (data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
            }
        }
    }


    public void post(View view) {
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }
}