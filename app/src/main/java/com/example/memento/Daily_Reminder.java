package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Daily_Reminder extends AppCompatActivity implements View.OnClickListener {

    Button back;
    String daily_reminder;
    int amount_of_daily_reminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily__reminder);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);













    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back:
                Intent intent3 = new Intent(Daily_Reminder.this,MainActivity.class);
                startActivity(intent3);
                break;

            default:
                break;

        }
    }
}
