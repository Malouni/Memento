package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Create_Event extends AppCompatActivity implements View.OnClickListener {

    Button back,ChooseLocation,ChooseDate,ChooseTime,Save;
    String event;
    EditText name;
    EditText Description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__event);

        name = (EditText) findViewById(R.id.Name);
        Description = (EditText) findViewById(R.id.Description);
        Save = (Button) findViewById(R.id.save);
        Save.setOnClickListener(this);
        ChooseLocation = (Button) findViewById(R.id.ChooseLocation);
        ChooseLocation.setOnClickListener(this);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        ChooseTime = (Button) findViewById(R.id.ChooseTime);
        ChooseTime.setOnClickListener(this);
        ChooseDate = (Button) findViewById(R.id.chooseDate);
        ChooseDate.setOnClickListener(this);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Saver",0);
        SharedPreferences.Editor saver = pref.edit();

    }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.save:
                Storage event_rem = new Storage();
                event= String.valueOf(name.getText())+";"+String.valueOf(Description.getText());
                event_rem.Store_Event(event);

                break;


            case R.id.ChooseTime:


                break;

            case R.id.ChooseLocation:


                break;

            case R.id.chooseDate:


                break;

            case R.id.back:
                Intent intent3 = new Intent(Create_Event.this,Create_reminder.class);
                startActivity(intent3);
                break;

            default:
                break;

        }
    }
}
