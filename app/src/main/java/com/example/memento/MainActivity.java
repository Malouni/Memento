package com.example.memento;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button create_reminder,daily_reminders,event_reminder,study_work;

    int daily_amount,event_amount,study_work_amount;
    String daily_d,event_d,study_work_d;

    String currentTime,currentDate;

    AsyncTask<?, ?, ?> notificationChecker;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_reminder = (Button) findViewById(R.id.create_reminder);
        create_reminder.setOnClickListener(this);
        study_work = (Button) findViewById(R.id.study_work);
        study_work.setOnClickListener(this);
        event_reminder = (Button) findViewById(R.id.Event_reminder);
        event_reminder.setOnClickListener(this);
        daily_reminders = (Button) findViewById(R.id.daily_reminders);
        daily_reminders.setOnClickListener(this);

        currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        Log.d("####Current time####",String.valueOf(currentTime));
        Log.d("####Current time####",String.valueOf(currentDate));


        /*
        for(;;){
            notificationChecker= new notificationSender();
            notificationChecker.execute();
        }

         */

    }


    public void onClick(View v){
        switch (v.getId()) {

            case R.id.create_reminder:
                Intent intent = new Intent(MainActivity.this,Create_reminder.class);
                startActivity(intent);
                break;

            case R.id.study_work:
                Intent intent4 = new Intent(MainActivity.this,Study_Work_Reminders.class);
                startActivity(intent4);
                break;

            case R.id.Event_reminder:
                Intent intent1 = new Intent(MainActivity.this,event_reminders.class);
                startActivity(intent1);
                break;

            case R.id.daily_reminders:
                Intent intent3 = new Intent(MainActivity.this,Daily_Reminder.class);
                startActivity(intent3);
                break;

            default:
                break;

        }
    }



    private final class  notificationSender extends  AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... voids) {

            SharedPreferences pref_daily = getApplicationContext().getSharedPreferences("Daily", 0);
            SharedPreferences pref_event = getApplicationContext().getSharedPreferences("Event", 0);
            SharedPreferences pref_study_work = getApplicationContext().getSharedPreferences("Study_work", 0);

            daily_amount = pref_daily.getInt("Amount", -1);
            event_amount = pref_event.getInt("Amount", -1);
            study_work_amount = pref_study_work.getInt("Amount", -1);




                    if (daily_amount != -1) {
                        daily_d = pref_daily.getString(String.valueOf(daily_amount), "");
                        String title="",description="",dates;
                        int hours=0,minutes=0;

                        int position_title=0;

                        for(int i=0;i<daily_d.length();i++){

                            if(daily_d.charAt(i)==';'){

                                title=daily_d.substring(0,i);
                                position_title=i;

                            }else if(daily_d.charAt(i)=='#'){

                                description = daily_d.substring(position_title+1,i);

                                    for(int j=i;j<daily_d.length();j++){

                                        if(daily_d.charAt(j)==':'){
                                            hours=Integer.parseInt(daily_d.substring(i+1,j));
                                            minutes=Integer.parseInt(daily_d.substring(j+1,daily_d.length()));
                                        }
                                    }
                            }


                        }
                        String eventTime=hours+":"+minutes;

                        if(currentTime==eventTime){
                            addNotification(title,description);
                        }




                    }
                    if (event_amount != -1) {
                        event_d = pref_daily.getString(String.valueOf(event_amount), "");

                        String title="",description="",dates="";
                        int hours=0,minutes=0;

                        int position_title=0,position_desciption=0;

                        for(int i=0;i<event_d.length();i++){

                            if(event_d.charAt(i)==';'){

                                title=event_d.substring(0,i);
                                position_title=i;

                            }else if(event_d.charAt(i)=='@'){
                                description = event_d.substring(position_title+1,i);
                                position_desciption=i;
                            } else if(event_d.charAt(i)=='#'){

                                    dates=event_d.substring(position_desciption+1,i);


                                for(int j=i;j<event_d.length();j++){

                                    if(event_d.charAt(j)==':'){
                                        hours=Integer.parseInt(event_d.substring(i+1,j));
                                        minutes=Integer.parseInt(event_d.substring(j+1,event_d.length()));
                                    }
                                }
                            }


                        }
                        String eventTime=hours+":"+minutes;

                        if(currentTime==eventTime && currentDate==dates){
                            addNotification(title,description);
                        }









                    }
                    if (study_work_amount != -1) {
                        study_work_d = pref_daily.getString(String.valueOf(study_work_amount), "");

                        String title="",description="",dates="";
                        int hours=0,minutes=0;

                        int position_title=0,position_desciption=0;

                        for(int i=0;i<study_work_d.length();i++){

                            if(study_work_d.charAt(i)==';'){

                                title=study_work_d.substring(0,i);
                                position_title=i;

                            }else if(study_work_d.charAt(i)=='@'){
                                description = study_work_d.substring(position_title+1,i);
                                position_desciption=i;
                            } else if(study_work_d.charAt(i)=='#'){

                                    dates=event_d.substring(position_desciption+1,i);

                                for(int j=i;j<study_work_d.length();j++){

                                    if(study_work_d.charAt(j)==':'){
                                        hours=Integer.parseInt(study_work_d.substring(i+1,j));
                                        minutes=Integer.parseInt(study_work_d.substring(j+1,study_work_d.length()));
                                    }
                                }
                            }


                        }
                        String eventTime=hours+":"+minutes;

                        if(currentTime==eventTime && currentDate==dates){
                            addNotification(title,description);
                        }






                    }



            return null;
        }



    private void addNotification(String title,String description){

        int NOTIFICATION_ID = 234;
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            String CHANNEL_ID = "my_channel_01";
            CharSequence name = "my_channel";
            String Description = "This is my channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(Description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(mChannel);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext().getApplicationContext(),CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(description);

        Intent resultIntent = new Intent(getApplicationContext().getApplicationContext(), MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext().getApplicationContext());
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);
        notificationManager.notify(NOTIFICATION_ID, builder.build());





    }









    }














}
