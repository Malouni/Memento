package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Daily_Reminder extends AppCompatActivity implements View.OnClickListener {

    Button back;
    String daily_reminder;
    int amount_of_daily_reminders;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily__reminder);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);

        Storage daily = new Storage();

        amount_of_daily_reminders = daily.get_amount_of_daily_reminders();


        String [] list_daily = new String [amount_of_daily_reminders ];

        for(int i=0;i<list_daily.length;i++){
            list_daily[i]=daily.get_daily_reminder(i);
        }


        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_daily);
        lv.setAdapter(adapter);


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
