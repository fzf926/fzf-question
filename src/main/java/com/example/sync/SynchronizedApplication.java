package com.example.sync;

import java.util.concurrent.locks.Lock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SynchronizedApplication {
    public static void main(String[] args) {
        SpringApplication.run(SynchronizedApplication.class, args);

    }

}
