package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Customers {
    protected int id;
    protected EnumBankName enumBankName;
    protected double amount_of_money;

    public Customers(int id, EnumBankName enumBankName, double amount_of_money) {
        this.id = id;
        this.enumBankName = enumBankName;
        this.amount_of_money = amount_of_money;
    }

    public void get_payment(double salary){
        this.amount_of_money += salary;

    }
    @Override
    public String toString() {
        return "{"+
                id + " , " +
                enumBankName + " , " +
                amount_of_money +
                '}';
    }
}
