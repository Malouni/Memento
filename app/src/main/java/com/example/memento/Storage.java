package com.example.memento;

public class Storage {

    String [] daily_reminders = new String [1000];
    int amount_of_daily_reminders = 0;

    String [] event_reminders = new String [1000];
    int amount_of_event_reminders = 0;

    String [] study_work_reminders = new String [1000];
    int amount_study_work_reminders = 0;


    public void Store_Daily (String daily){
        daily_reminders[amount_of_daily_reminders]=daily;
        amount_of_daily_reminders++;
    }

    public int get_amount_of_daily_reminders(){

        return amount_of_daily_reminders;
    }

    public String get_daily_reminder (int position){
        return daily_reminders[position];
    }


    public void Store_Event (String event){
        event_reminders[amount_of_event_reminders]=event;
        amount_of_event_reminders++;
    }

    public int get_amount_of_event_reminders(){

        return amount_of_event_reminders;
    }

    public String get_event_reminder (int position){
        return event_reminders[position];
    }


    public void Store_study_work (String daily){
        study_work_reminders[amount_study_work_reminders]=daily;
        amount_study_work_reminders++;
    }

    public int get_amount_of_study_work_reminders(){

        return amount_study_work_reminders;
    }

    public String get_study_work_reminder (int position){
        return study_work_reminders[position];
    }





}
