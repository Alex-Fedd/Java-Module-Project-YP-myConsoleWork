package org.example;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);        //исследовал сам, что это useLocale(Locale.getDefault());
    static Calculator calculatorObject = new Calculator();
    static MyFormatter myFormatter = new MyFormatter();

    public static void main(String[] args) {
        int allGuests;
        while (true) {
            System.out.println("На скольких человек необходимо разделить счёт?");
            if (scan.hasNextInt()) {
                allGuests = scan.nextInt();
                if (allGuests < 1) {
                    System.out.println("Некорректное значение. Введите корректное число гостей.\n");
                } else if (allGuests == 1) {
                    System.out.println("Один человек - считать нечего. До свидания!\n");
                    return;
                } else {
                    scan.nextLine();
                    // если ввел более 1, то цикл стопаю и продолжаю программу
                    // тоже съел пустой символ, оставшийся от некстИнта
                    break;
                }
            } else if (!(scan.hasNextInt())) {
                System.out.println("Некорректное значение. Введите корректное число гостей.");
                scan.nextLine(); // поглотил лишний символ (строку)
            }
        }

        //далее калькулятор после второй партии вопросов
        while (true) {
            System.out.println("Какое название у товара?");
            // String itemName = scan.nextLine(); //Это был 1-й вар. Ниже проверяю на пустоту. isBlank() метод
            // не находился почему-то и красным светился, потому сделал через hasNextLine и trim+isEmpty
            String itemName = "";
            while (scan.hasNextLine()) {
                itemName = scan.nextLine();
                if (itemName.trim().isEmpty()) {
                    System.out.println("Ничего не введено. Какое название у товара?");
                } else {
                    break;
                }
            }
            // далее обработка, чтобы у юзера при вводе строки не упало прил.
            double itemPrice = 0.0;
            while (true) {
                System.out.println("Какая цена у товара?");
                if (scan.hasNextDouble()) {
                    itemPrice = scan.nextDouble();
                    if (itemPrice < 0) {
                        System.out.println("Отрицательное значение. Введите заново.");
                    } else {
                        scan.nextLine();
                        break;
                    }
                } else if (!scan.hasNextDouble()) {
                    System.out.println("Некорректное значение. Надо ввести в формате: 00,00");
                    scan.nextLine();
                }
            }
            calculatorObject.addMyItem(itemName, itemPrice);
            System.out.println("Товар " + itemName + " успешно добавлен!" +
                    " Хотите ли добавить ещё один товар? Если да - введите что-нибудь. Если нет - введите Завершить");
            if (scan.hasNextLine()) {
                if (scan.nextLine().equalsIgnoreCase("Завершить")) {
                    break;
                }
            }
        }
        System.out.println("Добавленные товары:"); // после Завершить вывожу все
        calculatorObject.showItems();

        myFormatter.printFormatResult(calculatorObject.calculateMyTotal(), allGuests);
    }
}