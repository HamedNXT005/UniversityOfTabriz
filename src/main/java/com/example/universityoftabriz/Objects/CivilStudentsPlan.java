package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "civil_students_plan")
public class CivilStudentsPlan extends StudentPlan{
    public CivilStudentsPlan(Long id, Long studentId, Long courseId, float grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }
    public CivilStudentsPlan() {

    }

    @Override
    public String toString() {
        return "CivilStudentsPlan{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
