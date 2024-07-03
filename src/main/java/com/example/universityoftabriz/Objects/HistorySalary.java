package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "history_salary")
public class HistorySalary extends Salary{
    private Date payment_date;
    public HistorySalary(Long id, Long user_id, int hours_taught, Date year_ed, int semester, Long salary , Date payment_date) {
        this.id = id;
        this.userId = user_id;
        this.hoursTaught = hours_taught;
        this.yearEd = year_ed;
        this.semester = semester;
        this.salary = salary;
        this.payment_date = payment_date;
    }
    public HistorySalary() {

    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    @Override
    public String toString() {
        return "HistorySalary{" +
                "payment_date=" + payment_date +
                ", id=" + id +
                ", user_id=" + userId +
                ", hours_taught=" + hoursTaught +
                ", year_ed=" + yearEd +
                ", semester=" + semester +
                ", salary=" + salary +
                '}';
    }
}
