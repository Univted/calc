package com.company;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int num1, num2;
    static char operation;
    static int result;

    public static void main (String[] args) {
        System.out.println("Введите выражение по типу:[1+1] или два римских числа от I до X по типу:[III+V] + Enter ");
        String userInp = sc.nextLine();
        char[] under_char = new char[10];
        for (int k = 0; k < userInp.length(); k++) {
            under_char[k] = userInp.charAt(k);
            if (under_char[k] == '+') {
                operation = '+';
            }
            if (under_char[k] == '-') {
                operation = '-';
            }
            if (under_char[k] == '*') {
                operation = '*';
            }
            if (under_char[k] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        num1 = romanToNumber(stable00);
        num2 = romanToNumber(string03);
        if (num1 < 0 && num2 < 0) {
            result = 0;
        } else {
              result = calculated(num1, num2, operation);
            System.out.println("---Результат для римских цифр----");
            String resultRoman = convertNumberToRoman(result);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        num1 = Integer.parseInt(stable00);
        num2 = Integer.parseInt(string03);
        result = calculated(num1, num2, operation);
        System.out.println("--Результат для арабских цифр----");
        System.out.println(num1 + " " + operation + " " + num2 + " = " + result);
    }

    private static String convertNumberToRoman (int numberArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numberArabian];
        return s;
    }


    private static int romanToNumber (String Roman) {
        try {
            if (Roman.equals("I")) {
                return 1;
            } else if (Roman.equals("II")) {
                return 2;
            } else if (Roman.equals("III")) {
                return 3;
            } else if (Roman.equals("IV")) {
                return 4;
            } else if (Roman.equals("V")) {
                return 5;
            } else if (Roman.equals("VI")) {
                return 6;
            } else if (Roman.equals("VII")) {
                return 7;
            } else if (Roman.equals("VIII")) {
                return 8;
            } else if (Roman.equals("IX")) {
                return 9;
            } else if (Roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неправильный формат данных");
        }
        return -1;
    }

    public static int calculated (int number1, int number2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = number1 + number2;
                break;
            case '-':
                result = number1 - number2;
                break;
            case '*':
                result = number1 * number2;
                break;
            case '/':
                try {
                    result = number1 / number2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}