package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryReport;
import com.example.universityoftabriz.Objects.CivilReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ChemistryReportRepository extends JpaRepository<ChemistryReport, Long> {

    List<ChemistryReport> findByTeacherId(Long teacher_id);

    List<ChemistryReport> findByCourseId(Long course_id);

    List<ChemistryReport> findByTeacherIdAndCourseId(Long teacher_id, Long course_id);

    Optional<ChemistryReport> findByDateOfSubmitionAndTeacherIdAndCourseId(Date date_of_submition, Long teacher_id, Long course_id);

}
