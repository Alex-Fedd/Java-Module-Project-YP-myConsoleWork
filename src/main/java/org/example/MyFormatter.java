package org.example;

class MyFormatter {
    public void printFormatResult(double myTotal, int allGuests) {
        double sumResult = myTotal / allGuests;
        if ((Math.floor(sumResult) >= 1.0) && (Math.floor(sumResult) < 2)) {
            String myResult = "Счет на каждого: %.2f рубль";
            System.out.printf(myResult, sumResult);
        } else if ((Math.floor(sumResult) >= 2) && (Math.floor(sumResult) < 4.99)) {
            String myResult = "Счет на каждого: %.2f рубля";
            System.out.printf(myResult, sumResult);
        } else if ((Math.floor(sumResult) < 1) || (Math.floor(sumResult) >= 5)) {
            String myResult = "Счет на каждого: %.2f рублей";
            System.out.printf(myResult, sumResult);
        }
    }
}