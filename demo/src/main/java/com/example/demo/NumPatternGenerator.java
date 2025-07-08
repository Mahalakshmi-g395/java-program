package com.example.demo;

import java.util.Scanner;

public class NumPatternGenerator {
    public static void main(String[] args){
        Scanner s1=new Scanner(System.in);

        System.out.println("Number Pattern Generator");
        System.out.print("Enter the number of rows: ");
        int rows =s1.nextInt();

        System.out.println("Enter your choice:");
        System.out.println("1.Inverted Triangle");
        System.out.println("2.Floyds Triangle");
        System.out.println("3.Pyramid Triangle:");
        System.out.println("4.Increasing Triangle");
        int patternType=s1.nextInt();

        switch (patternType){
            case 1:
               InvertedTriangle(rows);
                break;
            case 2:
                FloydsTriangle(rows);
                break;
            case 3:
                PyramidTriangle(rows);
                break;
            case 4:
                IncreasingTriangle(rows);
            default:
                System.out.println("Invalid choice");

        }
        s1.close();

    }
    public static void InvertedTriangle(int rows){
        for(int i=rows;i>=1;i--){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }

    }
    public static void FloydsTriangle(int rows){
        int num=1;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=i;j++){
                System.out.println(num++ +" ");
            }
            System.out.println();
        }
    }
    public static void PyramidTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int space = 1; space <= rows - i; space++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void IncreasingTriangle(int rows){
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
