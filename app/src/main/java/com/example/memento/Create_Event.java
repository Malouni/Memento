package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Create_Event extends AppCompatActivity implements View.OnClickListener {

    Button back,ChooseLocation,ChooseDate,ChooseTime,Save,save_date;

    EditText name;
    EditText Description;
    TextView remind_when;
    int amount;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__event);

        linearLayout = (LinearLayout) findViewById(R.id.LinearLayout);
        remind_when = (TextView) findViewById(R.id.Remind_when);
        save_date = (Button) findViewById(R.id.Button_Save_Date);
        save_date.setOnClickListener(this);
        save_date.setVisibility(View.INVISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);




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








        SharedPreferences pref = getApplicationContext().getSharedPreferences("Event", 0);

        amount = pref.getInt("Amount", -1);

        if (amount == -1) {
            amount = 0;
        }

    }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.save:

                SharedPreferences pref = getApplicationContext().getSharedPreferences("Event", 0);
                SharedPreferences.Editor saver = pref.edit();

                saver.putString(String.valueOf(amount),String.valueOf(name.getText())+";"+String.valueOf(Description.getText()));
                amount=amount+1;
                saver.putInt("Amount",amount);
                saver.commit();


                Intent intent = new Intent(Create_Event.this,MainActivity.class);
                startActivity(intent);

                break;


            case R.id.ChooseTime:


                break;

            case R.id.ChooseLocation:

                break;


            case R.id.Button_Save_Date:
                Save.setVisibility(View.VISIBLE);
                remind_when.setVisibility(View.VISIBLE);
                Description.setVisibility(View.VISIBLE);
                ChooseLocation.setVisibility(View.VISIBLE);
                ChooseTime.setVisibility(View.VISIBLE);
                ChooseDate.setVisibility(View.VISIBLE);
                name.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                save_date.setVisibility(View.INVISIBLE);
                linearLayout.setVisibility(View.INVISIBLE);

                break;

            case R.id.chooseDate:
                Save.setVisibility(View.INVISIBLE);
                remind_when.setVisibility(View.INVISIBLE);
                Description.setVisibility(View.INVISIBLE);
                ChooseLocation.setVisibility(View.INVISIBLE);
                ChooseTime.setVisibility(View.INVISIBLE);
                ChooseDate.setVisibility(View.INVISIBLE);
                name.setVisibility(View.INVISIBLE);
                back.setVisibility(View.INVISIBLE);
                save_date.setVisibility(View.VISIBLE);
                linearLayout.setVisibility(View.VISIBLE);




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
