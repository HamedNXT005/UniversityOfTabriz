package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.CivilReport;
import com.example.universityoftabriz.Objects.ComputerReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CivilReportRepository extends JpaRepository<CivilReport, Long> {

    List<CivilReport> findByTeacherId(Long teacher_id);

    List<CivilReport> findByCourseId(Long course_id);

    List<CivilReport> findByTeacherIdAndCourseId(Long teacher_id, Long course_id);

    Optional<CivilReport> findByDateOfSubmitionAndTeacherIdAndCourseId(Date date_of_submition, Long teacher_id, Long course_id);

}
