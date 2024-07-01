package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "civil_defined_courses")
public class CivilDefinedCourses extends DefinedCourses{
    public CivilDefinedCourses(Long id, Long teacher_id, Long course_id, Date primary_day, Time time_of_primary_day, Date secondary_day, Time time_of_secondary_day, int class_n, Date exam_date, int capacity) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.course_id = course_id;
        this.primary_day = primary_day;
        this.time_of_primary_day = time_of_primary_day;
        this.secondary_day = secondary_day;
        this.time_of_secondary_day = time_of_secondary_day;
        this.class_n = class_n;
        this.exam_date = exam_date;
        this.capacity = capacity;
    }
    public CivilDefinedCourses() {

    }

    @Override
    public String toString() {
        return "CivilDefinedCourses{" +
                "id=" + id +
                ", teacher_id=" + teacher_id +
                ", course_id=" + course_id +
                ", primary_day=" + primary_day +
                ", time_of_primary_day=" + time_of_primary_day +
                ", secondary_day=" + secondary_day +
                ", time_of_secondary_day=" + time_of_secondary_day +
                ", class_n=" + class_n +
                ", exam_date=" + exam_date +
                ", capacity=" + capacity +
                '}';
    }
}
