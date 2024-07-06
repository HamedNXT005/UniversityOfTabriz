package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ComputerPreCoursesPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComputerPreCoursesPlanRepository extends JpaRepository<ComputerPreCoursesPlan, Long> {

    List<ComputerPreCoursesPlan> findByCourseId(Long course_id);

    List<ComputerPreCoursesPlan> findByTeacherId(Long teacherId);

    List<ComputerPreCoursesPlan> findByCourseIdAndTeacherId(Long courseId, Long teacherId);
    List<ComputerPreCoursesPlan> findByTeacherIdAndStatus(Long teacherId, boolean status);

    Optional<ComputerPreCoursesPlan> findById(Long id);
}
