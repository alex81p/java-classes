package com.example;

/*
Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные
на консоль. В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
2. Customer: id, Фамилия, Имя, Отчество, Адрес, Номер кредитной карточки, Номер банковского счета.
Создать массив объектов. Вывести:
a) список покупателей в алфавитном порядке;
b) список покупателей, у которых номер кредитной карточки находится в заданном интервале.
*/

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main( String[] args ) {
        Customer[] customers = new Customer[4];
        customers[0]= new Customer(1,"Sidorov","Sidor","Sidorovich","23-17 Solnechnaya St. Moscow",5678_6553_8766_8764L,"40802810826840003584");
        customers[1]= new Customer(2,"Ivanov","Ivan","Ivanovich","14 Tenistaya St. Saint Petersburg",5412_6458_5459_4532L,"40802810800120000256");
        customers[2]= new Customer(3,"Petrov","Petr","Petrovich","113-19 Stroiteley St. Vladivostok",5568_5423_8409_8837L,"40802810817850005862");
        customers[3]= new Customer(4,"Ivanov","Ivan","Alekseyevich","5-84 Truda St. Chelyabinsk",4567_7879_0936_9845L,"40802810800100083265");
        System.out.println("List of customers:");
        Arrays.stream(customers).forEach(System.out::println);
        System.out.println("List of customers sorted by name in alphabetical order:");
        Arrays.stream(customers)
                .sorted(Comparator.comparing(Customer::getFullName))
                .forEach(o -> System.out.println(o.getFullName()));
        System.out.println("List of customers whose credit card numbers range from 5400 0000 0000 0000 to 5600 0000 0000 0000:");
        Arrays.stream(customers)
                .filter(o -> o.getCreditCardNumber() >= 5400_0000_0000_0000L && o.getCreditCardNumber() <= 5600_0000_0000_0000L)
                .forEach(o -> System.out.println(o.getFullName() + ", credit card number: " + o.getFormattedCreditCardNumber()));
    }
}
