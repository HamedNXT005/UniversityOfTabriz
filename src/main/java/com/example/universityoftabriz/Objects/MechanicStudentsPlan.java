package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "mechanic_students_plan")
public class MechanicStudentsPlan extends StudentPlan{
    public MechanicStudentsPlan(Long id, Long student_id, Long course_id, float grade) {
        this.id = id;
        this.studentId = student_id;
        this.courseId = course_id;
        this.grade = grade;
    }

    public MechanicStudentsPlan() {

    }
    @Override
    public String toString() {
        return "MechanicStudentsPlan{" +
                "id=" + id +
                ", student_id=" + studentId +
                ", course_id=" + courseId +
                ", grade=" + grade +
                '}';
    }
}
