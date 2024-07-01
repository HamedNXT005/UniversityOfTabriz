package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Courses {
    @Id
    private Long id;
    private String name;
    private String faculty;
    private String major;
    private int unit_n;
    private long requirement;

    public Courses(Long id, String name, String faculty, String major, int unit_n, long requirement) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.major = major;
        this.unit_n = unit_n;
        this.requirement = requirement;
    }
    public Courses() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getUnit_n() {
        return unit_n;
    }

    public void setUnit_n(int unit_n) {
        this.unit_n = unit_n;
    }

    public long getRequirement() {
        return requirement;
    }

    public void setRequirement(long requirement) {
        this.requirement = requirement;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", faculty='" + faculty + '\'' +
                ", major='" + major + '\'' +
                ", unit_n=" + unit_n +
                ", requirement=" + requirement +
                '}';
    }
}
