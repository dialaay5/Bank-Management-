package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer extends Customers{
    private String first_name;
    private String last_name;
    private String credit_card_number;


    public Customer(int id, EnumBankName enumBankName, double amount_of_money) {
        super(id, enumBankName, amount_of_money);
    }

    public Customer(int id, EnumBankName enumBankName, double amount_of_money, String first_name, String last_name, String credit_card_number) {
        super(id, enumBankName, amount_of_money);
        this.first_name = first_name;
        this.last_name = last_name;
        this.credit_card_number = credit_card_number;
    }
}

