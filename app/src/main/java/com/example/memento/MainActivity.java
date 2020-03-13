package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button create_reminder,daily_reminders,all_reminders,study_work;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_reminder = (Button) findViewById(R.id.create_reminder);
        create_reminder.setOnClickListener(this);
        study_work = (Button) findViewById(R.id.create_reminder);
        study_work.setOnClickListener(this);
        all_reminders = (Button) findViewById(R.id.create_reminder);
        all_reminders.setOnClickListener(this);
        daily_reminders = (Button) findViewById(R.id.create_reminder);
        daily_reminders.setOnClickListener(this);
    }


    public void onClick(View v){
        switch (v.getId()) {

            case R.id.create_reminder:
                Intent intent = new Intent(MainActivity.this,Create_reminder.class);
                startActivity(intent);
                break;

            case R.id.study_work:

                break;

            case R.id.all_reminders:

                break;

            case R.id.daily_reminders:

                break;

            default:
                break;

        }
    }



}
