package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Create_reminder extends AppCompatActivity implements View.OnClickListener {

    Button daily,study_work,event,back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);

        daily = (Button) findViewById(R.id.daily);
        daily.setOnClickListener(this);
        study_work = (Button) findViewById(R.id.study_work);
        study_work.setOnClickListener(this);
        event = (Button) findViewById(R.id.Event);
        event.setOnClickListener(this);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);



    }


    public void onClick(View v){
        switch (v.getId()) {

            case R.id.daily:
                Intent intent = new Intent(Create_reminder.this,Create_Daily.class);
                startActivity(intent);
                break;

            case R.id.study_work:
                Intent intent1 = new Intent(Create_reminder.this,create_StudyorWork.class);
                startActivity(intent1);
                break;

            case R.id.Event:
                Intent intent2 = new Intent(Create_reminder.this,Create_Event.class);
                startActivity(intent2);
                break;

            case R.id.back:
                Intent intent3 = new Intent(Create_reminder.this,MainActivity.class);
                startActivity(intent3);
                break;

            default:
                break;

        }
    }



}
