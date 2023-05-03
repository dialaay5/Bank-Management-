package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompnayCuatomer extends Customers{
    private String name;


    public CompnayCuatomer(int id, EnumBankName enumBankName, double amount_of_money) {
        super(id, enumBankName, amount_of_money);
    }

    public CompnayCuatomer(int id, EnumBankName enumBankName, double amount_of_money, String name) {
        super(id, enumBankName, amount_of_money);
        this.name = name;
    }
}
