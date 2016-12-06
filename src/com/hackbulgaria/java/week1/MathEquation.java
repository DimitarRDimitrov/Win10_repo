package com.hackbulgaria.java.week1;

/**
 * Created by Dimitar on 28/11/2016.
 */
public class MathEquation {

    private double leftVal;
    private double rightVal;
    private char opCode;
    public double result;

    public void execute() {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0.0d ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Error - invalid opCode");
                result = 0.0d;
                break;
        }
    }

    public MathEquation(double leftVal, double rightVal, char opCode){
        this.leftVal = leftVal;
        this.rightVal = rightVal;
        this.opCode = opCode;
    }




}
