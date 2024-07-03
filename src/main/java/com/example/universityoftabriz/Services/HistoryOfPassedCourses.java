package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicHistoryOfPassedCourses;

import java.util.List;

public interface HistoryOfPassedCourses <E>{
    List<E> getHistoryOfPCByStudentId(Long studentId);
    List<E> findByStudentIdAndCourseId(Long studentId, Long courseId);
}
