package com.dimagiopatriot.labapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class LabWork1 extends AppCompatActivity {

    LabWork1BackEnd labWork1BackEnd;
    ArrayList<Double> numbersInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab_app);
    }
    public void onClick(View view){
        result1();
        result2();
        result3();
    }

    public void checkEditText(String editText){
        ArrayList<String> numbers = new ArrayList<String>();
        StringTokenizer st = new StringTokenizer(editText,", ");
        while (st.hasMoreTokens()){
            numbers.add(st.nextToken());
        }
        numbersInt = new ArrayList<Double>();
        for(int i=0; i<numbers.size();i++){
            numbersInt.add(new Double(numbers.get(i)));
        }

    }
    public void result1(){
        EditText param1 = (EditText)findViewById(R.id.editText);
        checkEditText(param1.getText().toString());
        TextView res1= (TextView)findViewById(R.id.textView5);
        res1.setText("Результат (F1) :");
        if(numbersInt.size()!=5){
            res1.setText(res1.getText().toString() + "Має бути 5 аргументів!");
        }else {
            double d = numbersInt.get(0);
            double r = numbersInt.get(1);
            double g = numbersInt.get(2);
            double F = numbersInt.get(3);
            double D = numbersInt.get(4);
            res1.setText(res1.getText().toString() + labWork1BackEnd.part1(d, r, g, F, D).toString());
        }
    }
    public void result2(){
        EditText param2 = (EditText)findViewById(R.id.editText2);
        checkEditText(param2.getText().toString());
        TextView res2=(TextView)findViewById(R.id.textView8);
        res2.setText("Результат (er) :");
        if (numbersInt.size()!=1){
            res2.setText(res2.getText().toString() + "Має бути 1 аргумент!");
        }else {
            double gh=numbersInt.get(0);
            res2.setText(res2.getText().toString() + labWork1BackEnd.part2(gh));
        }
    }

    public void result3(){
        EditText param3 = (EditText)findViewById(R.id.editText3);
        checkEditText(param3.getText().toString());
        TextView res3=(TextView)findViewById(R.id.textView11);
        res3.setText("Результат (J) :");
        if (numbersInt.size()!=1){
            res3.setText(res3.getText().toString() + "Має бути 1 аргумент!");
        }else {
            double n = numbersInt.get(0);
            res3.setText(res3.getText().toString() + labWork1BackEnd.part3(n));
        }
    }

}
