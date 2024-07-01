package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "history_salary")
public class HistorySalary extends Salary{
    private Date peyment_date;
    public HistorySalary(Long id, Long user_id, int houres_taught, Date year_ed, int semester, Long salary , Date peyment_date) {
        this.id = id;
        this.user_id = user_id;
        this.houres_taught = houres_taught;
        this.year_ed = year_ed;
        this.semester = semester;
        this.salary = salary;
        this.peyment_date = peyment_date;
    }
    public HistorySalary() {

    }

    public Date getPeyment_date() {
        return peyment_date;
    }

    public void setPeyment_date(Date peyment_date) {
        this.peyment_date = peyment_date;
    }

    @Override
    public String toString() {
        return "HistorySalary{" +
                "peyment_date=" + peyment_date +
                ", id=" + id +
                ", user_id=" + user_id +
                ", houres_taught=" + houres_taught +
                ", year_ed=" + year_ed +
                ", semester=" + semester +
                ", salary=" + salary +
                '}';
    }
}
