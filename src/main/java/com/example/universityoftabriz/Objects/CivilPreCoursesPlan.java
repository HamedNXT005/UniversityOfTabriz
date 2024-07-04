package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "civil_pre_courses_plan")
public class CivilPreCoursesPlan extends PreCoursesPlan{
    public CivilPreCoursesPlan(Long id, Long courseId, Long teacherId, int classN, Date examDate , boolean status) {
        this.id = id;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.classN = classN;
        this.examDate = examDate;
        this.status = status;
    }
    public CivilPreCoursesPlan() {

    }

    @Override
    public String toString() {
        return "CivilPreCoursesPlan{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", classN=" + classN +
                ", examDate=" + examDate +
                ", status=" + status +
                '}';
    }
}
