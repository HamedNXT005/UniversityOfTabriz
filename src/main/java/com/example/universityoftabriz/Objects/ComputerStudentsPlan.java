package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "computer_students_plan")
public class ComputerStudentsPlan extends StudentPlan{
    public ComputerStudentsPlan(Long id, Long student_id, Long course_id, float grade) {
        this.id = id;
        this.studentId = student_id;
        this.courseId = course_id;
        this.grade = grade;
    }
    public ComputerStudentsPlan() {

    }

    @Override
    public String toString() {
        return "ComputerStudentsPlan{" +
                "id=" + id +
                ", student_id=" + studentId +
                ", course_id=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
