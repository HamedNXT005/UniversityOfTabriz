package com.example.universityoftabriz.Objects;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DefinedCourses {
    @Id
    protected Long id;
    @Column(name = "teacher_id")
    protected Long teacherId;
    @Column(name = "course_id")
    protected Long courseId;
    @Column(name = "primary_day")
    protected Date primaryDay;
    @Column(name = "time_of_primary_day")
    protected Time timeOfPrimaryDay;
    @Column(name = "secondary_day")
    protected Date secondaryDay;
    @Column(name = "time_of_secondary_day")
    protected Time timeOfSecondaryDay;
    @Column(name = "class_n")
    protected int classN;
    @Column(name = "exam_date")
    protected Date examDate;
    protected int capacity;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getPrimaryDay() {
        return primaryDay;
    }

    public void setPrimaryDay(Date primaryDay) {
        this.primaryDay = primaryDay;
    }

    public Time getTimeOfPrimaryDay() {
        return timeOfPrimaryDay;
    }

    public void setTimeOfPrimaryDay(Time timeOfPrimaryDay) {
        this.timeOfPrimaryDay = timeOfPrimaryDay;
    }

    public Date getSecondaryDay() {
        return secondaryDay;
    }

    public void setSecondaryDay(Date secondaryDay) {
        this.secondaryDay = secondaryDay;
    }

    public Time getTimeOfSecondaryDay() {
        return timeOfSecondaryDay;
    }

    public void setTimeOfSecondaryDay(Time timeOfSecondaryDay) {
        this.timeOfSecondaryDay = timeOfSecondaryDay;
    }

    public int getClassN() {
        return classN;
    }

    public void setClassN(int classN) {
        this.classN = classN;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
