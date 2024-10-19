package com.xxx.ioc_01;

public class ClientService {
  private static ClientService clientService = new ClientService();
  private ClientService() {}

//  静态工厂
  public static ClientService createInstance() {

    return clientService;
  }
}