package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "civil_history_of_passed_courses")
public class CivilHistoryOfPassedCourses extends HistoryOfPassedCourses{

    public CivilHistoryOfPassedCourses(Long id, Long studentId, Long courseId, float grade, boolean status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
        this.status = status;
    }
    public CivilHistoryOfPassedCourses() {

    }

    @Override
    public String toString() {
        return "CivilHistoryOfPassedCourses{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                ", status=" + status +
                '}';
    }
}
