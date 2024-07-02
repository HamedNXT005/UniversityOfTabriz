package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Salary {
    @Id
    protected Long id;
    protected Long user_id;
    protected int hours_taught;
    protected Date year_ed;
    protected int semester;
    protected Long salary;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public int getHours_taught() {
        return hours_taught;
    }

    public void setHours_taught(int hours_taught) {
        this.hours_taught = hours_taught;
    }

    public Date getYear_ed() {
        return year_ed;
    }

    public void setYear_ed(Date year_ed) {
        this.year_ed = year_ed;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
