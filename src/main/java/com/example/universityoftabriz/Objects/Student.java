package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_students")
public class Student extends Person{
    private String faculty;
    private String major;
    private int semesters_passed;
    private int units_passed;
    private float gpa_total;
    private float gpa_semester;

    public Student(Long id, String major, int semesters_passed, int units_passed, float gpa_total, float gpa_semester, String user_name, String password, String faculty, String name_f, String name_l, String national_code, String phone_n, String photo, boolean access) {
        this.id = id;
        this.major = major;
        this.semesters_passed = semesters_passed;
        this.units_passed = units_passed;
        this.gpa_total = gpa_total;
        this.gpa_semester = gpa_semester;
        this.user_name = user_name;
        this.password = password;
        this.faculty = faculty;
        this.name_f = name_f;
        this.name_l = name_l;
        this.national_code = national_code;
        this.phone_n = phone_n;
        this.photo = photo;
        this.access = access;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemesters_passed() {
        return semesters_passed;
    }

    public void setSemesters_passed(int semesters_passed) {
        this.semesters_passed = semesters_passed;
    }

    public int getUnits_passed() {
        return units_passed;
    }

    public void setUnits_passed(int units_passed) {
        this.units_passed = units_passed;
    }

    public float getGpa_total() {
        return gpa_total;
    }

    public void setGpa_total(float gpa_total) {
        this.gpa_total = gpa_total;
    }

    public float getGpa_semester() {
        return gpa_semester;
    }

    public void setGpa_semester(float gpa_semester) {
        this.gpa_semester = gpa_semester;
    }
    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", major='" + major + '\'' +
                ", semesters_passed=" + semesters_passed +
                ", units_passed=" + units_passed +
                ", gpa_total=" + gpa_total +
                ", gpa_semester=" + gpa_semester +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", faculty='" + faculty + '\'' +
                ", name_f='" + name_f + '\'' +
                ", name_l='" + name_l + '\'' +
                ", national_code='" + national_code + '\'' +
                ", phone_n='" + phone_n + '\'' +
                ", photo='" + photo + '\'' +
                ", access=" + access +
                '}';
    }
}
