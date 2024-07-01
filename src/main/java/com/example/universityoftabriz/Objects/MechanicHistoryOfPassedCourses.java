package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mechanic_history_of_passed_courses")
public class MechanicHistoryOfPassedCourses extends HistoryOfPassedCourses{
    public MechanicHistoryOfPassedCourses(Long id, Long student_id, Long course_id, float grade, boolean status) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
        this.status = status;
    }
    public MechanicHistoryOfPassedCourses() {

    }

    @Override
    public String toString() {
        return "MechanicHistoryOfPassedCourses{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                ", grade=" + grade +
                ", status=" + status +
                '}';
    }
}
