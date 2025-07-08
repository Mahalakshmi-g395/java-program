package com.example.demo;

import java.util.Scanner;

public class Grade {
    public static void main(String[] args){
        Scanner s1 = new Scanner(System.in);
        System.out.println("Enter the students score:");
        int score=s1.nextInt();

        if(score<0 || score>100){
            System.out.println("Invalid Score:Please enter the correct score");
            return;
        }
        char grade;
        String feedback;

        if(score >=91){
            grade='O';
            feedback="Excellent performance!..Keep it up";
        }else if (score >=81){
            grade='A';
            feedback="Very Good,Aim to high";
        } else if (score >=71) {
            grade='B';
            feedback="Good try your best";
        }else if(score >=61){
            grade='c';
            feedback="Better performance";
        } else if (score >=51) {
            grade='D';
            feedback="need improvement";
        } else if (score >=41) {
            grade='E';
            feedback="you are just pass";
        }else {
            grade='U';
            feedback="you are fail,try to get pass score in next exam";
        }
        System.out.println("Grade:"+grade);
        System.out.println("Feedback:"+feedback);

        s1.close();
    }
}
