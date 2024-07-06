package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.CivilPreCoursesPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CivilPreCoursesPlanRepository extends JpaRepository<CivilPreCoursesPlan, Long> {

    List<CivilPreCoursesPlan> findByCourseId(Long course_id);

    List<CivilPreCoursesPlan> findByTeacherId(Long teacherId);

    List<CivilPreCoursesPlan> findByCourseIdAndTeacherId(Long courseId, Long teacherId);
    List<CivilPreCoursesPlan> findByTeacherIdAndStatus(Long teacherId, boolean status);

    Optional<CivilPreCoursesPlan> findById(Long id);
}
