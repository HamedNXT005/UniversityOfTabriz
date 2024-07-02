package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "electric_students_plan")
public class ElectricStudentsPlan extends StudentPlan{
    public ElectricStudentsPlan(Long id, Long student_id, Long course_id, float grade) {
        this.id = id;
        this.studentId = student_id;
        this.courseId = course_id;
        this.grade = grade;
    }
    public ElectricStudentsPlan() {

    }

    @Override
    public String toString() {
        return "ElectricStudentsPlan{" +
                "id=" + id +
                ", student_id=" + studentId +
                ", course_id=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
