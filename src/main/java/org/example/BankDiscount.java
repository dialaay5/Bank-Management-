package org.example;


public class BankDiscount extends Bank {

    public BankDiscount(int id, EnumBankName enumBankName, int number_of_employees, double amount_of_revenue, double amount_of_expenses) {
        super(id, enumBankName, number_of_employees, amount_of_revenue, amount_of_expenses);
    }

        @Override
    public double calculate_Customer_Money() {
        double sum_of_customers_money = 0;
        for (var entry : map_of_customers.entrySet()) {
            sum_of_customers_money += entry.getValue().getAmount_of_money();
        }
        setAmount_of_revenue(sum_of_customers_money);
        return getAmount_of_revenue();
    }
}
