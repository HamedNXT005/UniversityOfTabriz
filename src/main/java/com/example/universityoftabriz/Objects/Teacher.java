package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_teachers")
public class Teacher extends Person{
    private String status;
    private String faculty;

    public Teacher(Long id, String user_name, String password, String faculty, String nameF, String nameL, String nationalCode, String phoneN,String status ,String photo, boolean access) {
        this.id = id;
        this.userName = user_name;
        this.password = password;
        this.faculty = faculty;
        this.nameF = nameF;
        this.nameL = nameL;
        this.nationalCode = nationalCode;
        this.phoneN = phoneN;
        this.status = status;
        this.photo = photo;
        this.access = access;
    }

    public Teacher() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "status='" + status + '\'' +
                ", faculty='" + faculty + '\'' +
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
