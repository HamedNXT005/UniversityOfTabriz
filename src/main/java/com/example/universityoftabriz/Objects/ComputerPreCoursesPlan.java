package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "computer_pre_courses_plan")
public class ComputerPreCoursesPlan extends PreCoursesPlan{
    public ComputerPreCoursesPlan(Long id, Long courseId, Long teacherId, int classN, Date examDate , boolean status) {
        this.id = id;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.classN = classN;
        this.examDate = examDate;
        this.status = status;
    }
    public ComputerPreCoursesPlan() {

    }

    @Override
    public String toString() {
        return "ComputerPreCoursesPlan{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", teacherId=" + teacherId +
                ", classN=" + classN +
                ", examDate=" + examDate +
                ", status=" + status +
                '}';
    }
}
