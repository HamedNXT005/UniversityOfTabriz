package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "chemistry_defined_courses")
public class ChemistryDefinedCourses extends DefinedCourses{
    public ChemistryDefinedCourses(Long id, Long teacherId, Long courseId, Date primaryDay, Time timeOfPrimaryDay, Date secondaryDay, Time timeOfSecondaryDay, int classN, Date examDate, int capacity) {
        this.id = id;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.primaryDay = primaryDay;
        this.timeOfPrimaryDay = timeOfPrimaryDay;
        this.secondaryDay = secondaryDay;
        this.timeOfSecondaryDay = timeOfSecondaryDay;
        this.classN = classN;
        this.examDate = examDate;
        this.capacity = capacity;
    }
    public ChemistryDefinedCourses() {

    }

    @Override
    public String toString() {
        return "ChemistryDefinedCourses{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", courseId=" + courseId +
                ", primaryDay=" + primaryDay +
                ", timeOfPrimaryDay=" + timeOfPrimaryDay +
                ", secondaryDay=" + secondaryDay +
                ", timeOfSecondaryDay=" + timeOfSecondaryDay +
                ", classN=" + classN +
                ", examDate=" + examDate +
                ", capacity=" + capacity +
                '}';
    }
}
