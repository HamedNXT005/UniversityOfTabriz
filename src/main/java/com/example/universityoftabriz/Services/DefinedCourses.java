package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicDefinedCourses;

import java.util.List;
import java.util.Optional;

public interface DefinedCourses<E>{

    List<E> getDCByTeacherId(Long teacherId);
    List<E> getDCByCourseId(Long courseId);

    Optional<E> getDCByTeacherIdAndCourseId(Long teacherId, Long courseId);
}
