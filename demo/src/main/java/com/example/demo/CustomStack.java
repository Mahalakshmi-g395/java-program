package com.example.demo;

import java.util.ArrayList;
public class CustomStack {
    private ArrayList<Integer> stack;
    private int maxSize;
    public CustomStack(int maxSize){
        this.maxSize=maxSize;
        this.stack=new ArrayList<>();
    }
    public void push(int x){
        if (stack.size()<maxSize){
            stack.add(x);
        }else{
            System.out.println("stack is full"+x);
        }
    }
    public int pop(){
        if(stack.isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stack.remove(stack.size() -1);
    }
    public void increment(int k,int val){
        int limit=Math.min(k,stack.size());
        for(int i=0;i<limit;i++){
            stack.set(i,stack.get(i)+val);
        }
    }
    public void printStack(){
        System.out.println("Stack:"+stack);
    }
    public static void main(String[] args){
        CustomStack c1=new CustomStack(10);

        c1.push(5);
        c1.push(4);
        c1.push(3);
        c1.push(8);
        c1.printStack();

        c1.increment(3,100);
        c1.printStack();

        System.out.println("popped:"+c1.pop());
        c1.printStack();
    }
}
