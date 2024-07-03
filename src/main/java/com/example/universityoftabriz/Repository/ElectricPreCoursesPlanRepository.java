package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ElectricPreCoursesPlan;
import com.example.universityoftabriz.Objects.MechanicPreCoursesPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ElectricPreCoursesPlanRepository extends JpaRepository<ElectricPreCoursesPlan, Long> {

    List<ElectricPreCoursesPlan> findByCourseId(Long course_id);

    List<ElectricPreCoursesPlan> findByTeacherId(Long teacherId);

    List<ElectricPreCoursesPlan> findByCourseIdAndTeacherId(Long courseId, Long teacherId);
}
