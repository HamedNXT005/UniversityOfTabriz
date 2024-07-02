package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "teachers_salary")
public class TeachersSalary extends Salary{
    public TeachersSalary(Long id, Long user_id, int hours_taught, Date year_ed, int semester, Long salary) {
        this.id = id;
        this.userId = user_id;
        this.hours_taught = hours_taught;
        this.yearEd = year_ed;
        this.semester = semester;
        this.salary = salary;
    }
    public TeachersSalary() {

    }

    @Override
    public String toString() {
        return "TeachersSalary{" +
                "id=" + id +
                ", user_id=" + userId +
                ", hours_taught=" + hours_taught +
                ", year_ed=" + yearEd +
                ", semester=" + semester +
                ", salary=" + salary +
                '}';
    }
}
