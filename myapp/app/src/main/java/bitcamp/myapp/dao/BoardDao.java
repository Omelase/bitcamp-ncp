package bitcamp.myapp.dao;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import bitcamp.myapp.vo.Board;

public class BoardDao {

  // 특정 클래스를 지정하기 보다는
  // 인터페이스를 통해 관계를 느슨하게 만든다.
  List<Board> list;

  public BoardDao(List<Board> list) {
    // List 규칙에 따라서 만든 객체를 외부에서 주입받는다.
    // 이렇게 하면 이 클래스는 ArrayList 또는 LinkedList와 같은
    // 특정 클래스와 관계가 없어진다.
    this.list = list;
  }

  int lastNo;

  public void insert(Board board) {
    board.setNo(++lastNo);
    board.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    list.add(board);
  }

  public Board[] findAll() {
    Board[] boards = new Board[list.size()];
    Iterator<Board> i = list.iterator();
    int index = 0;
    while (i.hasNext()) {
      boards[index++] = i.next();
    }
    return boards;
  }

  public Board findByNo(int no) {
    Board b = new Board();
    b.setNo(no);

    int index = list.indexOf(b);
    if (index == -1) {
      return null;
    }

    return list.get(index);
  }

  public void update(Board b) {
    int index = list.indexOf(b);
    list.set(index, b);
  }

  public boolean delete(Board b) {
    return list.remove(b);
  }

  public void save(String filename) {
    try (FileWriter out = new FileWriter(filename)) {
      for (Board b : list) {
        out.write(String.format("%d,%s,%s,%s,%d,%s\n",
            b.getNo(),
            b.getTitle(),
            b.getContent(),
            b.getPassword(),
            b.getViewCount(),
            b.getCreatedDate()));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  public void load(String filename) {
    if (list.size() > 0) {
      return;
    }

    try (Scanner in = new Scanner(new FileReader(filename))) {

      while (true) {
        try {
          String[] values = in.nextLine().split(",");
          Board b = new Board();
          b.setNo(Integer.parseInt(values[0]));
          b.setTitle(values[1]);
          b.setContent(values[2]);
          b.setPassword(values[3]);
          b.setViewCount(Integer.parseInt(values[4]));
          b.setCreatedDate(values[5]);
          list.add(b);
        } catch (Exception e) {
          break;
        }
      }

      if (list.size() > 0) {
        lastNo = list.get(list.size() -1).getNo();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}























