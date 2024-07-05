package com.example.universityoftabriz.Objects;

import com.example.universityoftabriz.Services.ComputerDefinedCoursesService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "info_students")
public class Student extends Person{
    private String faculty;
    private String major;
    @Column(name = "semesters_passed")
    private int semestersPassed;
    @Column(name = "units_passed")
    private int unitsPassed;
    @Column(name = "gpa_total")
    private float gpaTotal;
    @Column(name = "gpa_semester")
    private float gpaSemester;
    public Student(Long id, String major, int semestersPassed, int unitsPassed, float gpaTotal, float gpaSemester, String userName, String password, String faculty, String nameF, String nameL, String nationalCode, String phoneN, String photo, boolean access) {
        this.id = id;
        this.major = major;
        this.semestersPassed = semestersPassed;
        this.unitsPassed = unitsPassed;
        this.gpaTotal = gpaTotal;
        this.gpaSemester = gpaSemester;
        this.userName = userName;
        this.password = password;
        this.faculty = faculty;
        this.nameF = nameF;
        this.nameL = nameL;
        this.nationalCode = nationalCode;
        this.phoneN = phoneN;
        this.photo = photo;
        this.access = access;
    }

    public Student() {

    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemestersPassed() {
        return semestersPassed;
    }

    public void setSemestersPassed(int semestersPassed) {
        this.semestersPassed = semestersPassed;
    }

    public int getUnitsPassed() {
        return unitsPassed;
    }

    public void setUnitsPassed(int unitsPassed) {
        this.unitsPassed = unitsPassed;
    }

    public float getGpaTotal() {
        return gpaTotal;
    }

    public void setGpaTotal(float gpaTotal) {
        this.gpaTotal = gpaTotal;
    }

    public float getGpaSemester() {
        return gpaSemester;
    }

    public void setGpaSemester(float gpaSemester) {
        this.gpaSemester = gpaSemester;
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
                "faculty='" + faculty + '\'' +
                ", major='" + major + '\'' +
                ", semestersPassed=" + semestersPassed +
                ", unitsPassed=" + unitsPassed +
                ", gpaTotal=" + gpaTotal +
                ", gpaSemester=" + gpaSemester +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nameF='" + nameF + '\'' +
                ", nameL='" + nameL + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", phoneN='" + phoneN + '\'' +
                ", photo='" + photo + '\'' +
                ", access=" + access +
                '}';
    }
}
