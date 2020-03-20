package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class       Create_Daily extends AppCompatActivity implements View.OnClickListener {

    Button back,ChooseLocation,Save;
    String daily_event;
    EditText name;
    EditText Description;
    int amount;

    Spinner spiner_hours,spinner_minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__daily);

        name = (EditText) findViewById(R.id.Name);
        Description = (EditText) findViewById(R.id.Description);

        Save = (Button) findViewById(R.id.save);
        Save.setOnClickListener(this);
        ChooseLocation = (Button) findViewById(R.id.ChooseLocation);
        ChooseLocation.setOnClickListener(this);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);

        spiner_hours = (Spinner) findViewById(R.id.spinner_hours);
        ArrayAdapter<String> hours = new ArrayAdapter<String>(Create_Daily.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.hours));
        hours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_hours.setAdapter(hours);

        spinner_minutes = (Spinner) findViewById(R.id.spinner_minutes);
        ArrayAdapter<String> minutes = new ArrayAdapter<String>(Create_Daily.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.minutes));
        hours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_minutes.setAdapter(minutes);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Daily", 0);

        amount = pref.getInt("Amount", -1);

        if (amount == -1) {
            amount = 0;
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.save:

                SharedPreferences pref = getApplicationContext().getSharedPreferences("Daily", 0);
                SharedPreferences.Editor saver = pref.edit();

                saver.putString(String.valueOf(amount),String.valueOf(name.getText())+";"+String.valueOf(Description.getText())+"#"+spiner_hours.getSelectedItem()+":"+spinner_minutes.getSelectedItem());
                amount=amount+1;
                saver.putInt("Amount",amount);
                saver.commit();


                Intent intent = new Intent(Create_Daily.this,MainActivity.class);
                startActivity(intent);



                break;


            case R.id.Remind_when:


                break;

            case R.id.ChooseLocation:


                break;

            case R.id.back:
                Intent intent3 = new Intent(Create_Daily.this,Create_reminder.class);
                startActivity(intent3);
                break;

            default:
                break;

        }
    }
}
