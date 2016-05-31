package com.dimagiopatriot.labapp;
/**
 * Created by User on 23.02.2016.
 */
public class LabWork1BackEnd {
    static String error;

    public static String part1(double d, double r, double g, double F, double D){
        double F1;
        F1=Math.pow((d + (r / g)), F)/Math.pow((d+(r / g)),D);
        return new Double(F1).toString();
    }

    public static String part2 (double gh){
        double er;
        if (gh==0||gh==Math.PI){
            error="Невірний аргумент функції";
            return error;
        } else
            er=1/ Math.tan(gh);
            return new Double(er).toString();
    }

    public static String part3 (double n){
        double J=0;
        int m = 25;
        for (int i=0; i<=25; i++)
            J+=1/n;
        return new Double(J).toString();
    }
}
