package com.mayurj;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

public class ComparatorExamples {

    public static void main(String[] args) {
        /**
         * 1. Sort the strings based on their length in ascending order
         * 2. Sort the strings based on their length, if length is same sort based on alphabetical order consider case
         * 3. Sort the strings based on their length, ignore case sensitive, if length is same sort based on alphabetical order
         * 4. Sort the list of integers in descending order and print the result
         * 5. Sort Employee based on there age, if age is same then based on alphabatical order of name by ignoring case
         */

        List<String> fruits = Utils.getFruitList();

        /// 1. Sort the strings based on their length in ascending order
        System.out.println("Sort the strings based on their length in ascending order");
        fruits.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);

        fruits.sort(Comparator.comparing(String::length).thenComparing(String::compareToIgnoreCase));
        System.out.println("ignore case ::" + fruits);


        /// 2. Sort the strings based on their length, if length is same sort based on alphabetical order consider case
        String sortBasedOnLengthThenNameConsiderCase = fruits.stream()
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(Function.identity())
                )
                .collect(Collectors.joining(","));
        System.out.println("sort_Based_On_Length_Then_Name_Consider_Case :: " + sortBasedOnLengthThenNameConsiderCase);


        /// 3. Sort the strings based on their length, ignore case sensitive, if length is same sort based on alphabetical order
        String sortBasedOnLengthThenNameIgnoreCase = fruits.stream()
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(String::compareToIgnoreCase))
                .collect(Collectors.joining(","));

        System.out.println("sort_Based_On_Length_Then_Name_Ignore_Case :: " + sortBasedOnLengthThenNameIgnoreCase);

        ///  4. Sort the list of integers in descending order and print the result

        List<Integer> integerList = Utils.getIntegerList();
        System.out.println("Sort Integer Natural order");
        integerList.stream().sorted().forEach(System.out::print);
        System.out.println("Sort Integer reverse order");
        integerList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);



        List<Employee> employeeList = Utils.getEmployees();

        /// 5 Sort Employee based on there age, if age is same then based on alphabatical order of name by ignoring case
        employeeList.stream()
                .sorted(Comparator
                        .comparing(Employee::getAge)
                        .thenComparing(Employee::getName, String::compareToIgnoreCase)
                ).forEach(System.out::println);

        Map<Integer, String> numberMap = Utils.getNumberMap();

        numberMap.entrySet().stream().sorted(comparingByValue()).forEach(System.out::println);

        numberMap.entrySet().stream().sorted(comparingByKey()).forEach(System.out::println);
    }




}
