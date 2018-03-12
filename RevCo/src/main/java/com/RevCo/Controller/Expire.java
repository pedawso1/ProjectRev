package com.RevCo.Controller;

import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;


public class Expire
{
    private Calendar current;
    public boolean isTimeExpired(Date date){
        current = Calendar.getInstance();
        current.setTime(date);
        current.add(Calendar.DATE,6);
        Calendar nows = Calendar.getInstance();
        nows.setTime(Date.valueOf(LocalDate.now()));
        return current.before(nows);
    }
    public boolean submitTimeClose(Date date){
        current = Calendar.getInstance();
        current.setTime(date);
        current.add(Calendar.DATE,-14);
        Calendar nows = Calendar.getInstance();
        nows.setTime(Date.valueOf(LocalDate.now()));
        return current.before(nows);
    }
    public boolean isTimeClose(Date date){
        current = Calendar.getInstance();
        current.setTime(date);
        current.add(Calendar.DATE,4);
        Calendar nows = Calendar.getInstance();
        nows.setTime(Date.valueOf(LocalDate.now()));
        return current.before(nows);
    }
    public boolean isTimeOver(Date date){
        current = Calendar.getInstance();
        current.setTime(date);
        current.add(Calendar.DATE,8);
        Calendar nows = Calendar.getInstance();
        nows.setTime(Date.valueOf(LocalDate.now()));
        return current.before(nows);
    }
    public int timeWarm(Date date){
        System.out.println(date.toString());
        if(isTimeOver(date)){
            return -4;
        }
        else if(isTimeExpired(date)){
            return 0;
        }else if(isTimeClose(date)){
            return -1;
        }else{
            return -2;
        }
    }

}

