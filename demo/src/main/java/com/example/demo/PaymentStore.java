package com.example.demo;

class User{
    private int userId;
    private String name;
    private String email;

    public User(int userId,String name,String email){
        this.userId=userId;
        this.name=name;
        this.email=email;
    }
}
class Order {
    private int orderId;
    private double amount;
    private User user;
    private String status;

    public Order(int orderId, double amount, User user,String status) {
        this.orderId = orderId;
        this.amount = amount;
        this.user = user;
        this.status = status;
    }
    public int getOrderId(){
        return orderId;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
}
interface PaymentProcessor {
    void processPayment(Order order);
}

class CreditCardProcessor implements PaymentProcessor {
    @Override
    public void processPayment(Order order) {
        System.out.println("Processing credit card payment for Order #" + order.getOrderId());
        order.setStatus("Paid");
    }
}
//paypal payment
class PayPalPayment implements PaymentProcessor{
    @Override
    public void processPayment(Order order) {
        System.out.println("processing paypal payment for order #"+order.getOrderId());
        order.setStatus("paid");
    }
}
//bank transfer
class BankTransferProcessor implements PaymentProcessor{
    @Override
    public void processPayment(Order order) {
        System.out.println("processing bank transfer payment for order #"+order.getOrderId());
        order.setStatus("paid");
    }
}

class Transaction {
    private Order order;
    private PaymentProcessor processor;

    public Transaction(Order order, PaymentProcessor processor) {
        this.order = order;
        this.processor = processor;
    }

    public void execute() {
        processor.processPayment(order);
    }
}

public class PaymentStore {
    public static void main(String[] args){
        User u1=new User(42,"aaa","abc@gmail.com");
        Order o=new Order(12,1500,u1,"pending");
        PaymentProcessor p1 = new CreditCardProcessor();  // or
        PaymentProcessor p2= new PayPalPayment();        // or
        PaymentProcessor p3 = new BankTransferProcessor();
        Transaction t1=new Transaction(o,p2);
        t1.execute();

        System.out.println("order status:"+o.getStatus());

    }
}


