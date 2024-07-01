package com.example.universityoftabriz.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "mechanic_pre_courses_plan")
public class MechanicPreCoursesPlan extends PreCoursesPlan{

    public MechanicPreCoursesPlan(Long id, Long course_id, Long teacher_id, int class_n, Date exam_date) {
        this.id = id;
        this.course_id = course_id;
        this.teacher_id = teacher_id;
        this.class_n = class_n;
        this.exam_date = exam_date;
    }
    public MechanicPreCoursesPlan() {

    }

    @Override
    public String toString() {
        return "MechanicPreCoursesPlan{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", teacher_id=" + teacher_id +
                ", class_n=" + class_n +
                ", exam_date=" + exam_date +
                '}';
    }
}
