package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import java.sql.Time;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Report {
    @Id
    protected Long id;

    protected Long teacher_id;

    protected Long course_id;
    protected boolean attendency_status;
    protected String absents;
    protected Date date_of_submition;
    protected Time time_of_submition;
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

    public boolean isAttendency_status() {
        return attendency_status;
    }

    public void setAttendency_status(boolean attendency_status) {
        this.attendency_status = attendency_status;
    }

    public String getAbsents() {
        return absents;
    }

    public void setAbsents(String absents) {
        this.absents = absents;
    }

    public Date getDate_of_submition() {
        return date_of_submition;
    }

    public void setDate_of_submition(Date date_of_submition) {
        this.date_of_submition = date_of_submition;
    }

    public Time getTime_of_submition() {
        return time_of_submition;
    }

    public void setTime_of_submition(Time time_of_submition) {
        this.time_of_submition = time_of_submition;
    }

}
