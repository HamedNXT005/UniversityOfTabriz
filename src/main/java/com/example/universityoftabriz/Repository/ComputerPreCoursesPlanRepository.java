package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryPreCoursesPlan;
import com.example.universityoftabriz.Objects.ComputerPreCoursesPlan;
import com.example.universityoftabriz.Objects.ElectricPreCoursesPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComputerPreCoursesPlanRepository extends JpaRepository<ComputerPreCoursesPlan, Long> {

    List<ComputerPreCoursesPlan> findByCourseId(Long course_id);

    List<ComputerPreCoursesPlan> findByTeacherId(Long teacherId);

    List<ComputerPreCoursesPlan> findByCourseIdAndTeacherId(Long courseId, Long teacherId);
    List<ComputerPreCoursesPlan> findByTeacherIdAndStatus(Long teacherId, boolean status);
}
