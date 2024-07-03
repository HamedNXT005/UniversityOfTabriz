package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mechanic_students_plan")
public class MechanicStudentsPlan extends StudentPlan{
    public MechanicStudentsPlan(Long id, Long studentId, Long courseId, float grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public MechanicStudentsPlan() {

    }

    @Override
    public String toString() {
        return "MechanicStudentsPlan{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
