package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class ComputerHistoryOfPassedCourses extends HistoryOfPassedCourses{
    public ComputerHistoryOfPassedCourses(Long id, Long studentId, Long courseId, float grade, boolean status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
        this.status = status;
    }
    public ComputerHistoryOfPassedCourses() {

    }

    @Override
    public String toString() {
        return "ComputerHistoryOfPassedCourses{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                ", status=" + status +
                '}';
    }
}
