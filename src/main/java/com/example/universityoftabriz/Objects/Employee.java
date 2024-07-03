package com.example.universityoftabriz.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_employee")
public class Employee extends Person{
    private String department;
    private String role;
    public Employee(Long id, String userName, String password, String nameF, String nameL, String nationalCode, String phoneN, String photo, boolean access,String department, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nameF = nameF;
        this.nameL = nameL;
        this.nationalCode = nationalCode;
        this.phoneN = phoneN;
        this.photo = photo;
        this.access = access;
        this.department = department;
        this.role = role;
    }

    public Employee() {

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "department='" + department + '\'' +
                ", role='" + role + '\'' +
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
