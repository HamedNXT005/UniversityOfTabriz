package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "chemistry_students_plan")
public class ChemistryStudentsPlan extends StudentPlan{
    public ChemistryStudentsPlan(Long id, Long studentId, Long courseId, float grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }
    public ChemistryStudentsPlan() {

    }

    @Override
    public String toString() {
        return "ChemistryStudentsPlan{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
