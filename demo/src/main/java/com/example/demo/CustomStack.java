package com.example.demo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CustomStack {
    private static final Logger logger=Logger.getLogger(CustomStack.class.getName());
    private ArrayList<Integer> stack;
    private int maxSize;

    public CustomStack(int maxSize){
        this.maxSize=maxSize;
        this.stack=new ArrayList<>();
    }
    public void push(int x) {
        try {
            if (stack.size() < maxSize) {
                stack.add(x);
            } else {
                logger.warning("Stack is full cannot push" + x);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception is push()", e);
        }
    }

    public int pop() {
        try {
            if (stack.isEmpty()) {
                logger.warning("Stack is empty cannot pop");
                return -1;
            }
            return stack.remove(stack.size() - 1);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception is pop(),e");
            return -1;
        }
    }

    public void increment(int k,int val) {
        try {
            int limit = Math.min(k, stack.size());
            for (int i = 0; i < limit; i++) {
                stack.set(i, stack.get(i) + val);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in increment()", e);
        }
    }
    public void printStack() {
        try {
            logger.info("Stack:" + stack);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Exception in printStack()", e);
        }
    }
    public static void main(String[] args){
        try {
            CustomStack c1 = new CustomStack(10);

            c1.push(5);
            c1.push(4);
            c1.push(3);
            c1.push(8);
            c1.printStack();

            c1.increment(3, 100);
            c1.printStack();

            logger.info("popped:" + c1.pop());
            c1.printStack();
        }catch(Exception e){
            logger.log(Level.SEVERE,"Exception in main()",e);
        }
    }
}
