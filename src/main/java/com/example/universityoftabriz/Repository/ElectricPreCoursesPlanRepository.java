package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ElectricPreCoursesPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ElectricPreCoursesPlanRepository extends JpaRepository<ElectricPreCoursesPlan, Long> {

    List<ElectricPreCoursesPlan> findByCourseId(Long course_id);

    List<ElectricPreCoursesPlan> findByTeacherId(Long teacherId);

    List<ElectricPreCoursesPlan> findByCourseIdAndTeacherId(Long courseId, Long teacherId);
    List<ElectricPreCoursesPlan> findByTeacherIdAndStatus(Long teacherId, boolean status);

    Optional<ElectricPreCoursesPlan> findById(Long id);
}
