package com.dimagiopatriot.labapp;

/**
 * Created by User on 28.04.2016.
 */
public class LabWork5BackEnd {

    private int resolution = 0;

    private double [][] coeficientsOfA;
    private double [] coeficientsOfB;
    private double [] resultX;
    public int counter = 1;

    public LabWork5BackEnd () {
    }

    public LabWork5BackEnd (int resolution, double [][] coeficientsOfA, double [] coeficientsOfB){
        this.resolution = resolution;
        this.coeficientsOfA = new double[resolution][resolution];
        this.coeficientsOfA = coeficientsOfA;
        this.coeficientsOfB = new double[resolution];
        this.coeficientsOfB = coeficientsOfB;
    }


    public double[] getResultX(double error) {
        coeficientsOfA = modificateArray();
        double[] startResult = new  double[resolution];
        resultX = new double[resolution];
        double err = 0.0;
        do{
            for (int i = 0; i < resultX.length; i++) {
                startResult[i] = coeficientsOfB[i];
                for (int j = 0; j < resultX.length; j++) {
                    if (i != j) {
                        startResult[i] -= coeficientsOfA[i][j] * resultX[j];
                    }
                }
                startResult[i] /= coeficientsOfA[i][i];
            }

            err = Math.abs(resultX[0] - startResult[0]);

            for (int i = 0; i < resolution; i++) {
                if (Math.abs(resultX[i] - startResult[i]) > err)
                    err = Math.abs(resultX[i] - startResult[i]);
                resultX[i] = startResult[i];
            }
            counter++;
        } while (err > error);
        return resultX;
    }

    private double [][] modificateArray() {
        double [][] modificate = coeficientsOfA;
        for (int i = 0; i < modificate.length; i++) {
            double max = foundMax(modificate[i]);
            for (int j = 0; j < modificate.length; j++) {
                if (max == Math.abs(modificate[i][j]) && max != Math.abs(modificate[i][i])) {
                    double buff = modificate[i][i];
                    modificate[i][i] = modificate[i][j];
                    modificate[i][j] = buff;
                }
            }
        }
        return modificate;
    }

    private double foundMax(double[] array) {
        double max;
        max = Math.abs(array[0]);
        for (int i = 0; i < array.length; i++) {
            if(max < Math.abs(array[i])) {
                max = Math.abs(array[i]);
            }
        }
        return max;
    }

}
