package com.symb.task.todo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Calendar;

public class Create_Todo extends AppCompatActivity {
    Toolbar toolbar2;
    EditText editText;
    TodoListDb mDatabaseHelper;
    Button save;
    Calendar c;
    String todaysDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__todo);
        editText = (EditText) findViewById(R.id.editText2);
        save = (Button) findViewById(R.id.save_button);
        mDatabaseHelper = new TodoListDb(this);

        toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setTitle("New Note");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //get current date and time
        c = Calendar.getInstance();
        todaysDate = c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DAY_OF_MONTH);
        Log.d("Calendar", "Date: " + todaysDate);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Todo_task task = new Todo_task(editText.getText().toString(), todaysDate);

              String newEntry=editText.getText().toString();
              if(editText.length()!=0){
                  long result=  mDatabaseHelper.AddTodo(task);
                  if(result!=-1){
                      toastMessage("Data is inserted!");
                      onBackPressed();
                  }else{
                      toastMessage("Something went wrong");
                  }
                  editText.setText("");
              }else{
                  toastMessage("You must put something in the text field!");
              }



            }

        });





    }



    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

