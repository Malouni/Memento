package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Create_Daily extends AppCompatActivity implements View.OnClickListener {

    Button back,ChooseDate,ChooseLocation,ChooseTime,Save;
    String daily_event;
    EditText name = (EditText) findViewById(R.id.Name);
    EditText Description = (EditText) findViewById(R.id.Description);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__daily);

        Save = (Button) findViewById(R.id.save);
        Save.setOnClickListener(this);
        ChooseDate = (Button) findViewById(R.id.chooseDate);
        ChooseDate.setOnClickListener(this);
        ChooseLocation = (Button) findViewById(R.id.ChooseLocation);
        ChooseLocation.setOnClickListener(this);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        ChooseTime = (Button) findViewById(R.id.ChooseTime);
        ChooseTime.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.save:
                Storage daily = new Storage();
                daily_event= String.valueOf(name.getText())+";"+String.valueOf(Description.getText());
                daily.Store_Daily(daily_event);

                break;

            case R.id.chooseDate:


                break;

            case R.id.ChooseTime:


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
