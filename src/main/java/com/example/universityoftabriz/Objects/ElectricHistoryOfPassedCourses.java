package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "electric_history_of_passed_courses")
public class ElectricHistoryOfPassedCourses extends HistoryOfPassedCourses{
    public ElectricHistoryOfPassedCourses(Long id, Long studentId, Long courseId, float grade, boolean status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
        this.status = status;
    }
    public ElectricHistoryOfPassedCourses() {

    }

    @Override
    public String toString() {
        return "ElectricHistoryOfPassedCourses{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                ", status=" + status +
                '}';
    }
}
