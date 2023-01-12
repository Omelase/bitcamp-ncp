package bitcamp.bootapp.dao;

import java.util.Arrays;
import bitcamp.bootapp.vo.Lecturer;

public class LecturerDao {
  private static final int SIZE = 100;

  private int lecturerNo;
  private int count;
  private Lecturer[] lecturers = new Lecturer[SIZE];

  public void insert(Lecturer lecturer) {
    lecturer.setLecturerNo(++lecturerNo);
    this.lecturers[this.count++] = lecturer;
  }

  public Lecturer[] findAll() {
    return Arrays.copyOf(lecturers, count);
  }

  public Lecturer findByNo(int lecturerNo) {
    for (int i = 0; i < this.count; i++) {
      if (this.lecturers[i].getLecturerNo() == lecturerNo) {
        return this.lecturers[i];
      }
    }
    return null;
  }

  public void update(Lecturer lecturer) {
    this.lecturers[this.indexOf(lecturer)] = lecturer;
  }

  public void delete(Lecturer lecturer) {
    for (int i = this.indexOf(lecturer) + 1; i < this.count; i++) {
      this.lecturers[i - 1] = this.lecturers[i];
    }
    this.lecturers[--this.count] = null; // 레퍼런스 카운트를 줄인다.
  }

  private int indexOf(Lecturer b) {
    for (int i = 0; i < this.count; i++) {
      if (this.lecturers[i].getLecturerNo() == b.getLecturerNo()) {
        return i;
      }
    }
    return -1;
  }
}







