package com.mayurj;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Utils {

    public static List<Employee> getEmployees() {
        Employee e1 = Employee.builder().age(25).name("john").salary(10000.0).city("newyork").build();
        Employee e2 = Employee.builder().age(35).name("julie").salary(30000.0).city("newyork").build();
        Employee e3 = Employee.builder().age(45).name("Sarah").salary(50000.0).city("paris").build();
        Employee e4 = Employee.builder().age(45).name("james").salary(5000.0).city("newyork").build();
        Employee e5 = Employee.builder().age(55).name("paul").salary(100000.0).city("paris").build();
        Employee e6 = Employee.builder().age(34).name("adam").salary(10000.0).city("newyork").build();
        return Arrays.asList(e1, e2, e3, e4, e5, e6);
    }

    public static List<Integer> getIntegerList() {
        return Arrays.asList(1, 3, 4, 2, 6, 9, 7, 8);
    }

    public static List<String> getFruitList() {
        return Arrays.asList("apple", "APPLE", "cherry", "banana", "baNaNa", "pineapple", "KiWI", "elderberry");
    }

    public static Map<Integer, String> getNumberMap() {

        return Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five");
    }

}
