package com.revature.model;

import java.util.List;
import java.util.Objects;

public class BankAdmin {
  private String username;
  private String account_num;
  private double balance;
  private List<Customer> customers;

  public BankAdmin() {
  }

  public BankAdmin(String username, String account_num, double balance) {
    this.username = username;
    this.account_num = account_num;
    this.balance = balance;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getAccount_num() {
    return account_num;
  }

  public void setAccount_num(String account_num) {
    this.account_num = account_num;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  public void setCustomers(List<Customer> customers) {
    this.customers = customers;
  }

  @Override
  public String toString() {
    return "BankAdmin{" +
            "username='" + username + '\'' +
            ", account_num='" + account_num + '\'' +
            ", balance=" + balance +
            ", customers=" + customers +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BankAdmin bankAdmin = (BankAdmin) o;
    return Double.compare(bankAdmin.balance, balance) == 0 && Objects.equals(username, bankAdmin.username) && Objects.equals(account_num, bankAdmin.account_num) && Objects.equals(customers, bankAdmin.customers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, account_num, balance, customers);
  }
}
