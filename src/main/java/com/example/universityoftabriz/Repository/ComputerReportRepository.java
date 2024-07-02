package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerReport;
import com.example.universityoftabriz.Objects.MechanicReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ComputerReportRepository extends JpaRepository<ComputerReport, Long> {

    List<ComputerReport> findByTeacherId(Long teacher_id);

    List<ComputerReport> findByCourseId(Long course_id);

    List<ComputerReport> findByTeacherIdAndCourseId(Long teacher_id, Long course_id);

    Optional<ComputerReport> findByDateOfSubmitionAndTeacherIdAndCourseId(Date date_of_submition, Long teacher_id, Long course_id);

}
