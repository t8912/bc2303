package com.codewave.demo;

public class DeliveryMan extends Thread{

  Company company;

  public DeliveryMan(Company company) {
    this.Company = company;
  }
}
