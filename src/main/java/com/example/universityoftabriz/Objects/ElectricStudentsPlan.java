package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "electric_students_plan")
public class ElectricStudentsPlan extends StudentPlan{
    public ElectricStudentsPlan(Long id, Long studentId, Long courseId, float grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }
    public ElectricStudentsPlan() {

    }

    @Override
    public String toString() {
        return "ElectricStudentsPlan{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
