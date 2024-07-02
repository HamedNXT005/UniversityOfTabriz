package com.example.universityoftabriz.Services;

import com.example.universityoftabriz.Objects.MechanicReport;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReportService<E> {
    List<E> getReportsByTeacherId(Long teacher_id);
    List<E> getReportsByCourseId(Long course_id);
    List<E> getReportsByTeacherIdAndCourseId(Long teacher_id, Long course_id);
    Optional<E> getReportSpecific(Date date, Long teacher_id, Long course_id);
}
