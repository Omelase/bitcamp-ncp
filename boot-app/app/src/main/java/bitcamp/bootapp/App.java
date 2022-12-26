package bitcamp.bootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class App {
  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @GetMapping("/hello") // 스프링부트 기본포트는 8080
  public String hello() {
    return "Hello, world!";
  }
}