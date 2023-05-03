package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Setter
@Getter
public abstract class Bank{
    protected int id;
    protected EnumBankName enumBankName;
    protected int number_of_employees;
    protected double amount_of_revenue;
    protected double amount_of_expenses;
    protected HashMap<Integer, Customers> map_of_customers = new HashMap<>();

    public Bank(int id, EnumBankName enumBankName, int number_of_employees, double amount_of_revenue, double amount_of_expenses) {
        this.id = id;
        this.enumBankName = enumBankName;
        this.number_of_employees = number_of_employees;
        this.amount_of_revenue = amount_of_revenue;
        this.amount_of_expenses = amount_of_expenses;
    }

    public void add_customer(Customers customers) {
        if (customers.getEnumBankName().equals(this.enumBankName)) {
            map_of_customers.put(customers.getId(), customers);
            System.out.println(map_of_customers.get(customers.getId()));
        }
    }

    public void take_payment(int payment){
        double amount_of_money_from_payment = 0;
        for (var entry : map_of_customers.entrySet()) {
            amount_of_money_from_payment += payment;
            entry.getValue().setAmount_of_money(entry.getValue().getAmount_of_money() - payment);
            System.out.printf("amout of customers money after take payment = %s\n ", entry.getValue().getAmount_of_money());
        }
        increase_revenue(amount_of_money_from_payment);
        System.out.printf("amount of money from payment = %s\n",amount_of_money_from_payment);
        System.out.printf("amount of banks revenue after payment = %s\n", this.amount_of_revenue);
    }

    public void increase_revenue(double reveneueToAdd){
        this.amount_of_revenue += reveneueToAdd;
    }

    public void  increase_expenses(double  expensesToIncrease){
        this.amount_of_expenses += expensesToIncrease;
    }

    public abstract double calculate_Customer_Money();

}
