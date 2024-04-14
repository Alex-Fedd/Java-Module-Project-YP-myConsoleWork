package org.example;

class MyFormatter {
    public void printFormatResult(double myTotal, int allGuests) {
        double sumResult = myTotal / allGuests;
        int endNumber = (int) sumResult % 10;
        if ((Math.floor(sumResult) >= 1.0) && (Math.floor(sumResult) < 2)) {
            String myResult = "Счет на каждого: %.2f рубль";
            System.out.printf(myResult, sumResult);
        } else if ((Math.floor(sumResult) >= 2) && (Math.floor(sumResult) < 4.99)) {
            String myResult = "Счет на каждого: %.2f рубля";
            System.out.printf(myResult, sumResult);
        } else if ((Math.floor(sumResult) < 1) || ((Math.floor(sumResult) >= 5.0) && (Math.floor(sumResult) < 20.99))) {
            String myResult = "Счет на каждого: %.2f рублей";
            System.out.printf(myResult, sumResult);
        } else if (Math.floor(sumResult) >= 21) {
            if (endNumber >= 2 && endNumber <= 4) {
                String myResult = "Счет на каждого: %.2f рубля";
                System.out.printf(myResult, sumResult);
            } else if (endNumber == 1) {
                String myResult = "Счет на каждого: %.2f рубль";
                System.out.printf(myResult, sumResult);
            } else if (endNumber >= 5 && endNumber <= 9) {
                String myResult = "Счет на каждого: %.2f рублей";
                System.out.printf(myResult, sumResult);
            }
        }
    }
}