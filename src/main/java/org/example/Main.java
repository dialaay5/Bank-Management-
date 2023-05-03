package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static EnumBankName getRandomBankName() {
        Random random = new Random();
        return EnumBankName.values()[random.nextInt(EnumBankName.values().length)];
    }

    public static double getRandomAmountOfMoney() { // r.nextInt(high-low) + low; // between 10000 to 5000
        Random rand = new Random();
        return rand.nextInt(10000 - 5000) + 5000;
    }

    public static double getRandomAmountOfMoneyToCompanyCus() { // between 100000 to 50000
        Random rand = new Random();
        return rand.nextInt(100000 - 50000) + 50000;
    }

    public static void main(String[] args) {
        BankHapoalim hapoalim = new BankHapoalim(744, EnumBankName.HAPOALIM, 10, 1000000d, 200000d);
        BankDiscount discount = new BankDiscount(110, EnumBankName.DISCOUNT, 12, 500000d, 50000d);
        BankLeomi leomi = new BankLeomi(932, EnumBankName.LEOMI, 15, 3000000d, 500000d);

        ArrayList<Customers> customerArrayList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            customerArrayList.add(new Customer(i, getRandomBankName(), getRandomAmountOfMoney()));
        }
        for (int i = 11; i <= 13; i++) {
            customerArrayList.add(new CompnayCuatomer(i, EnumBankName.DISCOUNT, getRandomAmountOfMoneyToCompanyCus()));
        }

        System.out.println("the customers of bank hapoalim:\n");
        customerArrayList.forEach(hapoalim::add_customer);
        System.out.println(" ");

        System.out.println("the customers of bank discount:\n");
        customerArrayList.forEach(discount::add_customer);
        System.out.println(" ");

        System.out.println("the customers of bank leomi:\n");
        customerArrayList.forEach(leomi::add_customer);

        System.out.println(" ");

        System.out.println("bank hapoalim:\n");
        hapoalim.take_payment(200);

        System.out.println(" ");

        System.out.println("bank leomi:\n");
        leomi.take_payment(300);

        System.out.println(" ");

        System.out.println("bank discount:\n");
        discount.take_payment(100); // יצאתי מנקודת הנחת שללקוח פרטי וגם עסקי אותו סכום של  עמלה

        System.out.println(" ");

        System.out.printf("calculate Customer Money hapoalim= %s\n", hapoalim.calculate_Customer_Money());
        System.out.printf("calculate Customer Money discount= %s\n", discount.calculate_Customer_Money());
        System.out.printf("calculate Customer Money leomi= %s\n",leomi.calculate_Customer_Money());

        System.out.println(hapoalim.amount_of_revenue);
        System.out.println(discount.amount_of_revenue);
        System.out.println(leomi.amount_of_revenue);

        customerArrayList.forEach(customers -> customers.get_payment(2000d));

















    }
}
