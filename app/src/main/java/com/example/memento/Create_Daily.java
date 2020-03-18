package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Create_Daily extends AppCompatActivity implements View.OnClickListener {

    Button back,ChooseLocation,ChooseTime,Save;
    String daily_event;
    EditText name;
    EditText Description;
    int amount=0;

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
        ChooseTime = (Button) findViewById(R.id.ss);
        ChooseTime.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.save:

                SharedPreferences pref = getApplicationContext().getSharedPreferences("Daily",0);
                SharedPreferences.Editor saver = pref.edit();

                if(amount = saver.getInt("Amount",-1)){
                    amount=0;
                }else{
                    amount = saver.getInt("Amount",-1);
                }

                saver.putString(String.valueOf(amount),String.valueOf(name.getText())+";"+String.valueOf(Description.getText()));
                amount=amount+1;
                saver.putInt("Amount",amount);


                Intent intent = new Intent(Create_Daily.this,MainActivity.class);
                startActivity(intent);



                break;


            case R.id.ss:


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
