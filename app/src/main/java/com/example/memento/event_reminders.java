package com.example.memento;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class event_reminders extends AppCompatActivity implements View.OnClickListener {

    Button back,back2,save_button;
    TextView title,description;
    int amount_of_event_reminders;
    ListView lv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_reminders);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);
        title = (TextView) findViewById(R.id.Title);
        description = (TextView) findViewById(R.id.Description);


        save_button = (Button) findViewById(R.id.save_button);
        back.setOnClickListener(this);

        back2 = (Button) findViewById(R.id.back2);
        back.setOnClickListener(this);





        final Storage  event = new Storage();
        String[] list_event;
        amount_of_event_reminders = event.get_amount_of_event_reminders();


        if(amount_of_event_reminders==0){
            list_event = new String[1];
            list_event[0]="The list is empty";
        }

        else{
            list_event = new String[amount_of_event_reminders];

            for (int i = 0; i < list_event.length; i++) {
                list_event[i] = event.get_event_reminder(i);
            }
        }

        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_event);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if(amount_of_event_reminders==0){

                }else{
                    lv.setVisibility(View.INVISIBLE);
                    back.setVisibility(View.INVISIBLE);
                    title.setVisibility(View.VISIBLE);
                    description.setVisibility(View.VISIBLE);
                    save_button.setVisibility(View.VISIBLE);
                    back2.setVisibility(View.VISIBLE);
                  String event_description = event.get_event_reminder(position);

                  for(int i=0;i<event_description.length();i++){

                      if(event_description.charAt(i)==';'){
                         title.setText(String.valueOf(event_description.substring(0,i)));
                         description.setText(String.valueOf(event_description.substring(i,event_description.length())));
                      }
                  }

                }
            }
        });



    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back:
                Intent intent3 = new Intent(event_reminders.this,MainActivity.class);
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