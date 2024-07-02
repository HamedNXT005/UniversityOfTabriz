package com.example.universityoftabriz.Objects;

import jakarta.persistence.Column;
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

    @Column(name = "unit_n")
    private int unitN;
    private long requirement;

    public Courses(Long id, String name, String faculty, String major, int unitN, long requirement) {
        this.id = id;
        this.name = name;
        this.faculty = faculty;
        this.major = major;
        this.unitN = unitN;
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

    public int getUnitN() {
        return unitN;
    }

    public void setUnitN(int unitN) {
        this.unitN = unitN;
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
                ", unitN=" + unitN +
                ", requirement=" + requirement +
                '}';
    }
}
