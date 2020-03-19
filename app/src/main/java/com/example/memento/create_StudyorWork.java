package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class create_StudyorWork extends AppCompatActivity implements View.OnClickListener {

    Button back,ChooseLocation,ChooseDate,ChooseTime,Save;
    String study_work;
    EditText name;
    EditText Description;
    int amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__studyor_work);

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

        SharedPreferences pref = getApplicationContext().getSharedPreferences("Study_work", 0);

        amount = pref.getInt("Amount", -1);

        if (amount == -1) {
            amount = 0;
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.save:

                SharedPreferences pref = getApplicationContext().getSharedPreferences("Study_work", 0);
                SharedPreferences.Editor saver = pref.edit();

                saver.putString(String.valueOf(amount),String.valueOf(name.getText())+";"+String.valueOf(Description.getText()));
                amount=amount+1;
                saver.putInt("Amount",amount);
                saver.commit();


                Intent intent = new Intent(create_StudyorWork.this,MainActivity.class);
                startActivity(intent);

                break;


            case R.id.ChooseTime:


                break;

            case R.id.ChooseLocation:


                break;

            case R.id.chooseDate:


                break;

            case R.id.back:
                Intent intent3 = new Intent(create_StudyorWork.this,Create_reminder.class);
                startActivity(intent3);
                break;

            default:
                break;

        }
    }


}
