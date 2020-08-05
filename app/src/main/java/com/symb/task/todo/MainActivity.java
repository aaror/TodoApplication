package com.symb.task.todo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

Button Button1, Button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar1);
        Button1=(Button) findViewById(R.id.button1);
        Button2=(Button) findViewById(R.id.button2);


        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
          Create_todo();
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo_List();
            }
        });

    }



    public void Create_todo(){
        Intent i=new Intent(MainActivity.this, Create_Todo.class);
        startActivity(i);

    }
    public void Todo_List(){
        Intent intent= new Intent(MainActivity.this, TodoList.class);
        startActivity(intent);
    }


}
