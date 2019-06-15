/*
 * DESCRIPTION
 * Create an employee class with name and age fields
 * Practise the following functional interfaces using
 * lambda expressions:
 * 1. Consumer
 * 2. Supplier
 * 3. Predicate
 * 4. Function
 * 5. UnaryOperator
 * 6. Bi-prefix
 * 7. Int, Double, ToInt, & ToDouble prefix
 */

package com.ablaze;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Mike", 22));
        employees.add(new Employee("John", 24));
        employees.add(new Employee("Chris", 19));
        employees.add(new Employee( "Sam", 45));
        employees.add(new Employee("David", 30));

        IntUnaryOperator twoTimes = num -> 2*num;
        System.out.println(twoTimes.applyAsInt(55));

    }
}

class Employee {
    private String name;
    private int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}