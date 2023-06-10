package org.example.funtionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        final Customer maria = new Customer("Maria", "3652255985");
        greetCustomer(maria);

        // Consumer
        final Customer jack = new Customer("Jack", "555869588");
        greetCustomerConsumer.accept(jack);

        // BiConsumer
        final Customer gordon = new Customer("Gordon", "88856223369");
        greetCustomerBiConsumer.accept(gordon, false);

    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
                ", thanks for registering phone number: " +
                customer.customerPhoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number: " +
            customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName +
                    ", thanks for registering phone number: " +
                    (showPhoneNumber ?  customer.customerPhoneNumber : "**********"));



    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
