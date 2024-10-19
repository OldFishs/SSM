package com.xxx.ioc_01;

//非静态工厂
public class DefaultServiceLocator {
    private static ClientServiceImpl clientService= new ClientServiceImpl();

    public ClientServiceImpl createClientServiceInstance() {
        return clientService;
    }
}
