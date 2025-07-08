package com.example.demo;

import java.util.Scanner;

public class FlexibleCalculator {
    public static Number parseNumber(String input) throws NumberFormatException{
        input=input.trim();
        if(input.contains(".")) {
            return Double.parseDouble(input);
        }else{
            return Integer.parseInt(input);
        }
    }
    public static void main(String[] args){
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter the first number");
        String input1= s1.nextLine();

        System.out.println("Enter the second number");
        String input2=s1.nextLine();

        System.out.println("Enter the operator:");
        String operator=s1.nextLine().trim();

        try{
            Number no1=parseNumber(input1);
            Number no2=parseNumber(input2);

            double val1=no1.doubleValue();
            double val2=no2.doubleValue();
            double result;

            switch (operator){
                case "+":
                    result=val1+val2;
                    break;
                case "-":
                    result=val1-val2;
                    break;
                case"*":
                    result=val1*val2;
                    break;
                case"/":
                    if(val2==0){
                        System.out.println("Error: zero cannot be divided by any num");
                        return;
                    }
                    result=val1/val2;
                    break;
                default:
                    System.out.println("Error:Enter the correct operator:");
                    return;
            }
            System.out.println("Result:"+result);

        } catch (NumberFormatException e){
            System.out.println("Error:invalid number input,enter correct number");

        } catch(Exception e ){
            System.out.println("Unexpected Error:"+e.getMessage());
        } finally {
            s1.close();
        }
    }
}
