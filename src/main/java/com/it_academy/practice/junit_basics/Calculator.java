package com.it_academy.practice.junit_basics;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private ArrayList<Integer> paramList;

    public Calculator(int... param) {
        paramList = new ArrayList<>();
        for (int i = 0; i < param.length; i++) {
            paramList.add(param[i]);
        }
    }

    public ArrayList<Integer> getParamList() {
        return paramList;
    }

    public float calculate(char operation) {
        int result = paramList.get(0);
        if (paramList.size() < 2) return 0;

        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                for (int i = 1; i < paramList.size(); i++) {
                    result = result - paramList.get(i);
                }
                return result;
            }
            case '+': {
                for (int i = 1; i < paramList.size(); i++) {
                    result = result + paramList.get(i);
                }
                return result;
            }
            case '/': {
                try {
                    for (int i = 1; i < paramList.size(); i++) {
                        result = result / paramList.get(i);
                    }
                    return result;
                } catch (ArithmeticException e) {
                    System.out.println("Error: "+e.getMessage());;
                }
            }
            case '*': {
                for (int i = 1; i < paramList.size(); i++) {
                    result = result * paramList.get(i);
                }
                return result;
            }
            case '^': {
                result = (int) Math.pow(paramList.get(0), paramList.get(1));
                return result;
            }
            case 'q': {
                result = (int) Math.pow(paramList.get(0), 1 / (double) paramList.get(1));
                return result;
            }
        }
    }

    public static int[] inputNeededParameters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество параметров: ");
        int numberOfParameters = scanner.nextInt();
        System.out.println("Ведите " + numberOfParameters + " параметров:");
        int[] paramArray = new int[numberOfParameters];
        int a = 0;
        while (a < numberOfParameters) {
            try {
                int param = scanner.nextInt();
                paramArray[a] = param;
            } catch (Exception e) {
                System.out.println(e);
                break;
            }
            a++;
        }
        return paramArray;
    }
}
