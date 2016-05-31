package com.dimagiopatriot.labapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabWork4 extends AppCompatActivity {

    LabWork4BackEnd labWork4BackEnd;
    TextView result;
    EditText parameterA;
    EditText parameterB;
    EditText parameterError;

    Double a;
    Double b;
    Double error;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_work4);

        parameterA = (EditText)findViewById(R.id.editText4);
        parameterB = (EditText)findViewById(R.id.editText5);
        parameterError = (EditText)findViewById(R.id.editText6);
        result = (TextView)findViewById(R.id.textView13);
    }

    public void onClick(View view){
        try {
            initBackEnd();
            if (labWork4BackEnd.a == 0) {
                Toast toast = Toast.makeText(getApplicationContext(), "Параметр а дорівнює 0!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            if (!labWork4BackEnd.isRightData()) {
                Toast toast = Toast.makeText(getApplicationContext(), "Верхня границя більша нижньої!", Toast.LENGTH_SHORT);
                toast.show();
                return;
            }
            result.setText(labWork4BackEnd.setResult().toString());
        }catch (NumberFormatException e){
            Toast toast = Toast.makeText(getApplicationContext(), "А поля заповнені?", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void initBackEnd() {
        a = Double.parseDouble(parameterA.getText().toString());
        b = Double.parseDouble(parameterB.getText().toString());
        error = Double.parseDouble(parameterError.getText().toString());

        labWork4BackEnd = new LabWork4BackEnd(a, b, error);
    }
}
