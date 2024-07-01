package com.example.universityoftabriz.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "info_employee")
public class Employee extends Person{
    private String department;
    private String role;

    public Employee(Long id, String user_name, String password, String name_f, String name_l, String national_code, String phone_n, String photo, boolean access,String department, String role) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.name_f = name_f;
        this.name_l = name_l;
        this.national_code = national_code;
        this.phone_n = phone_n;
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
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", name_f='" + name_f + '\'' +
                ", name_l='" + name_l + '\'' +
                ", national_code='" + national_code + '\'' +
                ", phone_n='" + phone_n + '\'' +
                ", photo='" + photo + '\'' +
                ", access=" + access +
                '}';
    }
}
