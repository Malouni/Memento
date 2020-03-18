package com.example.memento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Daily_Reminder extends AppCompatActivity implements View.OnClickListener {

    Button back,back2,save_button;
    TextView title,description;
    int amount_of_daily_reminders;
    ListView lv;
    int amount;
    String first_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily__reminder);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);


        title = (TextView) findViewById(R.id.Title);
        description = (TextView) findViewById(R.id.Description);


        save_button = (Button) findViewById(R.id.save_button);
        back.setOnClickListener(this);

        back2 = (Button) findViewById(R.id.back2);
        back.setOnClickListener(this);

        final SharedPreferences pref = getApplicationContext().getSharedPreferences("Daily", 0);

        amount = pref.getInt("Amount", -1);

        String[] list_daily;

        if(amount==-1){
          list_daily = new String[1];
          list_daily[0]="The list is empty";
        }else{
          list_daily = new String[amount];

          for(int i=0;i<amount;i++){

              String event = pref.getString(String.valueOf(i),"");

              for(int j=0;j<event.length();j++){

                  if(event.charAt(j)==';'){
                      first_string=event.substring(0,j);
                  }

              }

              list_daily[i]=first_string;
          }


        }


        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_daily);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if(amount==-1){

                }else{
                    lv.setVisibility(View.INVISIBLE);
                    back.setVisibility(View.INVISIBLE);
                    title.setVisibility(View.VISIBLE);
                    description.setVisibility(View.VISIBLE);
                    save_button.setVisibility(View.VISIBLE);
                    back2.setVisibility(View.VISIBLE);
                    String daily_description = pref.getString(String.valueOf(position),"");

                    for(int i=0;i<daily_description.length();i++){

                        if(daily_description.charAt(i)==';'){
                            title.setText(String.valueOf(daily_description.substring(0,i)));
                            description.setText(String.valueOf(daily_description.substring(i,daily_description.length())));
                        }
                    }

                }
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back:
                Intent intent3 = new Intent(Daily_Reminder.this,MainActivity.class);
                startActivity(intent3);
                break;

            case R.id.back2:
                lv.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                title.setVisibility(View.INVISIBLE);
                description.setVisibility(View.INVISIBLE);
                save_button.setVisibility(View.INVISIBLE);
                back2.setVisibility(View.INVISIBLE);
                break;
            case R.id.save_button:

                /*
                lv.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                title.setVisibility(View.INVISIBLE);
                description.setVisibility(View.INVISIBLE);
                save_button.setVisibility(View.INVISIBLE);
                save.setVisibility(View.INVISIBLE);
                */

                break;

            default:
                break;

        }
    }
}
