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
import android.widget.Spinner;
import android.widget.TextView;

public class Study_Work_Reminders extends AppCompatActivity implements View.OnClickListener {

    Button back,back2,save_button;
    TextView title,description;


    int amount;
    String first_string;
    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study__work__reminders);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(this);

        title = (TextView) findViewById(R.id.Title);
        description = (TextView) findViewById(R.id.Descrption_field);


        save_button = (Button) findViewById(R.id.save_button);
        save_button.setOnClickListener(this);

        back2 = (Button) findViewById(R.id.back_button2);
        back2.setOnClickListener(this);

        save_button.setVisibility(View.INVISIBLE);
        back2.setVisibility(View.INVISIBLE);



        final SharedPreferences pref = getApplicationContext().getSharedPreferences("Study_work", 0);

        amount = pref.getInt("Amount", -1);

        String[] list_study_work;

        if(amount==-1){
            list_study_work = new String[1];
            list_study_work[0]="The list is empty";
        }else{
            list_study_work = new String[amount];

            for(int i=0;i<amount;i++){

                String study_work = pref.getString(String.valueOf(i),"");

                for(int j=0;j<study_work.length();j++){

                    if(study_work.charAt(j)==';'){
                        first_string=study_work.substring(0,j);
                    }

                }

                list_study_work[i]=first_string;
            }


        }

        lv = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_study_work);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                if(amount==0){


                }else{
                    lv.setVisibility(View.INVISIBLE);
                    back.setVisibility(View.INVISIBLE);
                    title.setVisibility(View.VISIBLE);
                    description.setVisibility(View.VISIBLE);
                    save_button.setVisibility(View.VISIBLE);
                    back2.setVisibility(View.VISIBLE);
                    String study_work_description = pref.getString(String.valueOf(position),"");
                    for(int i=0;i<study_work_description.length();i++){

                        if(study_work_description.charAt(i)==';'){
                            title.setText(String.valueOf(study_work_description.substring(0,i)));
                            description.setText(String.valueOf(study_work_description.substring(i+1,study_work_description.length())));
                        }
                    }

                }
            }
        });



    }


    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.back:
                Intent intent3 = new Intent(Study_Work_Reminders.this,MainActivity.class);
                startActivity(intent3);
                break;

            case R.id.back_button2:
                lv.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                title.setVisibility(View.INVISIBLE);
                description.setVisibility(View.INVISIBLE);
                save_button.setVisibility(View.INVISIBLE);
                back2.setVisibility(View.INVISIBLE);
                break;
            case R.id.save_button:


                lv.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                title.setVisibility(View.INVISIBLE);
                description.setVisibility(View.INVISIBLE);
                save_button.setVisibility(View.INVISIBLE);
                back2.setVisibility(View.INVISIBLE);


                break;

            default:
                break;

        }
    }



}
