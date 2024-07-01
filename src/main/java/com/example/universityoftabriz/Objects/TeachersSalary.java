package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "teachers_salary")
public class TeachersSalary extends Salary{
    public TeachersSalary(Long id, Long user_id, int houres_taught, Date year_ed, int semester, Long salary) {
        this.id = id;
        this.user_id = user_id;
        this.houres_taught = houres_taught;
        this.year_ed = year_ed;
        this.semester = semester;
        this.salary = salary;
    }
    public TeachersSalary() {

    }

    @Override
    public String toString() {
        return "TeachersSalary{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", houres_taught=" + houres_taught +
                ", year_ed=" + year_ed +
                ", semester=" + semester +
                ", salary=" + salary +
                '}';
    }
}
