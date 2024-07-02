package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.CivilPreCoursesPlan;
import com.example.universityoftabriz.Objects.ComputerPreCoursesPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CivilPreCoursesPlanRepository extends JpaRepository<CivilPreCoursesPlan, Long> {

    List<CivilPreCoursesPlan> findByCourseId(Long course_id);

    List<CivilPreCoursesPlan> findByTeacherId(Long teacherId);

    List<CivilPreCoursesPlan> findByCourseIdAndTeacherId(Long courseId, Long teacherId);

}
