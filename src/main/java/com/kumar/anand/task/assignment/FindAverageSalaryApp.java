package com.kumar.anand.task.assignment;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAverageSalaryApp {
    public void findAverageSalary(List<Employee> employees){
        //Write your logic here
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getOfficeLocation))
                .entrySet().parallelStream()
                .forEach(locationEntry -> {
                    Map<String, Double> avgSalaryByDesignation =
                            locationEntry.getValue().stream()
                                    .collect(Collectors.groupingBy(Employee::getDesignation,
                                            Collectors.averagingDouble(Employee::getSalary)));
                    avgSalaryByDesignation.forEach((designation, avgSalary) ->
                            System.out.printf("%s --> %s --> %.2f%n",
                                    locationEntry.getKey(), designation, avgSalary));
                });
    }
}
