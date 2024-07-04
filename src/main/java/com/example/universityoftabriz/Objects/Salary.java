package com.example.universityoftabriz.Objects;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Salary {
    @Id
    protected Long id;
    @Column (name = "user_id")
    protected Long userId;

    @Column(name = "hours_taught")
    protected int hoursTaught;
    @Column (name = "year_ed")
    protected int yearEd;
    protected int semester;
    protected Long salary;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getHoursTaught() {
        return hoursTaught;
    }

    public void setHoursTaught(int hoursTaught) {
        this.hoursTaught = hoursTaught;
    }

    public int getYearEd() {
        return yearEd;
    }

    public void setYearEd(int yearEd) {
        this.yearEd = yearEd;
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
