package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "computer_students_plan")
public class ComputerStudentsPlan extends StudentPlan{
    public ComputerStudentsPlan(Long id, Long studentId, Long courseId, float grade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }
    public ComputerStudentsPlan() {

    }

    @Override
    public String toString() {
        return "ComputerStudentsPlan{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
