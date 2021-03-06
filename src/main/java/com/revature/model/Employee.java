package com.revature.model;

import java.util.List;
import java.util.Objects;

public class Employee {
private String firstname;
private String lastname;
private int employee_id;
private List<Customer> customers;
private List<Employee> employees;

    public Employee(String firstname, String lastname, int employee_Id) {
    }

    public Employee(String firstname, String lastname, int employee_id, List<Customer> customers, List<Employee> employees) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.employee_id = employee_id;
        this.customers = customers;
        this.employees = employees;
    }

    public Employee() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", employee_id=" + employee_id +
                ", customers=" + customers +
                ", employees=" + employees +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employee_id == employee.employee_id && Objects.equals(firstname, employee.firstname) && Objects.equals(lastname, employee.lastname) && Objects.equals(customers, employee.customers) && Objects.equals(employees, employee.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, employee_id, customers, employees);
    }
}
