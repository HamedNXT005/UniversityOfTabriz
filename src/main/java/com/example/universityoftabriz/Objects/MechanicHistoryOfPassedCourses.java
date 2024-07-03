package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mechanic_history_of_passed_courses")
public class MechanicHistoryOfPassedCourses extends HistoryOfPassedCourses{
    public MechanicHistoryOfPassedCourses(Long id, Long studentId, Long courseId, float grade, boolean status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
        this.status = status;
    }
    public MechanicHistoryOfPassedCourses() {

    }

    @Override
    public String toString() {
        return "MechanicHistoryOfPassedCourses{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                ", status=" + status +
                '}';
    }
}
