package com.gw.examples.hello;

import javax.enterprise.context.RequestScoped;

import static java.lang.String.format;

@RequestScoped
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return format("Hello %s!", name);
    }

}