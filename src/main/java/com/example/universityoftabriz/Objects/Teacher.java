package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_teachers")
public class Teacher extends Person{
    private String status;
    private String faculty;


    public Teacher(Long id, String user_name, String password, String faculty, String name_f, String name_l, String national_code, String phone_n,String status ,String photo, boolean access) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.faculty = faculty;
        this.name_f = name_f;
        this.name_l = name_l;
        this.national_code = national_code;
        this.phone_n = phone_n;
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
                ", id=" + id +
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
