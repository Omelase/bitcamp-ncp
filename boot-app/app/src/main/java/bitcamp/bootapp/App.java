package bitcamp.bootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
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

  static class Board {
    int no;
    String title;
    String writer;
    int viewCnt;

    public Board(int n, String t, String w, int v) {
      this.no = n;
      this.title = t;
      this.writer = w;
      this.viewCnt = v;
    }

    public int getNo() {
      return this.no;
    }

    public String getTitle() {
      return this.title;
    }

    public String getWriter() {
      return this.writer;
    }

    public int getViewCnt() {
      return this.viewCnt;
    }
  }

  @GetMapping("/boards") // 스프링부트 기본포트는 8080
  public Object boards() {
    Board[] arr = {
        new Board(1, "제목1", "홍길동1", 101),
        new Board(2, "제목2", "홍길동2", 102),
        new Board(3, "제목3", "홍길동3", 103),
        new Board(4, "제목4", "홍길동4", 104),
        new Board(5, "제목5", "홍길동5", 105)
    };
    return arr;
  }
}
