package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    @Id
    protected Long id;
    protected String user_name;
    protected String password;
    protected String faculty;
    protected String name_f;
    protected String name_l;
    protected String national_code;
    protected String phone_n;
    protected  String photo;
    protected boolean access;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getName_f() {
        return name_f;
    }

    public void setName_f(String name_f) {
        this.name_f = name_f;
    }

    public String getName_l() {
        return name_l;
    }

    public void setName_l(String name_l) {
        this.name_l = name_l;
    }

    public String getNational_code() {
        return national_code;
    }

    public void setNational_code(String national_code) {
        this.national_code = national_code;
    }

    public String getPhone_n() {
        return phone_n;
    }

    public void setPhone_n(String phone_n) {
        this.phone_n = phone_n;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isAccess() {
        return access;
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
