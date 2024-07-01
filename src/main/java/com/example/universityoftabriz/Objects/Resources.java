package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "resources")
public class Resources {
    @Id
    private Long id;
    private Date year_ed;
    private int semester;
    private Long total_budget;
    private Long rate_sc;
    private Long rate_normal;

    public Resources(Long id, Date year_ed, int semester, Long total_budget, Long rate_sc, Long rate_normal) {
        this.id = id;
        this.year_ed = year_ed;
        this.semester = semester;
        this.total_budget = total_budget;
        this.rate_sc = rate_sc;
        this.rate_normal = rate_normal;
    }

    public Resources() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getYear_ed() {
        return year_ed;
    }

    public void setYear_ed(Date year_ed) {
        this.year_ed = year_ed;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Long getTotal_budget() {
        return total_budget;
    }

    public void setTotal_budget(Long total_budget) {
        this.total_budget = total_budget;
    }

    public Long getRate_sc() {
        return rate_sc;
    }

    public void setRate_sc(Long rate_sc) {
        this.rate_sc = rate_sc;
    }

    public Long getRate_normal() {
        return rate_normal;
    }

    public void setRate_normal(Long rate_normal) {
        this.rate_normal = rate_normal;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "id=" + id +
                ", year_ed=" + year_ed +
                ", semester=" + semester +
                ", total_budget=" + total_budget +
                ", rate_sc=" + rate_sc +
                ", rate_normal=" + rate_normal +
                '}';
    }
}
