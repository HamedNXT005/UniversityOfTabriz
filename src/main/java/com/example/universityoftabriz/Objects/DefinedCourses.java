package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.sql.Time;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DefinedCourses {
    @Id
    protected Long id;
    protected Long teacher_id;
    protected Long course_id;
    protected Date primary_day;
    protected Time time_of_primary_day;
    protected Date secondary_day;
    protected Time time_of_secondary_day;
    protected int class_n;
    protected Date exam_date;
    protected int capacity;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Long course_id) {
        this.course_id = course_id;
    }

    public Date getPrimary_day() {
        return primary_day;
    }

    public void setPrimary_day(Date primary_day) {
        this.primary_day = primary_day;
    }

    public Time getTime_of_primary_day() {
        return time_of_primary_day;
    }

    public void setTime_of_primary_day(Time time_of_primary_day) {
        this.time_of_primary_day = time_of_primary_day;
    }

    public Date getSecondary_day() {
        return secondary_day;
    }

    public void setSecondary_day(Date secondary_day) {
        this.secondary_day = secondary_day;
    }

    public Time getTime_of_secondary_day() {
        return time_of_secondary_day;
    }

    public void setTime_of_secondary_day(Time time_of_secondary_day) {
        this.time_of_secondary_day = time_of_secondary_day;
    }

    public int getClass_n() {
        return class_n;
    }

    public void setClass_n(int class_n) {
        this.class_n = class_n;
    }

    public Date getExam_date() {
        return exam_date;
    }

    public void setExam_date(Date exam_date) {
        this.exam_date = exam_date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
