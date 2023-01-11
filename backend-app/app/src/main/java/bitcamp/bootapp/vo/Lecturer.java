package bitcamp.bootapp.vo;

// 회원 데이터를 담을 메모리를 설계한다.
public class Lecturer {
  private int lecturerNo;
  private String name;
  private String tel;
  private String eMail;
  private String degree;
  private String schoolName;
  private String major;
  private int hourlyWage;
  private String createdDate;

  public int getLecturerNo() {
    return lecturerNo;
  }
  public void setLecturerNo(int lecturerNo) {
    this.lecturerNo = lecturerNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String geteMail() {
    return eMail;
  }
  public void seteMail(String eMail) {
    this.eMail = eMail;
  }
  public String getDegree() {
    return degree;
  }
  public void setDegree(String degree) {
    this.degree = degree;
  }
  public String getSchoolName() {
    return schoolName;
  }
  public void setSchoolName(String schoolName) {
    this.schoolName = schoolName;
  }
  public String getMajor() {
    return major;
  }
  public void setMajor(String major) {
    this.major = major;
  }
  public int getHourlyWage() {
    return hourlyWage;
  }
  public void setHourlyWage(int hourlyWage) {
    this.hourlyWage = hourlyWage;
  }
  public String getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }


}
