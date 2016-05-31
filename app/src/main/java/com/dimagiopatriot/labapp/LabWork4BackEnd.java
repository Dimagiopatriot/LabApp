package com.dimagiopatriot.labapp;

/**
 * Created by User on 12.04.2016.
 */
public class LabWork4BackEnd {

    double a;
    double b;
    double error;

    LabWork4BackEnd(double a, double b, double error){
        this.a=a;
        this.b=b;
        this.error=error;
    }

    public boolean isRightData(){
        if(function(a)*function(b)<=0)
            return false;
        return true;
    }

    private double function(double x){
        return x + Math.log10(x)-0.5;
    }

    private double derivativeFunction(double a){
        return (1/(Math.log(10)*a))+1;
    }

    private double setLambda(){
        return 1/derivativeFunction(a);
    }

    public Double setResult(){
        double x=b;
        double func;
        if (x==0)
            return 0.;
        do {
            func=function(x);
            x=x-setLambda()*function(x);
        } while (Math.abs(func)>=error);
        return x;
    }

}
