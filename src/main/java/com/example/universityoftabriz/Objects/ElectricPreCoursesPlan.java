package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "electric_pre_courses_plan")
public class ElectricPreCoursesPlan extends PreCoursesPlan{
    public ElectricPreCoursesPlan(Long id, Long courseId, Long teacherId, int classN, Date examDate , boolean status) {
        this.id = id;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.classN = classN;
        this.examDate = examDate;
        this.status = status;
    }
    public ElectricPreCoursesPlan() {

    }

    @Override
    public String toString() {
        return "ElectricPreCoursesPlan{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", classN=" + classN +
                ", examDate=" + examDate +
                ", status=" + status +
                '}';
    }
}
