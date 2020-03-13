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
                Intent intent1 = new Intent(MainActivity.this,create_StudyorWork.class);
                startActivity(intent1);
                break;

            case R.id.all_reminders:
                Intent intent2 = new Intent(MainActivity.this,create_StudyorWork.class);
                startActivity(intent2);
                break;

            case R.id.daily_reminders:
                Intent intent3 = new Intent(MainActivity.this,Create_Daily.class);
                startActivity(intent3);
                break;

            default:
                break;

        }
    }



}
