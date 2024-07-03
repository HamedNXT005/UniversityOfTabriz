package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "computer_report")
public class ComputerReport extends Report{
    public ComputerReport(Long id, Long teacherId, Long courseId, boolean attendencyStatus, String absents, Date dateOfSubmition, Time timeOfSubmition) {
        this.id = id;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.attendencyStatus = attendencyStatus;
        this.absents = absents;
        this.dateOfSubmition = dateOfSubmition;
        this.timeOfSubmition = timeOfSubmition;
    }
    public ComputerReport() {

    }

    @Override
    public String toString() {
        return "ComputerReport{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", courseId=" + courseId +
                ", attendencyStatus=" + attendencyStatus +
                ", absents='" + absents + '\'' +
                ", dateOfSubmition=" + dateOfSubmition +
                ", timeOfSubmition=" + timeOfSubmition +
                '}';
    }
}
