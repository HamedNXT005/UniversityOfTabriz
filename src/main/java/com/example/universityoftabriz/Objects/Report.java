package com.example.universityoftabriz.Objects;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Report {
    @Id
    protected Long id;
    @Column(name = "teacher_id")
    protected Long teacherId;
    @Column(name = "course_id")
    protected Long courseId;
    @Column(name = "attendency_status")
    protected boolean attendencyStatus;
    protected String absents;
    @Column(name = "date_of_submition")
    protected Date dateOfSubmition;
    @Column(name = "time_of_submition")
    protected Time timeOfSubmition;
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

    public boolean isAttendencyStatus() {
        return attendencyStatus;
    }

    public void setAttendencyStatus(boolean attendencyStatus) {
        this.attendencyStatus = attendencyStatus;
    }

    public String getAbsents() {
        return absents;
    }

    public void setAbsents(String absents) {
        this.absents = absents;
    }

    public Date getDateOfSubmition() {
        return dateOfSubmition;
    }

    public void setDateOfSubmition(Date dateOfSubmition) {
        this.dateOfSubmition = dateOfSubmition;
    }

    public Time getTimeOfSubmition() {
        return timeOfSubmition;
    }

    public void setTimeOfSubmition(Time timeOfSubmition) {
        this.timeOfSubmition = timeOfSubmition;
    }

}
