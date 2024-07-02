package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "mechanic_report")
public class MechanicReport extends Report{
    public MechanicReport(Long id, Long teacherId, Long courseId, boolean attendencyStatus, String absents, Date dateOfSubmition, Time timeOfSubmition) {
        this.id = id;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.attendencyStatus = attendencyStatus;
        this.absents = absents;
        this.dateOfSubmition = dateOfSubmition;
        this.timeOfSubmition = timeOfSubmition;
    }
    public MechanicReport() {

    }

    @Override
    public String toString() {
        return "MechanicReport{" +
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
