package com.thoughtworks.capability.demospringioccontainer;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public GreetingService() {
        System.out.println("GreetingService instance created");
    }

    String sayHi() {
        return "hello world";
    }
}
