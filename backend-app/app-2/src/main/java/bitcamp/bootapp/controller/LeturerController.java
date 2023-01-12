package bitcamp.bootapp.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.LecturerDao;
import bitcamp.bootapp.vo.Lecturer;

@CrossOrigin(origins = {"http://127.0.0.1:5500", "http://localhost:5500"})
@RestController
public class LeturerController {

  LecturerDao lecturerDao = new LecturerDao();

  @PostMapping("/lecturers")
  public Object addLecturer(
      Lecturer lecturer
      ) {
    lecturer.setName(lecturer.getName());
    lecturer.setTel(lecturer.getTel());
    lecturer.seteMail(lecturer.geteMail());
    lecturer.setDegree(lecturer.getDegree());
    lecturer.setSchoolName(lecturer.getSchoolName());
    lecturer.setMajor(lecturer.getMajor());
    lecturer.setHourlyWage(lecturer.getHourlyWage());
    lecturer.setCreatedDate(new Date(System.currentTimeMillis()).toString());

    this.lecturerDao.insert(lecturer);

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");

    return contentMap;
  }


  @GetMapping("/lecturers")
  public Object getLecturers() {

    Lecturer[] lecturers = this.lecturerDao.findAll();

    Map<String,Object> contentMap = new HashMap<>();
    contentMap.put("status", "success");
    contentMap.put("data", lecturers);


    return contentMap;
  }


  @GetMapping("/lecturers/{lecturerNo}")
  public Object getLecturer(@PathVariable int lecturerNo) {

    Lecturer l = this.lecturerDao.findByNo(lecturerNo);

    Map<String,Object> contentMap = new HashMap<>();

    if (l == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "해당 번호의 강사가 없습니다.");
    } else {
      contentMap.put("status", "success");
      contentMap.put("data", l);
    }

    return contentMap;
  }

  @PutMapping("/lecturers/{lecturerNo}")
  public Object updateLecturer(
      Lecturer lecturer) {

    Map<String,Object> contentMap = new HashMap<>();

    Lecturer old = this.lecturerDao.findByNo(lecturer.getLecturerNo());
    if (old == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "강사가 없습니다.");
      return contentMap;
    }

    lecturer.setCreatedDate(old.getCreatedDate());

    this.lecturerDao.update(lecturer);

    contentMap.put("status", "success");

    return contentMap;
  }


  @DeleteMapping("/lecturers/{lecturerNo}")
  public Object deleteLecturer(
      @PathVariable int lecturerNo
      ) {

    Lecturer l = this.lecturerDao.findByNo(lecturerNo);

    Map<String,Object> contentMap = new HashMap<>();

    if (l == null) {
      contentMap.put("status", "failure");
      contentMap.put("data", "강사가 없습니다.");

    } else {
      this.lecturerDao.delete(l);
      contentMap.put("status", "success");
    }

    return contentMap;
  }

}
