package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;


public class ListApplication {
    public static void main(String[] args){
        ArrayList<String> tasks=new ArrayList<>();
        Scanner s1=new Scanner(System.in);
        int choice;
         System.out.println("welcome to do list application:");

         do {
             System.out.println("/n Menu:");
             System.out.println("1. View task");
             System.out.println("2.Add tasks");
             System.out.println("3.Remove tasks");
             System.out.println("Exit");
             System.out.println("enter your choice:");
             choice=s1.nextInt();
             s1.nextLine();

             switch (choice){
                 case 1:
                     if(tasks.isEmpty()){
                         System.out.println("Tasks is empty");
                     }else{
                         System.out.println("your Tasks is");
                         for(int i=0;i< tasks.size();i++){
                             System.out.println((i+1) +"."+tasks.get(i));
                         }
                     }
                     break;
                 case 2:
                     System.out.println("Enter a new Tasks");
                     String newTask=s1.nextLine();
                     tasks.add(newTask);
                     System.out.println("Task is added");
                     break;
                 case 3:
                     if(tasks.isEmpty()){
                         System.out.println("no task to remove");
                     } else {
                         System.out.println("Select the task number to remove:");
                         for(int i=0;i< tasks.size();i++){
                             System.out.println((i+1) +"." +tasks.get(i));
                         }
                         System.out.println("enter number:");
                         int taskNumber=s1.nextInt();
                         if(taskNumber>0 && taskNumber<=tasks.size()){
                             tasks.remove(taskNumber-1);
                             System.out.println("task removed");
                         } else {
                             System.out.println("invalid task number:");
                         }
                     }
                     break;
                 case 4:
                     System.out.println("Exiting list application");
                     break;
                 default:
                     System.out.println("invalid choice");
             }
         } while (choice!=4);
         s1.close();
    }
}