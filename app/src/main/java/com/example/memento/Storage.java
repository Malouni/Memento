package com.example.memento;

public class Storage {

    String [] daily_reminders = new String [1000];
    int amount_of_daily_reminders = 0;


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





}
