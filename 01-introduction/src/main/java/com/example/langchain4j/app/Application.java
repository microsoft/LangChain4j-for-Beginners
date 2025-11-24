package com.example.langchain4j.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Entry point for the Getting Started module.  This simple Spring Boot
 * application exposes a chat endpoint backed by Azure OpenAI via OpenAI Official client.
 * LangChain4j.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.example.langchain4j")
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}