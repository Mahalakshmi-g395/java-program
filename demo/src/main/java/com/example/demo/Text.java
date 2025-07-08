package com.example.demo;

import java.util.Scanner;

public class Text {
    public static void main(String[] args){
        Scanner s1=new Scanner(System.in);

        System.out.println("Enter your text:");
        String inputText=s1.nextLine();

        System.out.println("Character count (with spaces):"+countCharacters(inputText));
        System.out.println("Word count:"+countWords(inputText));
        System.out.println("Sentence count:"+countSentences(inputText));

        s1.close();

        }
    public static int countCharacters(String text) {
        return text.length();
    }

    public static int countWords(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }
    public static int countSentences(String text){
        int count=0;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i)=='.'){
                count++;
            }
        }
        return count;

    }
}
