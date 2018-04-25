/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author sachins
 */
class Time implements Comparable<Time> {
    private int hour;
    private int mins;
    private int totalMins;

    public Time() {

    }

    public Time(int hour,int min) {
        this.hour=hour;
        this.mins=min;
    }


    public int read(String time){
        System.out.println(time);
        Scanner in = new Scanner (System.in);
        // String s = in.next();
        // String[] hourMin = s.split(":");
        System.out.println("Hour : ");
        this.hour = Integer.parseInt(in.nextLine());
        System.out.println("Min : ");
        this.mins =Integer.parseInt(in.nextLine());
        this.totalMins = 60*hour + mins;
        return this.totalMins;
    }

    public boolean lessThan(Time time2){

        return time2.totalMins >this.totalMins;
    }

    public Time substract(Time time2){
        int totalResult=this.totalMins-time2.totalMins;
        Time duration=new Time();
        duration.hour=totalResult/60;
        duration.mins=totalResult%60;
        return duration;

    }

    @Override
    public String toString() {
        return ""+ this.hour + ":" + this.mins;
    }

    @Override
    public int compareTo(Time T) {
        if(T.lessThan(this)){
            return 1;
        }
        else if(this.lessThan(T)){
            return -1;
        }
        else {
            return 0;
        }}
}


