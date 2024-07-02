package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicPreCoursesPlan;

import java.util.List;

public interface PreCoursesPlan<E> {
    List<E> getPrePlanByCourseId(Long course_id);

    List<E> getPrePlanByTeacherId(Long teacherId);

    List<E> getPrePlanByCourseIdAndTeacherId(Long courseId, Long teacherId);
}
