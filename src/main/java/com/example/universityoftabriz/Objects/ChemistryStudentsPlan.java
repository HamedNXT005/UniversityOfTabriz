package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "chemistry_students_plan")
public class ChemistryStudentsPlan extends StudentPlan{
    public ChemistryStudentsPlan(Long id, Long student_id, Long course_id, float grade) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
    }

    public ChemistryStudentsPlan() {

    }

    @Override
    public String toString() {
        return "ChemistryStudentsPlan{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", course_id=" + course_id +
                ", grade=" + grade +
                '}';
    }
}
