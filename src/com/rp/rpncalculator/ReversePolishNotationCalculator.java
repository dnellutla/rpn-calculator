package com.rp.rpncalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Stack;
import java.util.function.BiFunction;

public class ReversePolishNotationCalculator implements Runnable {

    static int quit = 0;
    static Stack<BigDecimal> numbers = new Stack<>();

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println(
                "***************************Reverse Polish Calculator*******" + "\n" + "**********Supports arithmetic operations in a calculator***********"
                        + "\n" + "**********Give input one by one by pressing the return key like for example " + "\n" + ">1" + "\n" + " 1 " + "\n" + ">21 "
                        + "\n" + "2 " + "\n" + "+ " + "\n" + "3 " + "\n" + "\n Press 'Q' key to exit from the application *******");

        Thread t = new Thread(new ReversePolishNotationCalculator());
        t.start();

        while (true) {
            t.sleep(10);
            if (quit == 1)
                break;
        }

    }

    public static void calc(String input) {
        Arrays.asList(input.split(" ")).stream().forEach(number -> {
            switch (input) {
            case "+":
                System.out.println("doing addition");
                calculate(numbers, (n1, n2) -> n2.add(n1));
                break;
            case "-":
                System.out.println("doing subtraction");
                calculate(numbers, (n1, n2) -> n2.subtract(n1));
                break;
            case "*":
                System.out.println("doing multiplication");
                calculate(numbers, (n1, n2) -> n2.multiply(n1));
                break;
            case "/":
                System.out.println("doing division");
                calculate(numbers, (n1, n2) -> n2.divide(n1));
                break;
            default:
                if (input.matches("\\d+")) {
                    numbers.push(new BigDecimal(input));
                } else {
                    System.out.println(
                            "You have entered an invalid string, please enter any number or any arithmetic operator such as +,-,*,/, No other operators/strings are allowed");
                    System.out.println("find:" + numbers.isEmpty());
                }
            }
        });

    }

    protected static Stack<BigDecimal> calculate(Stack<BigDecimal> numbers, BiFunction<BigDecimal, BigDecimal, BigDecimal> operation) {
        try {
            BigDecimal result = operation.apply(numbers.pop(), numbers.pop());
            System.out.println("result:" + result);
            numbers.push(result);
        } catch (ArithmeticException ae) {
            if (ae.getMessage().equalsIgnoreCase("Division by zero")) {
                System.out.println(" Number cannot be divided by zero, Continue by entering a valid number");
            }
        }
        return numbers;

    }

    @Override
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String msg = null;
        while (true) {
            try {
                msg = in.readLine();
                calc(msg);
            } catch (Exception e) {}

            if (msg.equals("Q")) {
                quit = 1;
                break;
            }
        }
    }

}
