package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan({"com.example.controller","com.example.service"})
@EntityScan("com.example.entity")
class Demo1ApplicationTests {

    @Test
    void contextLoads() {
    }

}
