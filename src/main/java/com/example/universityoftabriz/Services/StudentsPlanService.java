package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicStudentsPlan;

import java.util.List;

public interface StudentsPlanService<E> {
    List<E> getPlanByStudentId(Long student_id);
    List<E> getPlanByCourseId(Long course_id);
    E findLastRecord();
}
