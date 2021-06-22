package com.example.blogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity3 extends AppCompatActivity {

    public static final String WHOLE_BLOG = "com.example.blogapp.extra.whole_blog";
    DatabaseHandler MyDB;
    SQLiteDatabase sqlitedb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = getIntent();

    }

    public void POST(View view) {
        EditText name = findViewById(R.id.editTextTextPersonName);
        EditText blog = findViewById(R.id.editTextTextMultiLine);
        MainActivity2 mainActivity2 = new MainActivity2();
        String personName = name.getText().toString();
        String blogPost = blog.getText().toString();
        String MyBlog = personName+" \n"+blogPost;

        MyDB = new DatabaseHandler(this);
        addData(MyBlog);
        Intent intent = new Intent(this,MainActivity2.class);

        startActivity(intent);
    }

    private boolean DeleteData(String x) {
        return sqlitedb.delete(DatabaseHandler.TABLE_NAME,DatabaseHandler.COL2+ "=?", new String[]{x})>0;
    }

    private void addData(String newEntry) {
        boolean insertData = MyDB.addData(newEntry);
        if(insertData==true)
        {
            Toast.makeText(MainActivity3.this,"Data added",Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(MainActivity3.this,"Unsuccesful",Toast.LENGTH_SHORT).show();
        }
    }


}