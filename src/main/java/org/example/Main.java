package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Calculator calculatorObject = new Calculator();
    static MyFormatter myFormatter = new MyFormatter();
    public static void main(String[] args) {
        int allGuests;
        double myTotal;
        while(true){
            System.out.println("На скольких человек необходимо разделить счёт?");
            if(scan.hasNextInt()){
                allGuests = scan.nextInt();
                if(allGuests < 1) {
                    System.out.println("Некорректное значение. Введите корректное число гостей.\n");
                }
                else if(allGuests == 1){
                    System.out.println("Один человек - считать нечего. До свидания!\n");
                    return;
                }
                else{
                    scan.nextLine();
                    // если ввел более 1, то цикл стопаю и продолжаю программу
                    // тоже пожрал пустой символ, оставшийся от некстИнта
                    break;
                }
            }
            else if(!(scan.hasNextInt())){
                System.out.println("Некорректное значение. Введите корректное число гостей.");
                scan.nextLine(); // поглотил лишний символ (строку) от прошло некстИнта оставшегося
            }
            }
        //далее тут калькулятор после второй партии вопросов
        while(true) {
            System.out.println("Какое название у товара?");
            String itemName = scan.nextLine();
            System.out.println("Какая цена у товара?");
            double itemPrice = scan.nextDouble();
            scan.nextLine(); // съел пустой остаток некстДабла
            calculatorObject.addMyItem(itemName, itemPrice);
            System.out.println("Товар " + itemName + " успешно добавлен!" +
                    " Хотите ли добавить ещё один товар?");
            myTotal = calculatorObject.calculateMyTotal();
            //System.out.println(myTotal); //промежуточная проверка логики
            if(scan.hasNextLine()){
                if(scan.nextLine().equalsIgnoreCase("Завершить")){
                break;
                }
            }
        }
        System.out.println("Добавленные товары:"); // после Завершить вывожу все
        calculatorObject.showItems();


        myFormatter.printFormatResult(myTotal, allGuests);  ////

        }
    }

class Calculator {
    ArrayList<Item> itemsList = new ArrayList<>();
    //double totalSumIs = 0.0;-- лишнее, кажется, тк сохраняло постоянно старое значение и удваивало

    // проверяю все товары и суммирую
    public void addMyItem(String itemName, double itemPrice) {
        itemsList.add(new Item(itemName, itemPrice));
    }
    public double calculateMyTotal(){
        double totalSumIs=0.0;
        for (Item myItem : itemsList) {
            totalSumIs+=myItem.itemPrice;
        }
        return totalSumIs;
    }
    public void showItems(){
        for (Item myItem : itemsList) {
            System.out.println(myItem.itemName);
        }
    }
}
class MyFormatter {
    // double myTotalSum = 0.0; // надо ли поля эти класса вводить ? Убрал их в комменты
    // String myRubString = "";

    public void printFormatResult(double myTotal, int allGuests) {
        if ((Math.floor(myTotal / allGuests) >= 1.0) && (Math.floor(myTotal / allGuests) < 2)) {
            String myResult = "Счет на каждого: %.2f рубль";
            System.out.println(String.format(myResult, myTotal / allGuests));
        } else if ((Math.floor(myTotal / allGuests) >= 2) && (Math.floor(myTotal / allGuests) < 4.99)) {
            String myResult = "Счет на каждого: %.2f рубля";
            System.out.println(String.format(myResult, myTotal / allGuests));
        }
        else if((Math.floor(myTotal / allGuests) < 1) || (Math.floor(myTotal / allGuests) >= 5)){
            String myResult = "Счет на каждого: %.2f рублей";
            System.out.println(String.format(myResult, myTotal / allGuests));
        }
    }
}

class Item {
        String itemName;
        double itemPrice;

        Item(String itemName, double itemPrice) {
            this.itemName = itemName;
            this.itemPrice = itemPrice;
        }
}