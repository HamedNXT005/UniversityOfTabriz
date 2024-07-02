package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.MechanicReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface MechanicReportRepository extends JpaRepository<MechanicReport, Long> {


    List<MechanicReport> findByTeacherId(Long teacher_id);

    List<MechanicReport> findByCourseId(Long course_id);

    List<MechanicReport> findByTeacherIdAndCourseId(Long teacher_id, Long course_id);

    Optional<MechanicReport> findByDateOfSubmitionAndTeacherIdAndCourseId(Date date_of_submition,Long teacher_id, Long course_id);

}
