package com.dimagiopatriot.labapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabWork5 extends AppCompatActivity {

    private EditText getError;
    private EditText elementOfArrayA;
    private EditText elementOfArrayB;

    private Button getResult;
    private TextView showResult;

    public int [][] indexsA = {{R.id.a11, R.id.a12, R.id.a13, R.id.a14},
            {R.id.a21, R.id.a22, R.id.a23, R.id.a24},
            {R.id.a31, R.id.a32, R.id.a33, R.id.a34},
            {R.id.a41, R.id.a42, R.id.a43, R.id.a44}};
    public int [] indexsB = {R.id.b1, R.id.b2, R.id.b3, R.id.b4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_work5);

        getResult = (Button) findViewById(R.id.getResultButton);
    }


    private int resolution = 4;
    private double[][] arrayIndexA = new double[resolution][resolution];
    private double[] arrayIndexB = new double[resolution];

    private void initElements () {
        try {

            for (int k =0; k < resolution; k++) {
                for (int i = 0; i < resolution; i++) {
                    elementOfArrayA = (EditText) findViewById(indexsA[k][i]);
                    arrayIndexA[k][i] = Double.parseDouble(elementOfArrayA.getText().toString());
                }
            }
            for (int k = 0; k < resolution; k++) {
                elementOfArrayB = (EditText) findViewById(indexsB[k]);
                arrayIndexB[k] = Double.parseDouble(elementOfArrayB.getText().toString());
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Введіть значення полів масивів!", Toast.LENGTH_LONG);
        }
    }

    private void labaLogic() {
        try {
            showResult = (TextView) findViewById(R.id.resultText);
            showResult.setText("Your result is: ");
            LabWork5BackEnd martrix = new LabWork5BackEnd(resolution, arrayIndexA, arrayIndexB);
            getError = (EditText) findViewById(R.id.error);
            double error = Double.parseDouble(getError.getText().toString());
            double[] result = martrix.getResultX(error);
            String text = showResult.getText().toString();
            for(int k = 0; k < result.length; k++) {
                showResult.setText(text + "x" + (k+1) + "="+ result[k] + ", ");
                text = showResult.getText().toString();
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Введіть знаяення похибки!", Toast.LENGTH_LONG);
        }
    }

    public void onClick (View view) {
        initElements();
        labaLogic();
    }
}
