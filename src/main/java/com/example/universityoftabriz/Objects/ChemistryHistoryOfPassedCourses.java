package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "chemistry_history_of_passed_courses")
public class ChemistryHistoryOfPassedCourses extends HistoryOfPassedCourses{

    public ChemistryHistoryOfPassedCourses(Long id, Long studentId, Long courseId, float grade, boolean status) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
        this.status = status;
    }
    public ChemistryHistoryOfPassedCourses() {

    }

    @Override
    public String toString() {
        return "ChemistryHistoryOfPassedCourses{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                ", status=" + status +
                '}';
    }
}
