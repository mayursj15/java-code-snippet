package com.mayurj;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorsExample {

    public static void main(String[] args) {

        /**
         *
         * 1. create a map for city name and employee
         * 2. create a map for city name and employee id         *
         * 3. find highest paid employee and its city
         * 4. find lowest paid employee and its city
         * 5. lowest paid in any of the city
         * 6. Highest paid in any of the city
         * 7. Highest paid with small age
         * 8. Lowest paid with high age
         * 9. get max salary and min salary emp at the same time
         */

        ///1. create a map for city name and employee
        List<Employee> employeeList = Utils.getEmployees();
        Map<String, List<Employee>> empCityMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("empCityMap :: " + empCityMap);

        /// create a map for city name and employee id
        Map<String, List<String>> cityEmpNameMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("cityEmpNameMap :: " + cityEmpNameMap);

        /// find highest paid employee and its city
        Employee highestPaidEmployee = employeeList.stream().max(Comparator.comparing(Employee::getSalary)).orElse(new Employee());
        System.out.println("Highest paid employee us :: " + highestPaidEmployee);

        ///find lowest paid employee and its city
        Employee lowestPaidEmployee = employeeList.stream().min(Comparator.comparing(Employee::getSalary)).orElse(new Employee());
        System.out.println("Lowest paid employee :: " + lowestPaidEmployee);

        ///  lowest paid in paris
        Employee lowestPaidInParis = employeeList.stream().filter(e -> e.getCity().equalsIgnoreCase("paris")).min(Comparator.comparing(Employee::getSalary)).orElse(new Employee());
        System.out.println("lowestPaidInParis :: " + lowestPaidInParis);

        /// Highest paid with small age
        Employee highestPaidWithSmallAge = employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getAge).reversed()).orElse(new Employee());
        System.out.println("highestPaidWithSmallAge :: " + highestPaidWithSmallAge);

        ///  get max and min salary employee at the same time
        Map<String, Employee> maxAndMinEmp = employeeList.stream().collect(Collectors.teeing(
                Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                Collectors.minBy(Comparator.comparing(Employee::getSalary)),
                (x, y) -> {
                    Map<String, Employee> map = new HashMap<>();
                    map.put(x.get().getName(), x.get());
                    map.put(y.get().getName(), y.get());
                    return map;
                }
        ));

        System.out.println(" maxAndMinEmp :: " + maxAndMinEmp);

    }
}
