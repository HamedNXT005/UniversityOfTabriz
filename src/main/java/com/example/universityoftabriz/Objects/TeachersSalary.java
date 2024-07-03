package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "teachers_salary")
public class TeachersSalary extends Salary{
    public TeachersSalary(Long id, Long userId, int hoursTaught, Date yearEd, int semester, Long salary) {
        this.id = id;
        this.userId = userId;
        this.hoursTaught = hoursTaught;
        this.yearEd = yearEd;
        this.semester = semester;
        this.salary = salary;
    }

    public TeachersSalary() {

    }

    @Override
    public String toString() {
        return "TeachersSalary{" +
                "id=" + id +
                ", userId=" + userId +
                ", hoursTaught=" + hoursTaught +
                ", yearEd=" + yearEd +
                ", semester=" + semester +
                ", salary=" + salary +
                '}';
    }
}
