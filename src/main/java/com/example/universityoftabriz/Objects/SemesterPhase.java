package com.example.universityoftabriz.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "semester_phase")
public class SemesterPhase {
    @Id
    private Long id;
    @Column(name = "phase_name")
    private String phaseName;
    private boolean status;

    public SemesterPhase(Long id, String phaseName, boolean status) {
        this.id = id;
        this.phaseName = phaseName;
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

    public String getPhaseName() {
        return phaseName;
    }

    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
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
                ", phaseName='" + phaseName + '\'' +
                ", status=" + status +
                '}';
    }
}
