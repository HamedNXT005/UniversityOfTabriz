package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "chemistry_report")
public class ChemistryReport extends Report{
    public ChemistryReport(Long id, Long teacher_id, Long course_id, boolean attendency_status, String absents, Date date_of_submition, Time time_of_submition) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.course_id = course_id;
        this.attendency_status = attendency_status;
        this.absents = absents;
        this.date_of_submition = date_of_submition;
        this.time_of_submition = time_of_submition;
    }

    public ChemistryReport() {

    }

    @Override
    public String toString() {
        return "ChemistryReport{" +
                "id=" + id +
                ", teacher_id=" + teacher_id +
                ", course_id=" + course_id +
                ", attendency_status=" + attendency_status +
                ", absents='" + absents + '\'' +
                ", date_of_submition=" + date_of_submition +
                ", time_of_submition=" + time_of_submition +
                '}';
    }
}
