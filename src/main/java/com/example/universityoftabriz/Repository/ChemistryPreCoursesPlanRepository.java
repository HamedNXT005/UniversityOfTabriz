package com.example.universityoftabriz.Repository;

import com.example.universityoftabriz.Objects.ChemistryPreCoursesPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChemistryPreCoursesPlanRepository extends JpaRepository<ChemistryPreCoursesPlan, Long> {

    List<ChemistryPreCoursesPlan> findByCourseId(Long course_id);

    List<ChemistryPreCoursesPlan> findByTeacherId(Long teacherId);

    List<ChemistryPreCoursesPlan> findByCourseIdAndTeacherId(Long courseId, Long teacherId);

    List<ChemistryPreCoursesPlan> findByTeacherIdAndStatus(Long teacherId, boolean status);

    Optional<ChemistryPreCoursesPlan> findById(Long id);
}
