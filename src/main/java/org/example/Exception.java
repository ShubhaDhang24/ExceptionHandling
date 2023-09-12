package org.example;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {
        System.out.println("Exception Handling");
        try{
            ex4();

        }catch (RuntimeException r)
        {r.getStackTrace();} catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void ex1() {
        while (true) {
            System.out.print("Enter a number : ");
            try {
                Scanner scanner = new Scanner(System.in);
                int number = Integer.parseInt(scanner.nextLine());//scanner.nextInt();
                if(number<=0)
                {
                    System.out.println("Enter a positive number ");
                }
                else
                 System.out.println("Entered number is " + number);

            } catch (NumberFormatException e) {
                System.out.println("Number is not valid");
            }
        }
    }
    public static void ex2() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter your birthdate : ");
            try {
                LocalDate birthdate = LocalDate.parse(scanner.nextLine());
                System.out.println(birthdate.plusYears(1));
            } catch (DateTimeParseException d) {
                System.out.println("Enter valid date format YYYY-MM-DD");
            }
        }
    }
    public static void ex3()
    {
        int number1,number2;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter number : ");
        number1=scanner.nextInt();
        System.out.println("Enter second number : ");
        number2=scanner.nextInt();
        try {
            int total = number1 / number2;
            System.out.println("division is " + total);
        }
        catch (ArithmeticException a)
        {
            System.out.println("cannot divide a number by zero ");
        }
    }
    public static void ex4() throws IOException {
        try {
            Path filePath = Paths.get("dir/Details.txt");
            BufferedReader bufferedReader = Files.newBufferedReader(filePath);
            List<String> names = bufferedReader.lines().toList();
            names.forEach(System.out::println);
        }
        catch (IOException e)
        {
            System.out.println("File not found exception");
        }
    }
}