package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task3 {

    public static void executeTask() {
        var employees = getListEmployee();
        System.out.println(employees);
        var nameAndDeparts = getNameWithDepartment(employees);
        System.out.println(nameAndDeparts);
    }

    private static List<String> getNameWithDepartment(ArrayList<Employee> employees) {
        return employees.stream()
                .map(x -> x.fullName.strip().split(" +")[1] + " - " + x.department)
                .toList();
    }

    private static ArrayList<Employee> getListEmployee() {
        var list = new ArrayList<Employee>();
        list.add(new Employee("A Bn C", 18, "A", 1.0));
        list.add(new Employee("  D  E  Fg  ", 111, "D", 2.0));
        list.add(new Employee("Gdg   H   I", 11037, "G", 3.0));
        list.add(new Employee("Jsdgsd Ksdgds Ldgs", 42, "J", 4.0));
        list.add(new Employee("M N O", 777, "A", 5.0));
        return list;
    }


    private static class Employee {
        private String fullName;
        private Integer age;
        private String department;
        private Double salary;

        public Employee(String fullName, Integer age, String department, Double salary) {
            this.fullName = fullName;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getFullName() {
            return fullName;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getDepartment() {
            return department;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "fullName:" + " " + fullName + ", " +
                    "age:" + " " + age +  ", " +
                    "department:" + " " + department +  ", " +
                    "salary:" + " " + salary;
        }
    }
}
