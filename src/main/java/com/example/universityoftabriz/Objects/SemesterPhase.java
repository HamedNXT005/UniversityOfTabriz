package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "semester_phase")
public class SemesterPhase {
    @Id
    private Long id;
    private String phase_name;
    private boolean status;

    public SemesterPhase(Long id, String phase_name, boolean status) {
        this.id = id;
        this.phase_name = phase_name;
        this.status = status;
    }

    public SemesterPhase() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhase_name() {
        return phase_name;
    }

    public void setPhase_name(String phase_name) {
        this.phase_name = phase_name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SemesterPhase{" +
                "id=" + id +
                ", phase_name='" + phase_name + '\'' +
                ", status=" + status +
                '}';
    }
}
