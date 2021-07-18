package com.ljh.entity;
import java.io.Serializable;
public class Student implements Serializable {
    private Integer id;
    private String student;
    private String order;
    private String employee;
    private String teacher;
    private String course;

    public Student(Integer id, String student, String order, String employee, String teacher, String course) {
        this.id = id;
        this.student = student;
        this.order = order;
        this.employee = employee;
        this.teacher = teacher;
        this.course = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student='" + student + '\'' +
                ", order='" + order + '\'' +
                ", employee='" + employee + '\'' +
                ", teacher='" + teacher + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
