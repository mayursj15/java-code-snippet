package com.mayurj;


import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee {
    private String name;
    private int age;
    private double salary;
    private String city;
}
