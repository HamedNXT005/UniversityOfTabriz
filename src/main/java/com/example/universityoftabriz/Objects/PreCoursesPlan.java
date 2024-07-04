package com.example.universityoftabriz.Objects;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PreCoursesPlan {
    @Id
    protected Long id;
    @Column(name = "course_id")
    protected Long courseId;
    @Column(name = "teacher_id")
    protected Long teacherId;
    @Column(name = "class_n")
    protected int classN;
    @Column(name = "exam_date")
    protected Date examDate;
    protected boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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
}
