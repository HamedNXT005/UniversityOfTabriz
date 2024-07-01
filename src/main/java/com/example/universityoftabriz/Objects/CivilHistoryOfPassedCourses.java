package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "civil_history_of_passed_courses")
public class CivilHistoryOfPassedCourses extends HistoryOfPassedCourses{

    public CivilHistoryOfPassedCourses(Long id, Long student_id, Long course_id, float grade, boolean status) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
        this.status = status;
    }

    public CivilHistoryOfPassedCourses() {

    }

    @Override
    public String toString() {
        return "CivilHistoryOfPassedCourses{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                ", grade=" + grade +
                ", status=" + status +
                '}';
    }
}
