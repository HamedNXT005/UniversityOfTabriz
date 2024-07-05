package com.example.universityoftabriz.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "resources")
public class Resources {
    @Id
    private Long id;
    @Column (name = "year_ed")
    private int yearEd;
    private int semester;
    @Column(name = "total_budget")
    private Long totalBudget;
    @Column(name = "rate_sc")
    private Long rateSc;
    @Column(name = "rate_normal")
    private Long rateNormal;
    public Resources(Long id, int yearEd, int semester, Long totalBudget, Long rateSc, Long rateNormal) {
        this.id = id;
        this.yearEd = yearEd;
        this.semester = semester;
        this.totalBudget = totalBudget;
        this.rateSc = rateSc;
        this.rateNormal = rateNormal;
    }

    public Resources() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYearEd() {
        return yearEd;
    }

    public void setYearEd(int yearEd) {
        this.yearEd = yearEd;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Long getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(Long totalBudget) {
        this.totalBudget = totalBudget;
    }

    public Long getRateSc() {
        return rateSc;
    }

    public void setRateSc(Long rateSc) {
        this.rateSc = rateSc;
    }

    public Long getRateNormal() {
        return rateNormal;
    }

    public void setRateNormal(Long rateNormal) {
        this.rateNormal = rateNormal;
    }

    @Override
    public String toString() {
        return "Resources{" +
                "id=" + id +
                ", yearEd=" + yearEd +
                ", semester=" + semester +
                ", totalBudget=" + totalBudget +
                ", rateSc=" + rateSc +
                ", rateNormal=" + rateNormal +
                '}';
    }
}
